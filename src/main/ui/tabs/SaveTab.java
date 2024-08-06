package ui.tabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.ButtonNames;
import ui.PetSimulatorGUI;

// class representing the functionalities of the save tab
// this class was referenced off the SmartHome Project
public class SaveTab extends Tab {

    // sets up the user interface for the save tab, allows the user to save file
    public SaveTab(PetSimulatorGUI controller) {
        super(controller);

        setLayout(new GridLayout(3, 1));

        JButton saveButton = new JButton(ButtonNames.SAVE.getValue());
        JPanel buttonRow = formatButtonRow(saveButton);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().getPetSimulator().savePlayerProfile();
                }
            }
        );

        this.add(buttonRow);
    }
}
