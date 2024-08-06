package ui.tabs;

import javax.swing.*;

import model.Pet;
import model.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

import ui.ButtonNames;
import ui.PetSimulatorGUI;

public class PlayerProfileTab extends Tab {

    private JScrollPane playerAccessPane;
    private JTextArea playerAccessText;
    private JLabel errorMessage;

    public PlayerProfileTab(PetSimulatorGUI controller) {
        super(controller);

        setLayout(new GridLayout(4, 1));

        errorMessage = new JLabel("", JLabel.CENTER);
        errorMessage.setSize(WIDTH, HEIGHT / 3);
        this.add(errorMessage);

        displayObtainedAccessories();
        placeViewPetsButton();
    }

    private void displayObtainedAccessories() {

        placeCheckInventoryButton();

        JPanel reportBlock = new JPanel(new GridLayout(2, 1));
        reportBlock.setSize(PetSimulatorGUI.WIDTH - (PetSimulatorGUI.WIDTH / 5),
                PetSimulatorGUI.HEIGHT - (PetSimulatorGUI.HEIGHT / 5));
        playerAccessPane = new JScrollPane(new JTextArea(6, 40));
        playerAccessText = new JTextArea("", 6, 40);
        playerAccessText.setVisible(true);

        reportBlock.add(playerAccessPane);

        add(reportBlock);
    }

    private void placeCheckInventoryButton() {
        JButton checkInventory = new JButton(ButtonNames.CHECK_INVENTORY.getValue());
        JPanel buttonRow = formatButtonRow(checkInventory);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        checkInventory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerAccessText.setText(
                        "Obtained Accessories: " + getController().getPetSimulator().displayObtainedAccrssories());
                playerAccessPane.setViewportView(playerAccessText);
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
        Pet thisPet = player.getOwnedPets().get(index);

        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name: " + thisPet.getName());
        nameLabel.setBounds(10, 20, 120, 25);
        panel.add(nameLabel);

        JLabel speciesLabel = new JLabel("Species: " + thisPet.getSpecies());
        speciesLabel.setBounds(10, 50, 120, 25);
        panel.add(speciesLabel);

        JLabel moodLabel = new JLabel("Mood: " + thisPet.getMood());
        moodLabel.setBounds(10, 80, 120, 25);
        panel.add(moodLabel);

        JLabel thirstLabel = new JLabel("Hunger: " + thisPet.getHunger());
        thirstLabel.setBounds(10, 110, 120, 25);
        panel.add(thirstLabel);

        JLabel hungerLabel = new JLabel("Thirst: " + thisPet.getThirst());
        hungerLabel.setBounds(10, 140, 120, 25);
        panel.add(hungerLabel);

        JLabel equippedAccessLabel = new JLabel(
                "Equipped Accessories: " + getController().getPetSimulator().displayEquippedAccess(index));
        equippedAccessLabel.setBounds(10, 170, 500, 25);
        panel.add(equippedAccessLabel);

        placeActionButtons(panel, thisPet, hungerLabel, thirstLabel, moodLabel, player, equippedAccessLabel, index);
    }

    private void placeActionButtons(JPanel panel, Pet pet, JLabel hungerLabel, JLabel thirstLabel, JLabel moodLabel,
            Player player, JLabel equippedAccessLabel, int index) {
        JButton feed = new JButton(ButtonNames.FEED.getValue());
        feed.setBounds(10, 200, 100, 25);
        panel.add(feed);

        JButton fillWater = new JButton(ButtonNames.FILL_WATER.getValue());
        fillWater.setBounds(130, 200, 100, 25);
        panel.add(fillWater);

        JButton interact = new JButton(ButtonNames.INTERACT.getValue());
        interact.setBounds(250, 200, 100, 25);
        panel.add(interact);

        JButton equipAccess = new JButton(ButtonNames.EQUIP_ACCESSORIES.getValue());
        equipAccess.setBounds(10, 240, 180, 25);
        panel.add(equipAccess);

        JButton unequipAccess = new JButton(ButtonNames.UNEQUIP_ACCESSORIES.getValue());
        unequipAccess.setBounds(200, 240, 180, 25);
        panel.add(unequipAccess);

        handleFeedButton(feed, pet, hungerLabel);
        handleFillWaterButton(fillWater, pet, thirstLabel);
        handleInteractButton(interact, pet, moodLabel);

        handelEquipAccessButton(equipAccess, player, pet, equippedAccessLabel, index);
        handelUnequipAccessButton(unequipAccess, player, pet, equippedAccessLabel, index);
    }

