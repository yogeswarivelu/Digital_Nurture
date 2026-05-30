import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASSWORD = "Yogi@005";

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}