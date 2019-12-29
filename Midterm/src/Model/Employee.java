package Model;

public class Employee {
    private int ID;
    private String FullName;
    private boolean Gender;

    public Employee(){

    }
    public Employee(int ID , String FullName, boolean Gender ){
        this.ID = ID;
        this.FullName=FullName;
        this.Gender = Gender;
    }

    public Employee(String FullName, boolean Gender) {
        this.FullName=FullName;
        this.Gender = Gender;
    }

    public int getID() {
        return ID;
    }

    public String getFullName() {
        return FullName;
    }

    public boolean getGender(){
        return Gender;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public void setGender(boolean gender) {
        Gender = gender;
    }
}
