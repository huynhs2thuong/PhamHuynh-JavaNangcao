package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

public class StudentDaoImpl implements StudentDao {

    public StudentDaoImpl() {

        Database db = new Database();
        String SQL_CREATE_STUDENTS_TABLE = "CREATE TABLE IF NOT EXISTS StudentsTable (\n"
                + "    ID integer PRIMARY KEY,\n"
                + "    FullName text NOT NULL,\n"
                + "    BirthYear integer\n"
                + ");";
        try {
            Statement statement = db.getConnection().createStatement();
            statement.execute(SQL_CREATE_STUDENTS_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void insertStudent(Student student) {

        Database db = new Database();
        final String SQL_CREATE_STUDENT = "INSERT INTO StudentsTable(FullName, BirthYear)" +
                "VALUES(?,?)";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_CREATE_STUDENT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, student.getFullName());
            ps.setInt(2, student.getBirthYear());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                student.setId(id);
                System.out.println("Inserted id: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public Student getStudentById(int id) {

        Student student = null;

        Database db = new Database();

        final String SQL_SELECT_STUDENT_BY_ID = "SELECT * FROM StudentsTable WHERE id=?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT_STUDENT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int studentId = rs.getInt(1);
                String fullName = rs.getString(2);
                int birthYear = rs.getInt(3);
                student = new Student(studentId, fullName, birthYear);
                System.out.println("ID: " + studentId + ", Full name: " + fullName + ", Birth Year: " + birthYear);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return student;
    }

    @Override
    public List<Student> getAllStudents() {

        List<Student> students = new Vector<>();

        Database db = new Database();

        final String SQL_SELECT_ALL_EMPLOYEES = "SELECT * FROM StudentsTable";
        try {
            Statement statement = db.getConnection().createStatement();

            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_EMPLOYEES);
            while (rs.next()) {

                int id = rs.getInt(1);
                String fullName = rs.getString(2);
                int birthYear = rs.getInt(3);

                Student student = new Student(id, fullName, birthYear);

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.close();

        return students;
    }

    @Override
    public void update(Student student) {
    }

    @Override
    public void delete(int id) {
    }
}
