import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    //CHANGE PAG NASETUP NA MDB
    private static final String URL = "jdbc:mariadb://localhost:3306/oop_project";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection get() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
 }