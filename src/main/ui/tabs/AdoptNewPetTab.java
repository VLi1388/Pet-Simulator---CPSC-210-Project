package ui.tabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.ButtonNames;
import ui.PetSimulatorGUI;

public class AdoptNewPetTab extends Tab {

    public AdoptNewPetTab(PetSimulatorGUI controller) {
        super(controller);

        setLayout(new GridLayout(3, 1));

    }
}
