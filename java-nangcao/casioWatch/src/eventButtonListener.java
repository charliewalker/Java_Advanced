import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class eventButtonListener implements ActionListener {

    private  String number;
    private JTextField textField;
    public  eventButtonListener(String num, JTextField text) throws IOException {
        number = num;
        textField = text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String value = textField.getText();
        value+= number;
        textField.setText(value);
    }
}
