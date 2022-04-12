import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class PixelFinder {

    static InitScreen initScreen;
    public static void main(String[] args) {

        update(1920,1080,2,10,5,5);
    }

    static void update(int w,int h,int r,int tr,int tg,int tb){


        try {
            DisplayScreen a = new DisplayScreen(w,h,r,tr,tg,tb);
            while (true) a.update();
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
    }


public static String toRGB(int rgb){
        String rtn="";
        rtn+="r: "+ ((rgb&16711680)>>16) +"| g: "+ ((rgb&65280)>>8) +"| b: "+ (rgb&255) ;


        return rtn;
}


}