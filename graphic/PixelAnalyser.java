package pixelFinder.graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PixelAnalyser extends JFrame {

    PixelAnalyserPanel pixelAnalyserPanel;
    PixelAnalyser(int w,int h){
        super("pixel analyser");
        setVisible(true);
        setDefaultCloseOperation(3);
        setSize(w,h);
        try {
            pixelAnalyserPanel = new PixelAnalyserPanel(w,h,1);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        add(pixelAnalyserPanel);

        //pixelAnalyserPanel.run();
    }

}
