package Model;

import java.util.List;

public interface StudentDAO {
    //create
    void Insert(Student student);
    //read
    Student getStudentById(int id);
    List<Student> getAll();
    //update
    void update(Student student);
    //delete
    void Delete(int id);
}
