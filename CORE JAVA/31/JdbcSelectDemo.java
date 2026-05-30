import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class JdbcSelectDemo {

    public static void main(String[] args) {

        // Database URL, username, password
        String url = "jdbc:mysql://localhost:3306/schooldb";
        String user = "root";
        String password = "Yogi@005";

        Connection conn = null;

        try {

            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            conn = DriverManager.getConnection(url, user, password);

            System.out.println("Database Connected Successfully\n");

            // 3. Create Statement
            Statement stmt = conn.createStatement();

            // 4. Execute Query
            String query = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(query);

            // 5. Process Result
            System.out.println("Student Records:");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String dept = rs.getString("department");

                System.out.println(
                        id + " | " + name + " | " + age + " | " + dept
                );
            }

            // 6. Close connection
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}