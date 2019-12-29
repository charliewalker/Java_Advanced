package Model.Interface;

import Model.Employee;

import java.util.List;

public interface DAOEmployees {
    void Insert(Employee employee);
    Employee getEmployeesById(int id);
    List<Employee> getAllEmployees();
    void Update(Employee employee);
    void Delete(int id);
}
