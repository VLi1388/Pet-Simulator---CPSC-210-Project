package ui.tabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.ButtonNames;
import ui.PetSimulatorGUI;

public class LoadTab extends Tab{
    
    public LoadTab(PetSimulatorGUI controller) {
        super(controller);

        setLayout(new GridLayout(3, 1));

        JButton loadButton = new JButton(ButtonNames.LOAD.getValue());
        JPanel buttonRow = formatButtonRow(loadButton);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().getPetSimulator().loadPlayerProfile();
                }
            }
        );

        this.add(buttonRow);
    }
}
