package pixelFinder.core;

import pixelFinder.graphic.PixelAnalyserPanel;
import pixelFinder.modifier.Tolerance;
import pixelFinder.modifier.ToleranceManager;

import java.awt.*;
import java.awt.image.BufferedImage;
//FIXME suprimer le thread

public class PixelFinderMotor extends Thread {

    PixelAnalyserPanel target;

    ToleranceManager tolerences = new ToleranceManager();

    public int ratio=5;
    public int width=1920/ratio;
    public int height=1080/ratio;
    public int rate=1;

    public Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    /**le screen Pixel contiend l'image du dernier screenShot */
    public Color screenPixel[][] ;
    /**le screenShot contient l'image servant a l'analyse*/
    public BufferedImage screenShot;
    /**la resultante contient l'image du resultat de l'analyse*/
    public BufferedImage resultante;

    public PixelFinderMotor(int width, int height, int ratio,int rate, PixelAnalyserPanel target){
        this.ratio=ratio;
        this.width=width/ratio;
        this.height=height/ratio;
        this.rate=rate;
        this.target = target;
        target.setTarget(this);

        screenPixel= new Color[width][height];
        for(int j = 0;j<height;j++){
            for(int i = 0;i<width;i++){
                screenPixel[i][j]=new Color(0,0,0);
            }
        }

    }

    @Override
    public void run(){
        System.out.println("pixel finder is started");
        while (true) update();
    }

    void update(){

        boolean move = false;

        try {
            Thread.sleep(rate/60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        screenShot=robot.createScreenCapture(new Rectangle(width*ratio,height*ratio));
        resultante = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        for(int j = 0;j<height;j++){
            for(int i = 0;i<width;i++){
                resultante.setRGB(i,j,new Color(255,255,255).getRGB());
            }
        }



        //System.out.println("--------------------------------------------------");
        for(int j = 0;j<height;j++){
            for(int i = 0;i<width;i++){
                move=false;

                int SCR = (screenShot.getRGB(i*ratio,j*ratio)&16711680)>>16;
                int SCG = (screenShot.getRGB(i*ratio,j*ratio)&65280)>>8;
                int SCB = (screenShot.getRGB(i*ratio,j*ratio)&255);

                int LCR=(screenPixel[i][j].getRGB()&16711680)>>16;
                int LCG=(screenPixel[i][j].getRGB()&65280)>>8;
                int LCB=(screenPixel[i][j].getRGB()&255);


                //FIXME mettre les modifier

                for(Tolerance t : tolerences.getTolerances())if(Math.abs(SCR-LCR)>255*t.getRed()
                        && Math.abs(SCG-LCG)>255*t.getGreen()
                        && Math.abs(SCB-LCB)>255*t.getBlue())move=true;

                //System.out.println(i+"/"+j+" screen : "+toRGB(screenShot.getRGB(i,j))+" / last " + toRGB(screenPixel[i][j].getRGB()));

                screenPixel[i][j]=new Color(screenShot.getRGB(i*ratio,j*ratio));

                if(move)resultante.setRGB(i,j,new Color(0,0,0).getRGB());//pixel en noir
            }
            //System.out.println();
        }



        target.refresh(resultante);
    }

    public ToleranceManager getTolerences() {
        return tolerences;
    }

    public BufferedImage getResultante() {
        return resultante;
    }

}
