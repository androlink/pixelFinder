package pixelFinder.graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadPoolExecutor;

public class InitScreen implements ActionListener {



    JFrame init = new JFrame("set configuration");
    JLabel resolution = new JLabel("resolution:");
    JLabel LWidth = new JLabel("width:");
    JLabel LHeight = new JLabel("height");
    JLabel LRatio = new JLabel("ratio:");
    JTextArea TWidth =new JTextArea();
    JTextArea THeight = new JTextArea();
    JTextArea TRatio = new JTextArea();

    JButton start = new JButton("confirm");




    public InitScreen(){
        init.setSize(200,200);
        init.setResizable(false);
        init.setDefaultCloseOperation(3);
        init.getContentPane().setLayout(new BorderLayout());
        init.setVisible(true);
        start.addActionListener(this);

        JPanel center = new JPanel(new GridLayout(3,2));
        init.add(resolution, BorderLayout.NORTH);
        init.add(center,BorderLayout.CENTER);
        init.add(start,BorderLayout.SOUTH);





    }



    @Override
    public void actionPerformed(ActionEvent e) {
        boolean send =true;






        if(send){
            init.setVisible(false);
            //PixelFinder.update(100,100,1);

        }

    }
}
