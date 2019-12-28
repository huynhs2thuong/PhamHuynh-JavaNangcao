package view;

import model.Student;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class StudentsTableModel extends AbstractTableModel {

    private List<Student> students = new Vector<>();

    private static final String[] COLUMN_NAMES = {"ID", "Full Name", "Birth Year"};
    private static final int ID = 0;
    private static final int FULL_NAME = 1;
    private static final int BIRTH_YEAR = 2;

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Student student = students.get(rowIndex);
        if (columnIndex == ID) {
            return student.getId();
        } else if (columnIndex == FULL_NAME) {
            return student.getFullName();
        } else if (columnIndex == BIRTH_YEAR){
            return student.getBirthYear();
        }
        return null;
    }

    public void updateStudents(List<Student> students) {

        this.students.clear();
        this.students.addAll(students);
        fireTableDataChanged();
    }
}
