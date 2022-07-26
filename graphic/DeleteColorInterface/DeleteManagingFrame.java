package pixelFinder.graphic.tolerenceInterface;

import pixelFinder.modifier.Tolerance;
import pixelFinder.modifier.ToleranceManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ToleranceManagingFrame extends JFrame implements ActionListener {


    //paneau contenant les managerPanel
    JPanel managerPane = new JPanel();
    JScrollPane managerView = new JScrollPane(managerPane);
    JPanel global = (JPanel) getContentPane();


    JButton addButton = new JButton("add");
    JButton confirmButton = new JButton("confirm");
    JButton saveButton = new JButton("save");


    ToleranceManager toleranceManager;
    //liste les TolerancePane
    ArrayList<TolerancePane> tolerancePanes = new ArrayList<>();

    public ToleranceManagingFrame(ToleranceManager toleranceManager){
        super("tolerance manager");
        this.toleranceManager = toleranceManager;
        init();
        setVisible(true);

        setLocationRelativeTo(null);
        System.out.println("tolerance manager frame open");
    }

    void init(){

        managerPane.setLayout(new BoxLayout(managerPane,BoxLayout.Y_AXIS));
        global.setLayout(new BorderLayout());

        global.removeAll();
        for(Tolerance t : toleranceManager.getTolerances()){
            addTolerancePane(t);
        }//todo ajouter les paneaux et boutons



        JPanel p = new JPanel(new FlowLayout());


        addButton.addActionListener(l->{addTolerancePane(new Tolerance());});
        p.add(addButton);

        confirmButton.addActionListener(l->confirm());
        p.add(confirmButton);

        saveButton.addActionListener(l->save());
        global.add(saveButton);


        global.add(managerView,BorderLayout.CENTER);
        global.add(p,BorderLayout.SOUTH);

        setSize(500,200);

    }

    void addTolerancePane(Tolerance t){

        TolerancePane p;
        p = new TolerancePane(t);
        p.setSubAction(l->{tolerancePanes.remove(p);managerPane.remove(p);revalidate();repaint();});
        tolerancePanes.add(p);
        managerPane.add(p);


        revalidate();
        repaint();
        //System.out.println("tolerance pane added" + p.getTolerence());
    }
    void confirm(){
        ArrayList<Tolerance> tolerences = new ArrayList<>();
        ArrayList<Tolerance> activeTolerence = new ArrayList<>();
        for(TolerancePane t:tolerancePanes){
            tolerences.add(t.getTolerence());
            if(t.isActive())activeTolerence.add(t.getTolerence());
        }
        toleranceManager.setTolerences(tolerences);
        toleranceManager.setActiveTolerence(activeTolerence);
    }
    void save(){//todo archiver dans un fichier et sauvegarder dans le toleranceManager

    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
