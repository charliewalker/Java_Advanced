package View;

import Controller.NewStudentImpl;
import Model.StudenModel;
import Model.StudentTableObserver;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudenListView extends  JFrame {
    private JPanel rootPanel;
    private JTable table1;
    private JButton deleteButton;
    private JButton addButton;
    private studentTableModel model;
    private StudenModel models;
    public StudenListView(StudenModel models){
        this.models = models;
        setTitle("Student View");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        setContentPane(rootPanel);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        model= new studentTableModel();
        table1.setModel( model);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addnewStudent();
            }
        });
    }

    private void addnewStudent() {
        NewStudentImpl newStudent = new NewStudentImpl(this,new AddNewStudent(),models);
        newStudent.newStudent();
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
//    public void RegisterObserver(StudentTableObserver observer){
//        if(!tableObserver.contains(observer)){
//
//        }
//
//    }
//    public void UnRegisterObserver(){
//
//    }
}
