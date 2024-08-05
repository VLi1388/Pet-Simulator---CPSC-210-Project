package ui.tabs;

import javax.swing.*;

import model.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import ui.ButtonNames;
import ui.PetSimulatorGUI;

public class PlayerProfileTab extends Tab {

    private JScrollPane reportPane;
    private JTextArea reportText;
    private JLabel errorMessage;

    public PlayerProfileTab(PetSimulatorGUI controller) {
        super(controller);

        setLayout(new GridLayout(3, 1));

        errorMessage = new JLabel("", JLabel.CENTER);
        errorMessage.setSize(WIDTH, HEIGHT / 3);
        this.add(errorMessage);

        displayObtainedAccessories();
        placeViewPetsButton();

        // loadPet1(player);
        // loadPet2(player);
        // loadPet3(player);
    }

    private void displayObtainedAccessories() {

        placeCheckInventoryButton();

        JPanel reportBlock = new JPanel(new GridLayout(2, 1));
        reportBlock.setSize(PetSimulatorGUI.WIDTH - (PetSimulatorGUI.WIDTH / 5),
                PetSimulatorGUI.HEIGHT - (PetSimulatorGUI.HEIGHT / 5));
        reportPane = new JScrollPane(new JTextArea(6, 40));
        reportText = new JTextArea("", 6, 40);
        reportText.setVisible(true);

        reportBlock.add(reportPane);

        add(reportBlock);
    }

    private void placeCheckInventoryButton() {
        JButton checkInventory = new JButton(ButtonNames.CHECK_INVENTORY.getValue());
        JPanel buttonRow = formatButtonRow(checkInventory);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        checkInventory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reportText.setText(getController().getPetSimulator().displayObtainedAccrssories());
                // reportText.setText("Some text");
                reportPane.setViewportView(reportText);
            }
        });

        this.add(buttonRow);
    }

    private void placeViewPetsButton() {
        JButton viewPet1 = new JButton(ButtonNames.VIEW_PET_1.getValue());
        JButton viewPet2 = new JButton(ButtonNames.VIEW_PET_2.getValue());
        JButton viewPet3 = new JButton(ButtonNames.VIEW_PET_3.getValue());

        JPanel buttonRow = formatButtonRow(viewPet1);
        buttonRow.add(viewPet2);
        buttonRow.add(viewPet3);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        handleViewPetButton(viewPet1, 1, 0);
        handleViewPetButton(viewPet2, 2, 1);
        handleViewPetButton(viewPet3, 3, 2);

        this.add(buttonRow);
    }

    private void handleViewPetButton(JButton button, int spot, int index) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player = getController().getPetSimulator().getPlayer();

                if (player.isOwning(spot)) {
                    popUpPet(player, index);
                    errorMessage.setText("");
                } else {
                    errorMessage.setText("You don't own that pet yet");
                }
            }
        });
    }

    private void popUpPet(Player player, int index) {
        JFrame frame = new JFrame();
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        setUpPetsPanel(panel, player, index);

        frame.setVisible(true);
    }

    private void setUpPetsPanel(JPanel panel, Player player, int index) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name: " + player.getOwnedPets().get(index).getName());
        nameLabel.setBounds(10, 20, 120, 25);
        panel.add(nameLabel);

        JLabel speciesLabel = new JLabel("Species: " + player.getOwnedPets().get(index).getSpecies());
        speciesLabel.setBounds(10, 50, 120, 25);
        panel.add(speciesLabel);

        JLabel moodLabel = new JLabel("Mood: " + player.getOwnedPets().get(index).getMood());
        moodLabel.setBounds(10, 80, 120, 25);
        panel.add(moodLabel);

        JLabel thirstLabel = new JLabel("Hunger: " + player.getOwnedPets().get(index).getHunger());
        thirstLabel.setBounds(10, 110, 120, 25);
        panel.add(thirstLabel);

        JLabel hungerLabel = new JLabel("Thirst: " + player.getOwnedPets().get(index).getThirst());
        hungerLabel.setBounds(10, 140, 120, 25);
        panel.add(hungerLabel);

        JLabel equippedAccessLabel = new JLabel(
                "Equipped Accessories: " + getController().getPetSimulator().displayEquippedAccess(index));
        equippedAccessLabel.setBounds(10, 170, 280, 25);
        panel.add(equippedAccessLabel);
    }

    // private void displayPet1(Player player, JPanel panel) {

    // JLabel nameLabel = new JLabel("Name: " +
    // player.getOwnedPets().get(index).getName());
    // nameLabel.setBounds(10, 20, 120, 25);
    // panel.add(nameLabel);

    // JLabel speciesLabel = new JLabel("Species: " +
    // player.getOwnedPets().get(0).getSpecies());
    // speciesLabel.setBounds(10, 50, 120, 25);
    // panel.add(speciesLabel);

    // JLabel moodLabel = new JLabel("Mood: " +
    // player.getOwnedPets().get(0).getMood());
    // moodLabel.setBounds(10, 80, 120, 25);
    // panel.add(moodLabel);

    // JLabel thirstLabel = new JLabel("Hunger: " +
    // player.getOwnedPets().get(0).getHunger());
    // thirstLabel.setBounds(10, 110, 120, 25);
    // panel.add(thirstLabel);

    // JLabel hungerLabel = new JLabel("Thirst: " +
    // player.getOwnedPets().get(0).getThirst());
    // hungerLabel.setBounds(10, 140, 120, 25);
    // panel.add(hungerLabel);

    // JLabel equippedAccessLabel = new JLabel(
    // "Equipped Accessories: " +
    // getController().getPetSimulator().displayEquippedAccess(1));
    // equippedAccessLabel.setBounds(10, 170, 280, 25);
    // panel.add(equippedAccessLabel);
    // }

    // private void displayPet2(Player player, JPanel panel) {

    // }

    // private void displayPet3(Player player, JPanel panel) {

    // }
}
