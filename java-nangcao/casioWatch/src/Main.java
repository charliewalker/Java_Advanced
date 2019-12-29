import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static   JFrame frame = new JFrame("Digital Clock");
    public static void main(String [] args) throws IOException, InterruptedException {


       frame = new JFrame("Digital Clock");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new DigitalWatch().getRootpanel());
        frame.setPreferredSize(new Dimension(740,430));
        ImageIcon icon = new ImageIcon("asset\\image\\favicon.png");
        frame.setIconImage(icon.getImage());
        frame.pack();
        frame.setVisible(true);



    }

}
//add image to label
      /*
        BufferedImage img =  null;
        try
        {
            img = ImageIO.read(new File("C:\\Users\\Tokku\\Desktop\\java-nangcao\\casioWatch\\asset\\image\\background.png"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        JLabel background =new JLabel();
        background.setIcon(new ImageIcon(img));
        frame.getContentPane().add(background,BorderLayout.CENTER);
        */