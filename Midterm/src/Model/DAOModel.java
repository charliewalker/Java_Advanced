package Model;

import Model.Interface.DAOEmployees;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOModel implements DAOEmployees {


    @Override
    public void Insert(Employee employee) {
        Database db = new Database();
        final String SQL_CREATE_EMPLOYEE = "INSERT INTO EmployeesTable(FullName, Gender)" +
                "VALUES(?,?)";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_CREATE_EMPLOYEE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getFullName());
            ps.setInt(2, employee.getGender()== true?1:0);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                System.out.println("Inserted id: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.CloseConnect();

    }

    @Override
    public Employee getEmployeesById(int id) {
        Database db = new Database();
        Employee employee = null;
        final String SQL_SELECT_EMPLOYEE_BY_ID = "SELECT * FROM EmployeesTable WHERE id=?";
        PreparedStatement ps = null;
        try {
            ps = db.getConnection().prepareStatement(SQL_SELECT_EMPLOYEE_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int ids = rs.getInt(1);
                String fullname = rs.getString(2);
                boolean gender = rs.getInt(3) == 1?true:false;
                employee =new Employee(ids,fullname,gender);
//                System.out.println("ID: " + id + ", Full name: " + fullname + ", Salary: " + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.CloseConnect();
        return employee;

    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee>employeeList = new ArrayList<>();
        Database db = new Database();
        final String SQL_SELECT_ALL_EMPLOYEES = "SELECT * FROM EmployeesTable";
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_EMPLOYEES);
            while (rs.next()) {

                int id = rs.getInt(1);
                String fullname = rs.getString(2);
                boolean gender = rs.getInt(3) == 1?true:false;
                employeeList.add(new Employee(id,fullname,gender));
//                System.out.println("ID: " + id + ", Full name: " + fullname + ", Salary: " + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.CloseConnect();
        return employeeList;
    }

    @Override
    public void Update(Employee employee) {
        Database db = new Database();
        final String SQL_UPDATE_EMPLOYEE_BY_ID = "UPDATE EmployeesTable SET FullName = ?, Gender = ? WHERE Id = ?";
        PreparedStatement ps = null;
        try {
            ps = db.getConnection().prepareStatement(SQL_UPDATE_EMPLOYEE_BY_ID);
            ps.setString(1, employee.getFullName());
            ps.setInt(2, employee.getGender()==true?1:0);
            ps.setInt(3, employee.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        db.CloseConnect();
    }



    @Override
    public void Delete(int id) {
        Database db = new Database();
        final String SQL_DELETE_EMPLOYEE_BY_ID = "DELETE FROM EmployeesTable WHERE id = ?";
        PreparedStatement ps = null;
        try {
            ps = db.getConnection().prepareStatement(SQL_DELETE_EMPLOYEE_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.CloseConnect();
    }
}
