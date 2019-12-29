import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Stopwatch extends Thread {
    private JPanel RootPanel;
    private JPanel paneltop;
    private JLabel lbltop;
    private JLabel lblright;
    private JPanel panelbbottom;
    private JLabel lblbottom;
    private JPanel panelCenter;
    private JLabel lblLeft;
    private JLabel lblHour;
    private JLabel lblMilisecond;
    private JLabel lblSecond;
    private JLabel lblMin;
    private JButton startStopButton;
    private JButton ChangmodeButton;
    private JLabel lblDot2;
    private JLabel lbldot;
    private JButton Resetbutton;
    boolean flag = false;
    Thread tStopWatch;
    int tic = 0;
    int sec = 0;
    int min = 0;
    int hour = 0;
    public Stopwatch() throws IOException {


        loadBorder();
        startStopButton.setEnabled(true);
        startStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                flag = !flag;
                if (flag){
                    startThread();
                    tStopWatch.start();
                }
                else {
                    interrupt();
                }

            }
        });
        ChangmodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.setVisible(true);
                DigitalWatch.frame.dispose();
            }
        });
        Resetbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 tic = 0;
                 sec = 0;
                 min = 0;
                 hour = 0;
                 lblMilisecond.setText("0.0");
                 lblSecond.setText("0.0");
                 lblMin.setText("0.0");
                 lblHour.setText("0.0");
            }
        });
    }

    public JPanel getRootPanel() {
        return RootPanel;
    }

    void startThread(){
        tStopWatch = new Thread(new Runnable() {
            @Override
            public void run() {


                try {

                    while (flag) {

                        tic++;
                        if (tic >= 1000) {
                            tic = 0;
                            sec++;

                        }
                        if (sec >= 60) {
                            min++;
                            sec = 0;
                        }
                        if (min >= 60) {
                            hour++;
                            min = 0;
                        }
                        if (hour >= 24) {
                            tic = 0;
                            sec = 0;
                            min = 0;

                        }
                        lblHour.setText(String.valueOf(hour));
                        lblMilisecond.setText(String.valueOf(tic));
                        lblMin.setText(String.valueOf(min));
                        lblSecond.setText(String.valueOf(sec));
                        sleep(1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    flag = false;
                    interrupt();
                }

            }
        });
    }
//    Thread tStopWatch = new Thread(new Runnable() {
//        @Override
//        public void run() {
//            int tic = 0;
//            int sec = 0;
//            int min = 0;
//            int hour = 0;
//
//                try {
//
//                    while (flag) {
//
//                        tic++;
//                        if (tic >= 1000) {
//                            tic = 0;
//                            sec++;
//
//                        }
//                        if (sec >= 60) {
//                            min++;
//                            sec = 0;
//                        }
//                        if (min >= 60) {
//                            hour++;
//                            min = 0;
//                        }
//                        if (hour >= 24) {
//                            tic = 0;
//                            sec = 0;
//                            min = 0;
//
//                        }
//                        lblHour.setText(String.valueOf(hour));
//                        lblMilisecond.setText(String.valueOf(tic));
//                        lblMin.setText(String.valueOf(min));
//                        lblSecond.setText(String.valueOf(sec));
//                        sleep(1);
//                }
//            } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    flag = false;
//                    interrupt();
//                }
//
//        }
//    });
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
}