    private void handleFeedButton(JButton button, Pet pet, JLabel hungerLabel) {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pet.applyHunger(30);
                System.out.println(pet.getName() + "'s hunger increased by 30!");
                hungerLabel.setText("Hunger: " + pet.getHunger());
            }
        });
    }

    private void handleFillWaterButton(JButton button, Pet pet, JLabel thirstLabel) {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pet.applyThirst(30);
                System.out.println(pet.getName() + "'s thirst increased by 30!");
                thirstLabel.setText("Thirst: " + pet.getThirst());
            }
        });
    }

    private void handleInteractButton(JButton button, Pet pet, JLabel moodLabel) {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pet.applyMood(30);
                System.out.println(pet.getName() + "'s mood increased by 30!");
                getController().getPetSimulator().dropAccessory(pet);
                moodLabel.setText("Mood: " + pet.getMood());
            }
        });
    }

    private void handelEquipAccessButton(JButton button, Player player, Pet pet, JLabel equippedAccessLabel,
            int index) {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setSize(500, 300);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel panel = new JPanel();
                frame.add(panel);

                setUpEquipAccessPanel(panel, player, pet, equippedAccessLabel, index);

                frame.setVisible(true);
            }
        });

    }

    private void setUpEquipAccessPanel(JPanel panel, Player player, Pet pet, JLabel equippedAccessLabel, int index) {
        panel.setLayout(null);

        JLabel intro = new JLabel("Please select the accessories you want to equip your pet with:");
        intro.setBounds(10, 20, 480, 25);
        panel.add(intro);

        JLabel instruction = new JLabel("(Select based on accessory order position, separated by \",\")");
        instruction.setBounds(10, 55, 480, 25);
        panel.add(instruction);

        JTextField selectedAccess = new JTextField(20);
        selectedAccess.setBounds(10, 90, 165, 25);
        panel.add(selectedAccess);

        JButton equipButton = new JButton("Equip");
        equipButton.setBounds(10, 125, 100, 25);
        panel.add(equipButton);

        handleEquipButton(equipButton, selectedAccess, pet, equippedAccessLabel, index);
    }

    private void handleEquipButton(JButton button, JTextField selectedAccess, Pet pet, JLabel equippedAccessLabel,
            int index) {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = selectedAccess.getText();
                getController().getPetSimulator().equipAccessories(pet, input);
                equippedAccessLabel.setText(
                        "Equipped Accessories: " + getController().getPetSimulator().displayEquippedAccess(index));
                playerAccessText.setText(
                        "Obtained Accessories: " + getController().getPetSimulator().displayObtainedAccrssories());
            }
        });

    }

    private void handelUnequipAccessButton(JButton button, Player player, Pet pet, JLabel equippedAccessLabel,
            int index) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setSize(500, 300);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel panel = new JPanel();
                frame.add(panel);

                setUpUnequipAccessPanel(panel, player, pet, equippedAccessLabel, index);

                frame.setVisible(true);
            }
        });
    }

    private void setUpUnequipAccessPanel(JPanel panel, Player player, Pet pet, JLabel equippedAccessLabel, int index) {
        panel.setLayout(null);

        JLabel intro = new JLabel("Please select the accessories you want to unequip your pet with:");
        intro.setBounds(10, 20, 480, 25);
        panel.add(intro);

        JLabel instruction = new JLabel("(Select based on accessory order position, separated by \",\")");
        instruction.setBounds(10, 55, 480, 25);
        panel.add(instruction);

        JTextField selectedAccess = new JTextField(20);
        selectedAccess.setBounds(10, 90, 165, 25);
        panel.add(selectedAccess);

        JButton unequipButton = new JButton("Unequip");
        unequipButton.setBounds(10, 125, 100, 25);
        panel.add(unequipButton);

        handleUnequipButton(unequipButton, selectedAccess, pet, equippedAccessLabel, index);
    }

    private void handleUnequipButton(JButton button, JTextField selectedAccess, Pet pet, JLabel equippedAccessLabel,
            int index) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = selectedAccess.getText();
                getController().getPetSimulator().unequipAccessories(pet, input);
                equippedAccessLabel.setText(
                        "Equipped Accessories: " + getController().getPetSimulator().displayEquippedAccess(index));
                playerAccessText.setText(
                        "Obtained Accessories: " + getController().getPetSimulator().displayObtainedAccrssories());
            }
        });
    }
}
