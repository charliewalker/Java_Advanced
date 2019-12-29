package Model.Interface;

import Model.Employee;

import java.util.List;

public interface EmployeesModel {
        List<Employee> getAllEmployees();
        Employee getEmployeesByID(int id);
        void AddNewEmployees(Employee employee);
        void DeleteEmployees(int id);
        void UpdateEmployees(Employee employee);
        void NotifyEmployees();
        void  RegisterObserver(EmployeesTabelObserver tabelObserver);
        void UnRegisterObserver(EmployeesTabelObserver tabelObserver);

}
