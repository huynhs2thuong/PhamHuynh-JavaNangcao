package view;

import controller.NewStudentController;
import controller.NewStudentControllerImpl;
import model.Student;
import model.StudentsModel;
import model.TableObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentsView extends JFrame implements TableObserver {

    private JPanel rootPanel;

    private JTable studentsTable;
    private StudentsTableModel studentsTableModel;

    private JButton deleteButton;

    private JButton addButton;

    private StudentsModel model;

    public StudentsView(StudentsModel model) {

        this.model = model;
        this.model.registerObserver(this);

        setTitle("Student Manager");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(400, 500));
        pack();
        setVisible(true);

        studentsTableModel = new StudentsTableModel();
        studentsTable.setModel(studentsTableModel);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAddStudent(e);
            }
        });
        List<Student> students = this.model.getAllStudents();
        studentsTableModel.updateStudents(students);
    }

    private void onAddStudent(ActionEvent e) {
        NewStudentController controller = new NewStudentControllerImpl(this, model, new NewStudent());
        controller.newStudent();
    }

    @Override
    public void updateTable(List<Student> students) {
        studentsTableModel.updateStudents(students);
    }
}
