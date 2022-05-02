package pixelFinder.graphic.tolerenceInterface;

import pixelFinder.modifier.Tolerance;

import javax.swing.*;
import java.awt.*;

public class TolerancePane extends JPanel {

    JTextField tRed;
    JTextField tGreen;
    JTextField tBlue;
    JTextField tDesc;
    JCheckBox CBActive;




public TolerancePane(){
    setLayout(new GridBagLayout());
    this.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.anchor=GridBagConstraints.WEST;
    constraints.insets=new Insets(5,5,5,5);
    System.out.println("ici");
    //initialisation des composante
    tRed = new JTextField(3);
    tGreen = new JTextField(3);
    tBlue = new JTextField(3);
    tDesc = new JTextField(10);
    CBActive = new JCheckBox();
    //ajout des composante
    constraints.gridx=0;
    constraints.gridy=0;
    add(CBActive,constraints);

    constraints.gridx=1;
    constraints.gridy=0;
    add(tRed,constraints);

    constraints.gridx=2;
    constraints.gridy=0;
    add(tGreen,constraints);

    constraints.gridx=3;
    constraints.gridy=0;
    add(tBlue,constraints);

    constraints.gridx=4;
    constraints.gridy=0;
    add(tDesc,constraints);
}


    public TolerancePane(Tolerance tolerence){
        setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor=GridBagConstraints.WEST;
        constraints.insets=new Insets(5,5,5,5);
        System.out.println("ici");
        //initialisation des composante
        tRed = new JTextField(3);
        tGreen = new JTextField(3);
        tBlue = new JTextField(3);
        tDesc = new JTextField(10);
        CBActive = new JCheckBox();
        //set des composante

        tRed.setText(tolerence.getRed()+"");
        tGreen.setText(tolerence.getGreen()+"");
        tBlue.setText(tolerence.getBlue()+"");
        tDesc.setText(tolerence.getDescription()+"");
        CBActive.setSelected(tolerence.isActive());
        //ajout des composante

        constraints.gridx=0;
        constraints.gridy=0;
        add(CBActive,constraints);

        constraints.gridx=1;
        constraints.gridy=0;
        add(tRed,constraints);

        constraints.gridx=2;
        constraints.gridy=0;
        add(tGreen,constraints);

        constraints.gridx=3;
        constraints.gridy=0;
        add(tBlue,constraints);

        constraints.gridx=4;
        constraints.gridy=0;
        add(tDesc,constraints);

    }
    public Tolerance getTolerence(){
        float r =Float.parseFloat(tRed.getText());
        float g =Float.parseFloat(tGreen.getText());
        float b =Float.parseFloat(tBlue.getText());
        String d = tDesc.getText();
        Boolean a = CBActive.isSelected();

        return new Tolerance(r,g,b,d,a);
    }





}
