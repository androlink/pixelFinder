package pixelFinder.graphic.tolerenceInterface;

import pixelFinder.modifier.Tolerance;
import pixelFinder.modifier.ToleranceManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ToleranceManagingFrame extends JFrame {


    //paneau contenant les managerPanel
    JPanel managerPane = new JPanel();
    JScrollPane managerView = new JScrollPane(managerPane);
    JPanel global = (JPanel) getContentPane();
    JButton addButton = new JButton("add");


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
        GridLayout managerLayout = new GridLayout(0,1,5,5);

        managerPane.setLayout(managerLayout);
        global.setLayout(new BorderLayout());

        global.removeAll();
        for(Tolerance t : toleranceManager.getTolerances()){
            addTolerancePane(t);
        }//todo ajouter les paneaux et boutons

        addButton.addActionListener(l->{addTolerancePane(new Tolerance());

            System.out.println("add tolerancePane");});

        global.add(managerView,BorderLayout.CENTER);

        JPanel p = new JPanel(new FlowLayout());
        p.add(addButton);
        global.add(p,BorderLayout.SOUTH);

        setSize(500,200);

    }

    void addTolerancePane(Tolerance t){
        TolerancePane p = new TolerancePane(t);
        tolerancePanes.add(p);
        managerPane.add(p);
        managerPane.setSize(managerView.getWidth(),p.getHeight()*managerPane.getComponentCount());



        //System.out.println("tolerance pane added" + p.getTolerence());
    }
    void save(){//todo archiver dans un fichier et sauvegarder dans le toleranceManager

    }




}
