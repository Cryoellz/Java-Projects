import javax.swing.*;

public class Main {
    public static void main(String[] args) {
     
        FormDef def = FormDef.EMPLOYEE;

        SmartCounter counter = new StandardCounter();
        String name = "Variation 1 (Standard)";

        SwingUtilities.invokeLater(() -> new EntryForm(def, counter, name).setVisible(true));
    }
}