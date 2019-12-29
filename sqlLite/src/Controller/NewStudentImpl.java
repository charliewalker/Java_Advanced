package Controller;

import Model.StudenModel;
import Model.Student;
import View.AddNewStudent;

import javax.swing.*;
import java.awt.*;

public class NewStudentImpl implements NewStudentController {
    private Component component;
    private StudenModel model;
    private AddNewStudent view;
    public  NewStudentImpl(Component component,AddNewStudent view,StudenModel model){
            this.component = component;
            this.view = view;
            this.model = model;
    }
    @Override
    public void newStudent() {
     int Option =   JOptionPane.showConfirmDialog(component,view.getRootPanel(),"Add New ",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
    if(Option == JOptionPane.YES_OPTION){
      String FullName =  view.getTfFullName();
      int BirthYear =  view.getTf_BirthYear();
        Student student = new Student();
        student.setName(FullName);
        student.setBirthYear(BirthYear);
        model.AddStudent(student);
    }
    }
}
