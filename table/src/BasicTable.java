import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class BasicTable extends JFrame implements ActionListener, MouseListener {
    public BasicTable() {
        initComponents();

        butAdd.addActionListener(this);
        butDelete.addActionListener(this);
        butUpdate.addActionListener(this);

        tableList.addMouseListener(this);

        tableTitle.add("ID");
        tableTitle.add("Name");
        tableTitle.add("Phone");

        tableList.setModel(new DefaultTableModel(tableRecords, tableTitle));

        setSize(500, 600);
        setLocationRelativeTo(null);

        setTitle("Basic Table");
    }

    Vector tableRecords = new Vector();
    Vector tableTitle = new Vector();
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == butAdd) {
            Vector record = new Vector();
            record.add(txtId.getText());
            record.add(txtName.getText());
            record.add(txtPhone.getText());
            tableRecords.add(record);
            tableList.setModel(new DefaultTableModel(tableRecords, tableTitle));
            JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
            txtId.setText("");
            txtName.setText("");
            txtPhone.setText("");
            txtId.requestFocus();
        }

        if (e.getSource() == butDelete) {
            int iDongDaChon = tableList.getSelectedRow();
            if (iDongDaChon == -1) {
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn dong cần xóa");
            } else {
                Vector vDongDaChon = (Vector) tableRecords.get(iDongDaChon);
                String idCuaDongDaChon = vDongDaChon.get(0).toString();
                if (JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa dòng đã chọn có id: " + idCuaDongDaChon, "Lua chon", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    tableRecords.remove(iDongDaChon);
                    tableList.setModel(new DefaultTableModel(tableRecords, tableTitle));
                }
            }
        }

        if (e.getSource() == butUpdate) {
            int iDongDaChon = tableList.getSelectedRow();
            if (iDongDaChon == -1) {
                JOptionPane.showMessageDialog(rootPane, "Xin vui lòng chọn dòng cần sửa");
            } else {
                Vector record = new Vector();
                record.add(txtViewId.getText());
                record.add(txtViewName.getText());
                record.add(txtViewPhone.getText());
                tableRecords.set(iDongDaChon, record);
                tableList.setModel(new DefaultTableModel(tableRecords, tableTitle));
           JOptionPane.showMessageDialog(rootPane, "Cập nhật xong");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tableList) {
            int iDongDaChon = tableList.getSelectedRow();
            if (iDongDaChon != -1) {
                Vector vDongDaChon = (Vector) tableRecords.get(iDongDaChon);
                String id = vDongDaChon.get(0).toString();
                String name = vDongDaChon.get(1).toString();
                String phone = vDongDaChon.get(2).toString();
                txtViewId.setText(id);
                txtViewName.setText(name);
                txtViewPhone.setText(phone);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        butAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableList = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        butDelete = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtViewId = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtViewName = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtViewPhone = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        butUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(3, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Danh Sách");
        jPanel1.add(jLabel1);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel2.setText(" ID: ");
        jPanel4.add(jLabel2, java.awt.BorderLayout.WEST);
        jPanel4.add(txtId, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel3.setText(" Name: ");
        jPanel5.add(jLabel3, java.awt.BorderLayout.WEST);
        jPanel5.add(txtName, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel4.setText(" Phone: ");
        jPanel6.add(jLabel4, java.awt.BorderLayout.WEST);
        jPanel6.add(txtPhone, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel6);

        jPanel1.add(jPanel2);

        butAdd.setText("Thêm");

        jPanel3.add(butAdd);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setViewportView(tableList);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel7.setLayout(new java.awt.GridLayout(3, 0));

        butDelete.setText("Xóa");
        jPanel13.add(butDelete);

        jPanel7.add(jPanel13);

        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        jPanel9.setLayout(new java.awt.BorderLayout());

        jLabel6.setText(" ID: ");
        jPanel9.add(jLabel6, java.awt.BorderLayout.WEST);
        jPanel9.add(txtViewId, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel9);

        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabel7.setText(" Name: ");
        jPanel10.add(jLabel7, java.awt.BorderLayout.WEST);
        jPanel10.add(txtViewName, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel10);

        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel8.setText(" Phone: ");
        jPanel11.add(jLabel8, java.awt.BorderLayout.WEST);
        jPanel11.add(txtViewPhone, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel11);

        jPanel7.add(jPanel8);

        butUpdate.setText("Sửa");
        jPanel12.add(butUpdate);

        jPanel7.add(jPanel12);

        getContentPane().add(jPanel7, java.awt.BorderLayout.PAGE_END);

        pack();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BasicTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BasicTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BasicTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BasicTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BasicTable().setVisible(true);
            }
        });
    }

    private javax.swing.JButton butAdd;
    private javax.swing.JButton butDelete;
    private javax.swing.JButton butUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableList;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtViewId;
    private javax.swing.JTextField txtViewName;
    private javax.swing.JTextField txtViewPhone;
}