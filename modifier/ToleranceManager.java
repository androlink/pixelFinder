package pixelFinder.modifier;

import pixelFinder.graphic.tolerenceInterface.ToleranceManagingFrame;

import javax.swing.*;
import java.util.ArrayList;

public class ToleranceManager {


    ArrayList<Tolerance> tolerences = new ArrayList<>();
    ArrayList<Tolerance> activeTolerence = new ArrayList<>();

    public ToleranceManager(){
        addTolerence(0.1f,0.1f,0.1f);
    }

    public void addTolerence(float r,float g,float b){
        boolean test = true;
        for(Tolerance t:tolerences)if(t.getRed()==r && t.getGreen()==g && t.getBlue()==b)test=false;
        System.out.println("ajout d'une tolerence");
        if(test)tolerences.add(new Tolerance(r,g,b,"",true));
    }

    public void openPane(){
        new ToleranceManagingFrame(this);

    }


    public void setActiveTolerence(ArrayList<Tolerance> activeTolerence) {
        this.activeTolerence = activeTolerence;
    }
    public void setTolerences(ArrayList<Tolerance> tolerence) {
        this.tolerences = tolerence;
    }

    public ArrayList<Tolerance> getTolerances() {
        return tolerences;
    }
    public ArrayList<Tolerance> getActiveTolerence() {
        return activeTolerence;
    }
}
