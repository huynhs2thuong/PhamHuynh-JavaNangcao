import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

public class TableBasic extends JFrame{
    private JPanel rootPanel;
    private JTextField txtID;
    private JTextField txtFullName;
    private JTextField txtSalary;
    private JButton btnAdd;
    private JTable table;
    private JButton btnDelete;
    private JButton btnUpdate;

    public TableBasic() {
        setTitle("Basic Table");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(800, 600));
        pack();
        BasicTableModel model = new BasicTableModel();
        table.setModel(model);

        model.addRow(new String[]{"01", "huynh", "100"});
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String ID = txtID.getText();
                String Name = txtFullName.getText();
                String Salary = txtSalary.getText();
                model.addRow(new String[]{ID, Name, Salary});
                JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
                txtID.setText("");
                txtFullName.setText("");
                txtSalary.setText("");
                txtID.requestFocus();
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int iDongDaChon = table.getSelectedRow();
                model.removeRow(iDongDaChon);
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int iDongDaChon = table.getSelectedRow();
                String ID = txtID.getText();
                String Name = txtFullName.getText();
                String Salary = txtSalary.getText();
                model.updateRow(iDongDaChon,new String[]{ID, Name, Salary});

            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              int row = table.rowAtPoint(e.getPoint());
              int col = table.columnAtPoint(e.getPoint());
              if(row >= 0 && col >= 0 ){
                  String ID =  table.getValueAt(row, 0).toString();
                  txtID.setText(ID);
                  String Name =  table.getValueAt(row, 1).toString();
                  txtFullName.setText(Name);
                  String Sa =  table.getValueAt(row, 2).toString();
                  txtSalary.setText(Sa);
              }

            }
        });
    }
    public static void main(String[] args) {

        TableBasic frame = new TableBasic();
        frame.setVisible(true);
    }
}
