package model;

import java.util.List;

public interface StudentsModel {

    List<Student> getAllStudents();

    void addStudent(Student student);

    void deleteStudent(int id);

    void registerObserver(TableObserver observer);

    void unregisterObserver(TableObserver observer);
}
