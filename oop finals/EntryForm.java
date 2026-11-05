import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class EntryForm extends JFrame {
    private final FormDef def;
    private final SmartCounter counter;
    private final JTextField[] fields;
    private final DefaultTableModel model;
    private final JTable table;

    public EntryForm(FormDef def, SmartCounter counter, String variationName) {
        super(def.title + " - " + variationName);
        this.def = def;
        this.counter = counter;

        // INPUT PANEL
        JPanel form = new JPanel(new GridLayout(0, 4, 8, 6));
        form.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        fields = new JTextField[def.cols.length];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = new JTextField();
            form.add(new JLabel(def.labels[i] + ":"));
            form.add(fields[i]);
        }
        if (fields.length % 2 == 1) { form.add(new JLabel()); form.add(new JLabel()); }
        fields[0].setEditable(false);

        // BUTTONS
        JButton btnNew = new JButton("New");
        JButton btnSave = new JButton("Save");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");
        JButton btnClear = new JButton("Clear");
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        for (JButton b : new JButton[]{btnNew, btnSave, btnUpdate, btnDelete, btnClear}) buttons.add(b);

        // TABLE
        model = new DefaultTableModel(def.labels, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() >= 0) loadRowIntoFields(table.getSelectedRow());
        });

        JPanel top = new JPanel(new BorderLayout());
        top.add(form, BorderLayout.CENTER);
        top.add(buttons, BorderLayout.SOUTH);
        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        btnNew.addActionListener(e -> newRecord());
        btnSave.addActionListener(e -> save());
        btnUpdate.addActionListener(e -> update());
        btnDelete.addActionListener(e -> delete());
        btnClear.addActionListener(e -> newRecord());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        refreshTable();
        newRecord();
    }

    // HELPERS
    private void newRecord() {
        for (JTextField f : fields) f.setText("");
        table.clearSelection();
        fields[0].setText(counter.next(getLastCode()));
        fields[1].requestFocus();
    }

    // last inserted code = row with the highest auto-increment seq
    private String getLastCode() {
        String sql = "SELECT " + def.cols[0] + " FROM " + def.table + " ORDER BY seq DESC LIMIT 1";
        try (Connection c = DB.get(); Statement s = c.createStatement(); ResultSet rs = s.executeQuery(sql)) {
            return rs.next() ? rs.getString(1) : null;
        } catch (SQLException ex) {
            showError(ex);
            return null;
        }
    }

    private void refreshTable() {
        model.setRowCount(0);
        String sql = "SELECT " + String.join(",", def.cols) + " FROM " + def.table + " ORDER BY seq";
        try (Connection c = DB.get(); Statement s = c.createStatement(); ResultSet rs = s.executeQuery(sql)) {
            while (rs.next()) {
                Object[] row = new Object[def.cols.length];
                for (int i = 0; i < row.length; i++) row[i] = rs.getString(i + 1);
                model.addRow(row);
            }
        } catch (SQLException ex) { showError(ex); }
    }

    private void loadRowIntoFields(int r) {
        for (int i = 0; i < fields.length; i++) {
            Object v = model.getValueAt(r, i);
            fields[i].setText(v == null ? "" : v.toString());
        }
    }

    private void bind(PreparedStatement ps, int startIndex, int fromField) throws SQLException {
        for (int i = fromField; i < fields.length; i++) {
            String v = fields[i].getText().trim();
            ps.setObject(startIndex++, v.isEmpty() ? null : v);   // blank -> NULL
        }
    }

    private void save() {
        if (fields[1].getText().trim().isEmpty()) {
            warn("Please fill in the required fields.");
            return;
        }
        String marks = String.join(",", java.util.Collections.nCopies(def.cols.length, "?"));
        String sql = "INSERT INTO " + def.table + " (" + String.join(",", def.cols) + ") VALUES (" + marks + ")";
        try (Connection c = DB.get(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, fields[0].getText());
            bind(ps, 2, 1);
            ps.executeUpdate();
            refreshTable();
            newRecord();
        } catch (SQLException ex) { showError(ex); }
    }

    private void update() {
        if (table.getSelectedRow() < 0) { warn("Please select a row to update."); return; }
        StringBuilder set = new StringBuilder();
        for (int i = 1; i < def.cols.length; i++) set.append(i > 1 ? "," : "").append(def.cols[i]).append("=?");
        String sql = "UPDATE " + def.table + " SET " + set + " WHERE " + def.cols[0] + "=?";
        try (Connection c = DB.get(); PreparedStatement ps = c.prepareStatement(sql)) {
            bind(ps, 1, 1);
            ps.setString(def.cols.length, fields[0].getText());
            ps.executeUpdate();
            refreshTable();
            newRecord();
        } catch (SQLException ex) { showError(ex); }
    }

    private void delete() {
        if (table.getSelectedRow() < 0) { warn("Please select a row to delete."); return; }
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirm", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
        String sql = "DELETE FROM " + def.table + " WHERE " + def.cols[0] + "=?";
        try (Connection c = DB.get(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, fields[0].getText());
            ps.executeUpdate();
            refreshTable();
            newRecord();
        } catch (SQLException ex) { showError(ex); }
    }

    private void warn(String m) { JOptionPane.showMessageDialog(this, m, "Notice", JOptionPane.WARNING_MESSAGE); }

    private void showError(SQLException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}