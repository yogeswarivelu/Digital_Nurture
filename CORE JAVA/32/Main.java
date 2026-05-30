public class Main {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

Student s1 = new Student(104, "John", 20, "CSE");
dao.insertStudent(s1);

Student s2 = new Student(102, "John Updated", 21, "IT");
dao.updateStudent(s2);
    }
}