package ui.tabs;

import ui.PetSimulatorGUI;

import javax.swing.*;
import java.awt.*;

public abstract class Tab extends JPanel{
    private final PetSimulatorGUI controller;

    //REQUIRES: PetSimulatorUI controller that holds this tab
    public Tab(PetSimulatorGUI controller) {
        this.controller = controller;
    }

    //EFFECTS: creates and returns row with button included
    public JPanel formatButtonRow(JButton b) {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(b);

        return p;
    }

    //EFFECTS: returns the PetSimulatorUI controller for this tab
    public PetSimulatorGUI getController() {
        return controller;
    }
}
