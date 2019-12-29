package View;

import Controller.EmployeesController;
import Model.Employee;
import Model.Interface.EmployeesModel;
import Model.Interface.EmployeesTabelObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ListEmploees extends  JFrame {
    private JPanel rootpanel;
    private JTable tableEmployees;
    private JButton ADDButton;
    private JButton DELETEButton;
    private EmployeesModel model;
    public ListEmploees(EmployeesModel model){
        this.model = model;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        setContentPane(rootpanel);
        pack();
        setVisible(true);
        EmployeesTableModel modelTable = new EmployeesTableModel(model.getAllEmployees());

        model.RegisterObserver(modelTable);

        tableEmployees.setModel(modelTable);

        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddNewEmployees();
            }
        });
        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = tableEmployees.getSelectedRow();

                if (index != -1){
                    int id = (int) tableEmployees.getValueAt(index,0);
                    DeleteEmployees(id);
                }

            }
        });
        tableEmployees.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = tableEmployees.getSelectedRow();

                if (index != -1){
                    String FullName = (String) tableEmployees.getValueAt(index,1);
                    boolean Gender = (boolean) tableEmployees.getValueAt(index,2);
                    int id = (int) tableEmployees.getValueAt(index,0);
                    Employee employee = new Employee(id,FullName,Gender);
                    updateEmployees(employee);
                }
            }
        });
    }

    private void updateEmployees(Employee employee) {
        EmployeesController UpdateEmployees = new EmployeesController(this,model,new Template());
        UpdateEmployees.UpdateEmployees(employee);
    }

    private void DeleteEmployees(int id) {
        EmployeesController DeleteEmployees = new EmployeesController(model);
        DeleteEmployees.DeleteEmployees(id);

    }

    private void AddNewEmployees() {
        EmployeesController addEmployees = new EmployeesController(this,model,new Template());
        addEmployees.OpenDialogAddEmployees();


    }


    public JPanel getRootpanel() {
        return rootpanel;
    }


}
