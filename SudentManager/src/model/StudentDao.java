package model;

import java.util.List;

// CRUD
public interface StudentDao {

    // Create
    void insertStudent(Student student);

    // Read
    Student getStudentById(int id);

    List<Student> getAllStudents();

    // Update
    void update(Student student);

    // Delete
    void delete(int id);
}
