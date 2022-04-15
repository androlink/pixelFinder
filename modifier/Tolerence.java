package pixelFinder.modifier;


/**
 * la tolerence permet d'avoir une marge d'erreur si une couleur change
 */
public class Tolerence {
    float red;
    float blue;
    float green;

    public Tolerence(float r,float g,float b){
        red=r;green=g;blue=b;
    }

    public float getRed() {
        return red;
    }

    public float getBlue() {
        return blue;
    }

    public float getGreen() {
        return green;
    }
}
