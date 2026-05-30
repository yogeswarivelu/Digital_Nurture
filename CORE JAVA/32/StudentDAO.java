import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {

    // Insert Student Record
    public void insertStudent(Student student) {

        String query = "INSERT INTO students VALUES (?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, student.getId());
            pst.setString(2, student.getName());
            pst.setInt(3, student.getAge());
            pst.setString(4, student.getDepartment());

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Record Inserted Successfully");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Student Details
    public void updateStudent(Student student) {

        String query = "UPDATE students SET name=?, age=?, department=? WHERE id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, student.getName());
            pst.setInt(2, student.getAge());
            pst.setString(3, student.getDepartment());
            pst.setInt(4, student.getId());

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Record Updated Successfully");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}