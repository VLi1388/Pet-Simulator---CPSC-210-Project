package ui.tabs;

import javax.swing.*;

import model.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.PetSimulatorGUI;

// class that represents the functionalities of the adopt pet tab
// this class was referenced off the SmartHome Project
public class AdoptNewPetTab extends Tab {
    private JLabel message;
    private JLabel instruction;

    // EFFECTS: constructs an adopt pet tab for console with buttons and messages
    public AdoptNewPetTab(PetSimulatorGUI controller) {
        super(controller);

        setLayout(new GridLayout(3, 1));

        message = new JLabel("", JLabel.CENTER);
        add(message);

        instruction = new JLabel("", JLabel.CENTER);
        add(instruction);

        placeAdoptButton();
    }

    // EFFECTS: adds the adopt button
    private void placeAdoptButton() {
        JButton adoptButton = new JButton("Adopt a new pet!");

        JPanel buttonRow = formatButtonRow(adoptButton);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        handelAdoptButton(adoptButton);

        this.add(buttonRow);
    }

    // EFFECTS: handels what happens when the adopt button is pressed
    private void handelAdoptButton(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player = getController().getPetSimulator().getPlayer();

                if (player.canAdopt() == false) {
                    message.setText("Sorry, you cannot adopt a pet for now.");
                    instruction.setText("(All pets must have all stats >= 90)");
                } else {
                    adoptPetPopUp();
                    instruction.setText("");
                }
            }
        });
    }

    // EFFECTS: creates new window pop up for user to input pet info
    private void adoptPetPopUp() {
        JFrame frame = new JFrame();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(); 
        frame.add(panel);

        setUpNewPetPanel(panel);

        frame.setVisible(true);
    }

    // EFFECTS: set up the new pop up window
    private void setUpNewPetPanel(JPanel panel) {
        panel.setLayout(null);

        JLabel petSpeciesLabel = new JLabel("Pet species: ");
        petSpeciesLabel.setBounds(10,50,80,25);
        panel.add(petSpeciesLabel);

        JTextField petSpeciesText = new JTextField(20);
        petSpeciesText.setBounds(120,50,165,25);
        panel.add(petSpeciesText);

        JLabel petNameLabel = new JLabel("Pet name: ");
        petNameLabel.setBounds(10, 20, 120, 25);
        panel.add(petNameLabel);

        JTextField petNameText = new JTextField(20);
        petNameText.setBounds(120,20,165,25);
        panel.add(petNameText);

        panel.add(setUpAdoptButton(petSpeciesText, petNameText));
    }

    // EFFECTS: adopts a new pet when the adopt button is pressed
    private JButton setUpAdoptButton(JTextField petST, JTextField petNT) {
        JButton adopt = new JButton("Adopt");
        adopt.setBounds(10, 110, 120, 25);
        adopt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String petSpecies = petST.getText();
                String petName = petNT.getText();

                getController().getPetSimulator().adoptPet(petSpecies, petName);

                message.setText("Adopted new pet!");
            }
        });

        return adopt;
    }
}
