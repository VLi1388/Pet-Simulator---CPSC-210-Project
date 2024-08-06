package ui.tabs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import ui.ButtonNames;
import ui.PetSimulatorGUI;

// class representing the functionalities of the home tab
// this class was referenced off the SmartHome Project
// some code in this class were taught by https://www.youtube.com/watch?v=iE8tZ0hn2Ws&t=2s
public class HomeTab extends Tab {
    private static final String INIT_GREETING = "WELCOME TO PET SIMULATOR";
    private JLabel greeting;

    //EFFECTS: constructs a home tab for console with buttons and a welcome screen
    public HomeTab(PetSimulatorGUI controller) {
        super(controller);

        setLayout(new GridLayout(3, 1));

        placeWelcomeScreen();
        placeHomeButtons();
    }

    //EFFECTS: creates and display the welsome screen
    private void placeWelcomeScreen() {
        greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        greeting.setSize(WIDTH, HEIGHT / 3);
        this.add(greeting);

        // code was referened off https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel
        // image was taken from https://stock.adobe.com/ca/search?k=dog+logo&asset_id=277806809
        BufferedImage logo = null;
        try {
            logo = ImageIO.read(new File("./src/logo.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JLabel petLogo = new JLabel(new ImageIcon(logo));
        this.add(petLogo);
    }

    //EFFECTS: creates new game and load game buttons
    private void placeHomeButtons() {
        JButton newGame = new JButton(ButtonNames.NEW_GAME.getValue());
        JButton loadGame = new JButton(ButtonNames.LOAD_GAME.getValue());

        JPanel buttonRow = formatButtonRow(newGame);
        buttonRow.add(loadGame);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewGame();
            }
        });

        loadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().getPetSimulator().loadPlayerProfile();
            }
        });

        this.add(buttonRow);
    }

    // EFFECTS: create pop up window to create a new game
    private void createNewGame() {
        JFrame frame = new JFrame();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(); 
        frame.add(panel);

        setUpNewGamePanel(panel);

        frame.setVisible(true);
    }

    // EFFECTS: set up pop up window to create a new game
    private void setUpNewGamePanel(JPanel panel) {
        panel.setLayout(null);

        JLabel playerNameLabel = new JLabel("Player name: ");
        playerNameLabel.setBounds(10, 20, 120, 25);
        panel.add(playerNameLabel);

        JTextField playerNameText = new JTextField(20);
        playerNameText.setBounds(120,20,165,25);
        panel.add(playerNameText);

        JLabel petSpeciesLabel = new JLabel("Pet species: ");
        petSpeciesLabel.setBounds(10,50,80,25);
        panel.add(petSpeciesLabel);

        JTextField petSpeciesText = new JTextField(20);
        petSpeciesText.setBounds(120,50,165,25);
        panel.add(petSpeciesText);

        JLabel petNameLabel = new JLabel("Pet name: ");
        petNameLabel.setBounds(10,80,80,25);
        panel.add(petNameLabel);

        JTextField petNameText = new JTextField(20);
        petNameText.setBounds(120,80,165,25);
        panel.add(petNameText);

        panel.add(setUpCreateGameButton(playerNameText, petSpeciesText, petNameText));
    }

    // EFFECTS: create button that builds the new player profile
    private JButton setUpCreateGameButton(JTextField playerNT, JTextField petST, JTextField petNT) {
        JButton createGame = new JButton("Create game");
        createGame.setBounds(10, 110, 120, 25);
        createGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playerName = playerNT.getText();
                String petSpecies = petST.getText();
                String petName = petNT.getText();

                // System.out.println(playerName + petSpecies + petName + "created");

                getController().getPetSimulator().createPlayerProfile(playerName, petSpecies, petName);
                //getController().getPetSimulator().testPrint();
            }
        });

        return createGame;
    }
}
