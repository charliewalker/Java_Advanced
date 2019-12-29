package Model;

public class Student {
    private int ID;
    private String Name;
    private int BirthYear;

    public Student(){

    }

    public int getBirthYear() {
        return BirthYear;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setBirthYear(int birthYear) {
        BirthYear = birthYear;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }
}
