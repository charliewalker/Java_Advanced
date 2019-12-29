import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class tableForm extends JFrame{
    private JPanel rootPanel;
    private JTable table1;
    private JTextField textFieldId;
    private JTextField textFieldName;
    private JTextField textFieldsalary;
    private JButton btnAdd;
    private JButton btndelete;
    private JButton btnUpdate;

    public tableForm(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300,300));
        setContentPane(rootPanel);
        pack();
        tableModel model = new tableModel();
        table1.setModel(model);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id =textFieldId.getText();
                String name = textFieldName.getText();
                String salary = textFieldsalary.getText();
                model.addRow(new String[]{id, name, salary});
            }
        });
        btndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    int index = table1.getSelectedRow();
                    if (index != -1){
                        model.DeleteRow(index);
                    }
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = table1.getSelectedRow();
                String id =textFieldId.getText();
                String name = textFieldName.getText();
                String salary = textFieldsalary.getText();
                model.Update(index,new String[]{id, name, salary});
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int index = table1.getSelectedRow();
                if (index != -1){
                    model.GetrowData(index);

                    textFieldId.setText(model.GetrowData(index)[0].toString());
                    textFieldName.setText(model.GetrowData(index)[1].toString());
                    textFieldsalary.setText(model.GetrowData(index)[2].toString());

                }
            }
        });
    }
    public static void main(String [] args){
        tableForm tableForm = new tableForm();
        tableForm.setVisible(true);


    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
