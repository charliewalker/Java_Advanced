package View;

import Model.Employee;
import Model.Interface.EmployeesTabelObserver;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class EmployeesTableModel extends AbstractTableModel implements EmployeesTabelObserver {
    List<Employee> employeeList = new ArrayList<>();

    public EmployeesTableModel (List<Employee> employeeList){
        this.employeeList =employeeList;
    }
    public EmployeesTableModel (){

    }
    private static final String [] COLUMN_NAME = {"ID","Name","Male"};
    private static final int ID = 0;
    private static final int FULL_NAME = 1;
    private static final int BIRTH_YEAR = 2;
    @Override
    public int getRowCount() {
        return employeeList.size();
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
        Employee employee = employeeList.get(rowIndex);
        if (columnIndex == ID){
            return employee.getID();
        }
        else if(columnIndex == FULL_NAME){
            return employee.getFullName();
        }
        else if(columnIndex ==BIRTH_YEAR){
            return employee.getGender();
        }
        return null;
    }

    @Override
    public void updateobserver(List<Employee> list) {
        employeeList.clear();
        employeeList.addAll(list);
        fireTableDataChanged();
    }
}
