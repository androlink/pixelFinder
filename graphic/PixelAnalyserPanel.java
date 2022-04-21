package pixelFinder.graphic;


import pixelFinder.core.PixelFinderMotor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PixelAnalyserPanel extends JPanel{





    BufferedImage resultante;

    PixelFinderMotor target;



    public PixelAnalyserPanel(int width, int height, int ratio) throws AWTException {
        target = new PixelFinderMotor(width,height,ratio,this);

        target.start();



        target.getTolerences().addTolerence(0.1f,0.1f,0.1f);


    }

    public void setTarget(PixelFinderMotor target) {
        this.target = target;
    }

    public void refresh(BufferedImage resultante){
        this.resultante=resultante;
        paintComponent(this.getGraphics());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(resultante,0,0,this.getParent().getWidth(),this.getParent().getHeight(),this);

    }
    public PixelFinderMotor getTarget() {
        return target;
    }

}
