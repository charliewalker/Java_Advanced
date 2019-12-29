import Model.EmployeesModel;
import View.ListEmploees;

public class Main {
    public static  void main(String [] args){
        ListEmploees AllEmployees = new ListEmploees(new EmployeesModel());
    }
}
