package pixelFinder.graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadPoolExecutor;

public class InitScreen implements ActionListener {

    JFrame init = new JFrame("set configuration");
    JLabel LWidth = new JLabel("width:");
    JLabel LHeight = new JLabel("height:");
    JLabel LRatio = new JLabel("ratio:");
    JLabel LRate = new JLabel("frame rate:");
    JTextField TWidth =new JTextField(6);
    JTextField THeight = new JTextField(6);
    JTextField TRatio =new JTextField(6);
    JTextField TRate = new JTextField(6);
    JButton start = new JButton("Confirm");


    public InitScreen(){
        init.setSize(200,100);
        init.setResizable(false);
        init.setDefaultCloseOperation(3);
        start.addActionListener(this);

        JPanel global = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor=GridBagConstraints.WEST;
        constraints.insets = new Insets(5,5,5,5);

        constraints.gridx=0;
        constraints.gridy=0;
        global.add(LWidth,constraints);

        constraints.gridx=1;
        global.add(TWidth,constraints);

        constraints.gridx=0;
        constraints.gridy=1;
        global.add(LHeight,constraints);

        constraints.gridx=1;
        global.add(THeight,constraints);

        constraints.gridx=0;
        constraints.gridy=2;
        global.add(LRate,constraints);

        constraints.gridx=1;
        global.add(TRate,constraints);

        constraints.gridx=0;
        constraints.gridy=3;
        global.add(LRatio,constraints);

        constraints.gridx=1;
        global.add(TRatio,constraints);

        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=2;
        constraints.anchor=GridBagConstraints.CENTER;
        global.add(start,constraints);

        global.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Login Panel"));

        init.add(global);
        init.pack();
        init.setLocationRelativeTo(null);
        init.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        boolean send = true;

        int w=Integer.parseInt(TWidth.getText());
        int h=Integer.parseInt(THeight.getText());
        int r=Integer.parseInt(TRatio.getText());
        int s=Integer.parseInt(TRate.getText());

        if(send){
            init.setVisible(false);
            new PixelAnalyser(w,h,r,s);

        }

    }

    public static void main(String[] args) {
        InitScreen init = new InitScreen();
    }

}
