package View;

import Model.Student;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class studentTableModel extends AbstractTableModel  {

    public studentTableModel(){

    }
    private   List<Student> studentList = new Vector<>();

    private static final String [] COLUMN_NAME = {"ID","Name","BirthYear"};
    private static final int ID = 0;
    private static final int FULL_NAME = 1;
    private static final int BIRTH_YEAR = 2;

    @Override
    public int getRowCount() {
        return studentList.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAME.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAME[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = studentList.get(rowIndex);
        if (columnIndex == ID){
            return student.getID();
        }
        else if(columnIndex == FULL_NAME){
            return student.getName();
        }
        else if(columnIndex ==BIRTH_YEAR){
            return student.getBirthYear();
        }
        return null;
    }
}
