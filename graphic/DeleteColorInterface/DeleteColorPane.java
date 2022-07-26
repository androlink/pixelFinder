package pixelFinder.graphic.tolerenceInterface;

import pixelFinder.modifier.Tolerance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TolerancePane extends JPanel {

    JPanel global = new JPanel();



    JTextField tRed;
    JTextField tGreen;
    JTextField tBlue;
    JTextField tDesc;
    JCheckBox CBActive;
    JButton suprB = new JButton("supr");




public TolerancePane(){
    createMe();
}


    public TolerancePane(Tolerance tolerence){
        createMe();


        tRed.setText(tolerence.getRed()+"");
        tGreen.setText(tolerence.getGreen()+"");
        tBlue.setText(tolerence.getBlue()+"");
        tDesc.setText(tolerence.getDescription()+"");
        CBActive.setSelected(tolerence.isActive());



    }
    private void createMe(){

        global.setLayout(new BoxLayout(global,BoxLayout.X_AXIS));
        global.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
        System.out.println("ici");
        //initialisation des composante
        tRed = new JTextField(3);
        tGreen = new JTextField(3);
        tBlue = new JTextField(3);
        tDesc = new JTextField(10);
        CBActive = new JCheckBox();
        //ajout des composante
        global.add(CBActive);
        global.add(tRed);
        global.add(tGreen);
        global.add(tBlue);
        global.add(tDesc);
        global.add(suprB);
        add(global);
    }
    public void setSubAction(ActionListener sup){
        suprB.addActionListener(sup);


    }




    public Tolerance getTolerence(){
        float r =Float.parseFloat(tRed.getText());
        float g =Float.parseFloat(tGreen.getText());
        float b =Float.parseFloat(tBlue.getText());
        String d = tDesc.getText();
        Boolean a = CBActive.isSelected();

        return new Tolerance(r,g,b,d,a);
    }
    public boolean isActive(){
        return CBActive.isSelected();
    }

}
