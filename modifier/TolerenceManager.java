package pixelFinder.modifier;

import java.util.ArrayList;

public class TolerenceManager {
    ArrayList<Tolerence> tolerences = new ArrayList<>();
    ArrayList<Tolerence> activeTolerence = new ArrayList<>();

    public TolerenceManager(){
    }
    public void addTolerence(float r,float g,float b){
        boolean test = true;
        for(Tolerence t:tolerences)if(t.getRed()==r && t.getGreen()==g && t.getBlue()==b)test=false;
        if(test)tolerences.add(new Tolerence(r,g,b));
    }
    public void TolerenceManaging(){
    }


    public void setActiveTolerence(ArrayList<Tolerence> activeTolerence) {
        this.activeTolerence = activeTolerence;
    }

    public ArrayList<Tolerence> getTolerences() {
        return tolerences;
    }
}
