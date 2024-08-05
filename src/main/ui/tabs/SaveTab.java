package ui.tabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.ButtonNames;
import ui.PetSimulatorGUI;

public class SaveTab extends Tab {

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
