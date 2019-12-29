import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BasicTableModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"ID", "Full Name", "Salary"};

    private static final int MAX_ROW = 100;

    private Object[][] data = new Object[MAX_ROW][COLUMN_NAMES.length];
    private ArrayList<Object[]> dataList = new ArrayList<>();
    private int rowCount = 0;

    @Override
    public int getRowCount() {
        return dataList.size();
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
       // return data[rowIndex][columnIndex];
        return dataList.get(rowIndex)[columnIndex];
    }

    public void addRow(Object[] rowData) {

        /*for (int column = 0; column < COLUMN_NAMES.length; column++) {
           // data[rowCount][column] = rowData[column];

        }*/

    //    rowCount++;
        dataList.add(rowData);
        fireTableDataChanged();
    }
    public void removeRow (int rowIndex){
        if(rowIndex != -1) {
            dataList.remove(rowIndex);
            fireTableDataChanged();
        }
        }
    public void updateRow(int rowIndex,Object[] rowData){
        if(rowIndex != -1) {
            dataList.set(rowIndex,rowData);
            fireTableDataChanged();
        }
    }
    public void mouse(int rowIndex,Object[] rowData){
        if(rowIndex != -1) {
           rowData=dataList.get(rowIndex);
        }
    }
}