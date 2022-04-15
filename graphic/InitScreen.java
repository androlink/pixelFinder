package pixelFinder.graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadPoolExecutor;

public class InitScreen implements ActionListener {

    JFrame init = new JFrame("set configuration");
    JLabel LWidth = new JLabel("width:");
    JLabel LHeight = new JLabel("height");
    JTextField TWidth =new JTextField();
    JTextField THeight = new JTextField();
    JButton start = new JButton("confirm");


    public InitScreen(){
        init.setSize(200,100);
        init.setResizable(false);
        init.setDefaultCloseOperation(3);
        init.getContentPane().setLayout(new BorderLayout());
        init.setVisible(true);
        start.addActionListener(this);

        JPanel WPanel = new JPanel(new BorderLayout());
        WPanel.add(LWidth,BorderLayout.WEST);
        WPanel.add(TWidth);

        JPanel HPanel = new JPanel(new BorderLayout());
        HPanel.add(LHeight,BorderLayout.WEST);
        HPanel.add(THeight);

        JPanel setting = new JPanel(new GridLayout());
        setting.add(WPanel);
        setting.add(HPanel);

        init.add(setting,BorderLayout.NORTH);
        init.add(start,BorderLayout.SOUTH);




        init.revalidate();
        init.repaint();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        boolean send =true;
        if(THeight.getText().isEmpty() || TWidth.getText().isEmpty())send=false;
        int w=Integer.parseInt(TWidth.getText());
        int h=Integer.parseInt(THeight.getText());


        if(send){
            init.setVisible(false);
            PixelAnalyser pixelAnalyser = new PixelAnalyser(w,h);

        }

    }

    public static void main(String[] args) {
        InitScreen init = new InitScreen();
    }

}
