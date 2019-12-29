package Controller;

import Model.Employee;
import Model.Interface.EmployeesModel;
import View.Template;

import javax.swing.*;
import java.awt.*;

public class EmployeesController implements AddBehavior ,DeleteBehavior,UpdateBehavior{


    private Component component;
    private EmployeesModel employeesModel;
    private Template view;
    public EmployeesController(EmployeesModel employeesModel){
        this.employeesModel = employeesModel;
    }

    public EmployeesController (Component component, EmployeesModel employeesModel, Template view){
        this.component = component;
        this.employeesModel = employeesModel;
        this.view = view;
    }
    @Override
    public void OpenDialogAddEmployees() {
       int Option= JOptionPane.showConfirmDialog(component,view.getRootpanel(),"Add New Employees",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
        if (JOptionPane.YES_OPTION ==Option){
            String Fullname= view.getTfFullName();
            boolean Male = view.getMaleCheckBox();
            Employee employee = new Employee(Fullname,Male);
            employeesModel.AddNewEmployees(employee);
            employeesModel.NotifyEmployees();
        }
    }

    @Override
    public void DeleteEmployees(int id) {
        employeesModel.DeleteEmployees(id);
        employeesModel.NotifyEmployees();
    }

    @Override
    public void UpdateEmployees(Employee employee) {
        view.getTF().setText(employee.getFullName());
        if (employee.getGender()) {
            view.getChekBox().setSelected(true);
        } else {
            view.getChekBox().setSelected(false);
        }



        int Option= JOptionPane.showConfirmDialog(component,view.getRootpanel(),"Update Employees",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);

        if (JOptionPane.YES_OPTION ==Option){
            String Fullname= view.getTfFullName();
            boolean Male = view.getMaleCheckBox();
            Employee UpdateEmployee = new Employee(employee.getID(),Fullname,Male);
            employeesModel.UpdateEmployees(UpdateEmployee );
            employeesModel.NotifyEmployees();
        }
    }
}
