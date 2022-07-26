package pixelFinder.modifier;

import pixelFinder.graphic.tolerenceInterface.ToleranceManagingFrame;

import javax.swing.*;
import java.util.ArrayList;

public class ToleranceManager {
    ToleranceManagingFrame toleranceManagingFrame;


    ArrayList<Tolerance> tolerences = new ArrayList<>();
    ArrayList<Tolerance> activeTolerence = new ArrayList<>();

    public ToleranceManager(){
        load();
        //addTolerence(0.1f,0.1f,0.1f);
    }

    public void resetTolerence(){
        ArrayList<Tolerance> tolerences = new ArrayList<>();
        ArrayList<Tolerance> activeTolerence = new ArrayList<>();
    }

    public void addTolerence(float r,float g,float b){
        boolean test = true;
        for(Tolerance t:tolerences)if(t.getRed()==r && t.getGreen()==g && t.getBlue()==b)test=false;
        if(test)tolerences.add(new Tolerance(r,g,b,"",true));
    }

    public void openPane(){

        if(toleranceManagingFrame==null)
            toleranceManagingFrame=new ToleranceManagingFrame(this);

    }
    public void load(){




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
