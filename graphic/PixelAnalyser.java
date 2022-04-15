package pixelFinder.graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PixelAnalyser extends JFrame {

    public int ratio=5;
    public int width=1920/ratio;
    public int height=1080/ratio;
    public float tolerenceR;
    public float tolerenceG;
    public float tolerenceB;

    public Robot robot = new Robot();
    public Color screenPixel[][] ;
    public BufferedImage screenShot;
    public BufferedImage resultante;

    public JPanel global = (JPanel) this.getContentPane();
    public PixelAnalyser(int width,int height,int ratio,float tolerenceR,float tolerenceG,float tolerenceB) throws AWTException {
        this.ratio=ratio;
        this.width=width/ratio;
        this.height=height/ratio;
        this.tolerenceR=tolerenceR/100f;
        this.tolerenceG=tolerenceG/100f;
        this.tolerenceB=tolerenceB/100f;
        screenPixel= new Color[width][height];

        for(int j = 0;j<height;j++){
            for(int i = 0;i<width;i++){
                screenPixel[i][j]=new Color(0,0,0);
            }
        }

        setTitle("stained_image");
        setDefaultCloseOperation(3);
        setVisible(true);
        setSize(400,400);

        paint(global.getGraphics());
    }
    void update(){

        boolean move = false;


        try {
            Thread.sleep(1000);
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

        move=false;

        //System.out.println("--------------------------------------------------");
        for(int j = 0;j<height;j++){
            for(int i = 0;i<width;i++){
                int SCR = (screenShot.getRGB(i*ratio,j*ratio)&16711680)>>16;
                int SCG = (screenShot.getRGB(i*ratio,j*ratio)&65280)>>8;
                int SCB = (screenShot.getRGB(i*ratio,j*ratio)&255);

                int LCR=(screenPixel[i][j].getRGB()&16711680)>>16;
                int LCG=(screenPixel[i][j].getRGB()&65280)>>8;
                int LCB=(screenPixel[i][j].getRGB()&255);



                if(
                        Math.abs(SCR-LCR)>255*tolerenceR
                                && Math.abs(SCG-LCG)>255*tolerenceG
                                && Math.abs(SCB-LCB)>255*tolerenceB
                ){
                    move=true;
                    resultante.setRGB(i,j,new Color(0,0,0).getRGB());
                }

                //System.out.println(i+"/"+j+" screen : "+toRGB(screenShot.getRGB(i,j))+" / last " + toRGB(screenPixel[i][j].getRGB()));

                screenPixel[i][j]=new Color(screenShot.getRGB(i*ratio,j*ratio));
            }
            //System.out.println();
        }
        //if(move)System.out.println("you move");
        //

        paint(global.getGraphics());
    }
    public void paint(Graphics g) {
        screenShot=robot.createScreenCapture(new Rectangle(width*ratio,height*ratio));
        global.paintComponents(g);
        g.drawImage(screenShot, this.getWidth(), this.getHeight(), null);

    }


    public static void main(String[] args) {
        try {
            PixelAnalyser t = new PixelAnalyser(1920,1080,2,5,10,5);
            while (true)t.update();
        } catch (AWTException e) {
            e.printStackTrace();
        }


    }


}
