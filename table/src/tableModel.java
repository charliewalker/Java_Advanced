import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class tableModel extends AbstractTableModel {
    private static final String[] COLUMN_NAMES = {"ID", "Full Name", "Salary"};
    private static final int MAX_ROW = 100;
    private Object[][] data = new Object[MAX_ROW][COLUMN_NAMES.length];
    private ArrayList<Object[]> arrayList = new ArrayList();
    private int rowCount = 0;
    @Override
    public int getRowCount() {
        return arrayList.size();
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
        return arrayList.get(rowIndex)[columnIndex];
    }

    public void addRow(Object[] rowData) {

        arrayList.add(rowData);
        fireTableDataChanged();
    }
    public void DeleteRow(int index) {
        if (index > -1 && index < arrayList.size()){
            arrayList.remove(index);
            fireTableDataChanged();
        }

    }
    public Object[] GetrowData(int index) {
        if (index > -1 && index < arrayList.size()){
            return  arrayList.get(index);
        }

        return null;
    }
    public void  Update(int index,Object[] rowData ){

        arrayList.set(index,rowData);
        fireTableDataChanged();
    }
}
