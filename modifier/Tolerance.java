package pixelFinder.modifier;


/**
 * la tolerence permet d'avoir une marge d'erreur si une couleur change
 */
public class Tolerance {
    boolean isActive = false;
    String description="";
    float red=0;
    float blue=0;
    float green=0;

    public  Tolerance(){
    }

    public Tolerance(float r, float g, float b, String desc, boolean isActive){
        red=r;green=g;blue=b;
        this.isActive=isActive;
        this.description=desc;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getDescription() {
        return description;
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
