package view;

import javax.swing.*;

public class NewStudent {
    private JPanel rootPanel;
    private JTextField fullNameTextField;
    private JTextField birthYearTextField;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public String getFullName() {
        return fullNameTextField.getText();
    }

    public int getBirthYear() {
        return Integer.parseInt(birthYearTextField.getText());
    }
}
