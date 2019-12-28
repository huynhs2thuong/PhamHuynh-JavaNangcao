package controller;

import model.Student;
import model.StudentsModel;
import view.NewStudent;

import javax.swing.*;
import java.awt.*;

public class NewStudentControllerImpl implements NewStudentController {

    private Component parent;

    private StudentsModel model;

    private NewStudent view;

    public NewStudentControllerImpl(Component parent, StudentsModel model, NewStudent view) {
        this.parent = parent;
        this.model = model;
        this.view = view;
    }

    @Override
    public void newStudent() {

        int option = JOptionPane.showConfirmDialog(parent,
                view.getRootPanel(),
                "New Student",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
            String fullName = view.getFullName();
            int birthYear = view.getBirthYear();

            Student student = new Student();
            student.setFullName(fullName);
            student.setBirthYear(birthYear);

            model.addStudent(student);
        }
    }
}
