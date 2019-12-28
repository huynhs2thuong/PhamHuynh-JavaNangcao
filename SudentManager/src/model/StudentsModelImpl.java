package model;

import java.util.List;
import java.util.Vector;

public class StudentsModelImpl implements StudentsModel {

    private List<TableObserver> tableObservers = new Vector<>();

    @Override
    public List<Student> getAllStudents() {
        StudentDao dao = new StudentDaoImpl();
        return dao.getAllStudents();
    }

    @Override
    public void addStudent(Student student) {
        StudentDao dao = new StudentDaoImpl();
        dao.insertStudent(student);
        notifyObservers();
    }

    @Override
    public void deleteStudent(int id) {
    }

    @Override
    public void registerObserver(TableObserver observer) {
        if (!tableObservers.contains(observer))
            tableObservers.add(observer);
    }

    @Override
    public void unregisterObserver(TableObserver observer) {
        tableObservers.remove(observer);
    }

    private void notifyObservers() {
        List<Student> students = getAllStudents();
        for (TableObserver observer: tableObservers) {
            observer.updateTable(students);
        }
    }
}
