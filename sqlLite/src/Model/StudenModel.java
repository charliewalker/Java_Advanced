package Model;

import java.util.List;

public interface StudenModel {
    List<Student> GetAllStudent();
    void AddStudent(Student student);
    void DeleteStudent(int id);
    void RegisterObserver(StudentTableObserver observer);
     void UnRegisterObserver(StudentTableObserver observer);
}
