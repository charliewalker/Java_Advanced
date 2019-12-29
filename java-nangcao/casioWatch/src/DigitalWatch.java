import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DigitalWatch {
    private JPanel paneltop;
    private JLabel lbltop;
    private JLabel lblright;
    private JPanel panelbbottom;
    private JLabel lblbottom;
    private JPanel panelCenter;
    private JLabel lblHour;
    private JLabel lblMin;
    private JLabel lblSecond;
    private JLabel lblMilisecond;
    private JLabel lblDot2;
    private JLabel lbldot;
    private JButton startStopButton;
    private JButton ChangmodeButtons;
    private JLabel lblLeft;
    private JPanel Rootpanel;
    public static JFrame frame = new JFrame();
    public  DigitalWatch() throws IOException {
        loadBorder();
        DigitalWatch.start();
        ChangmodeButtons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    frame.setContentPane(new Stopwatch().getRootPanel());
                    frame.setPreferredSize(new Dimension(740,430));
                    ImageIcon icon = new ImageIcon("asset\\image\\favicon.png");
                    frame.setIconImage(icon.getImage());
                    frame.pack();
                    frame.setVisible(true);

                    Main.frame.setVisible(false);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    void loadBorder() throws IOException {
        BufferedImage top =null, left= null, right= null,bottom=null;

        top = ImageIO.read(new File("asset/image/top.png"));
        left = ImageIO.read(new File("asset/image/left.png"));
        right = ImageIO.read(new File("asset/image/right.png"));
        bottom = ImageIO.read(new File("asset/image/bottom.png"));
        lbltop.setIcon(new ImageIcon(top));
        lblLeft.setIcon(new ImageIcon(left));
        lblright.setIcon(new ImageIcon(right));
        lblbottom.setIcon(new ImageIcon(bottom));

    }
    Thread DigitalWatch = new Thread(new Runnable() {

        @Override
        public void run() {

            while (true){
                int sec = java.time.LocalTime.now().getSecond();
                int min = java.time.LocalTime.now().getMinute();
                int hour = java.time.LocalTime.now().getHour();

                lblMilisecond.setText(String.valueOf(sec));
                lblSecond.setText(String.valueOf(min));
                lblMin.setText(String.valueOf(hour));
                lblHour.setVisible(false);
                lbldot.setVisible(false);
                startStopButton.setEnabled(false);
            }

        }
    });
    public JPanel getRootpanel() {
        return Rootpanel;
    }
}
