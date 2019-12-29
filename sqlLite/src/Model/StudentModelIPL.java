package Model;

import java.util.List;
//Subject

public class StudentModelIPL implements StudenModel {

    public StudentModelIPL(){
        Database db = new Database();

    }

    private List<StudentTableObserver> tableObserver;
    @Override
    public List<Student> GetAllStudent() {
        StudentDAO dao=  new StudentDAOIPL();
        dao.getAll();
        return null;
    }

    @Override
    public void AddStudent(Student student) {
        StudentDAO dao= new StudentDAOIPL();
        dao.Insert(student);
        NotifyObserver();
    }

    @Override
    public void DeleteStudent(int id) {

    }

    @Override
    public void RegisterObserver(StudentTableObserver observer) {
        if(!tableObserver.contains(observer)){
               tableObserver.add(observer);
       }
    }

    @Override
    public void UnRegisterObserver(StudentTableObserver observer) {
        tableObserver.remove(observer);
    }
    void NotifyObserver(){
        List<Student> list = GetAllStudent();
        for (StudentTableObserver tableObserver: tableObserver){
            tableObserver.UpdateObserver(list);
        }
    }
}
