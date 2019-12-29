package View;

import javax.swing.*;
import java.awt.*;

public class AddNewStudent extends JFrame {
    private JPanel RootPanel;
    private JTextField tfFullName;
    private JTextField tf_BirthYear;

    public JPanel getRootPanel() {
        return RootPanel;
    }

    public String getTfFullName() {
        return tfFullName.getText();
    }

    public int getTf_BirthYear() {
        return Integer.valueOf(tf_BirthYear.getText());
    }
}
