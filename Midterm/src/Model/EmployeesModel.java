package Model;

import Model.Interface.EmployeesTabelObserver;

import java.util.ArrayList;
import java.util.List;

public class EmployeesModel implements Model.Interface.EmployeesModel {
    private List<EmployeesTabelObserver> tableObserver =new ArrayList<>();;
    @Override
    public List<Employee> getAllEmployees() {
        DAOModel daoModel = new DAOModel();
        return  daoModel.getAllEmployees();
    }

    @Override
    public Employee getEmployeesByID(int id) {
        DAOModel daoModel = new DAOModel();
        daoModel.getEmployeesById(id);
        return daoModel.getEmployeesById(id);
    }

    @Override
    public void AddNewEmployees(Employee employee) {
        DAOModel daoModel = new DAOModel();
        daoModel.Insert(employee);
    }

    @Override
    public void DeleteEmployees(int id) {
        DAOModel daoModel = new DAOModel();
        daoModel.Delete(id);
    }

    @Override
    public void UpdateEmployees(Employee employee) {
        DAOModel daoModel = new DAOModel();
        daoModel.Update(employee);


    }

    @Override
    public void NotifyEmployees() {
        for (EmployeesTabelObserver tableObserver: tableObserver){
            tableObserver.updateobserver( getAllEmployees());
        }
    }

    @Override
    public void RegisterObserver(EmployeesTabelObserver tabelObserver) {
        if(!tableObserver.contains(tabelObserver)){
            tableObserver.add(tabelObserver);
        }
    }

    @Override
    public void UnRegisterObserver(EmployeesTabelObserver tabelObserver) {
        if(tableObserver.contains(tabelObserver)){
            tableObserver.remove(tabelObserver);
        }
    }
}
