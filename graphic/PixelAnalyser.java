package pixelFinder.graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PixelAnalyser extends JFrame {

    PixelAnalyser(int w,int h,int ratio,int rate){
        super("pixel analyser");
        setVisible(true);
        setDefaultCloseOperation(3);
        setSize(w,h);
        try {
            new PixelAnalyserPanel(w,h,ratio,rate);
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

}
