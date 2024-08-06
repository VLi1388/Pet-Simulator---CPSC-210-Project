package ui;

import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import ui.tabs.AdoptNewPetTab;
import ui.tabs.HomeTab;
import ui.tabs.LoadTab;
import ui.tabs.PlayerProfileTab;
import ui.tabs.SaveTab;

// a pet simulator GUI that allows the player to interact graphically with the game
// this class was referenced off the SmartHome Project
public class PetSimulatorGUI extends JFrame {
    public static final int HOME_TAB_INDEX = 0;
    public static final int PLAYER_PROFILE_TAB_INDEX = 1;
    public static final int ADOPT_NEW_PET_TAB_INDEX = 2;
    public static final int SAVE_TAB_INDEX = 3;
    public static final int LOAD_TAB_INDEX = 4;

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;
    private JTabbedPane sidebar;
    
    private PetSimulator petSimulator;

    //EFFECTS: creates PetSimulatorGUI, creates PetSimulator, displays sidebar and tabs
    public PetSimulatorGUI() {
        super("Pet Simulator Console");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            petSimulator = new PetSimulator();
        } catch (FileNotFoundException e) {
            System.out.println("Load file was not found. Unable to run simulator.");
        }

        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);

        loadTabs();
        add(sidebar);

        setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: adds neccessary tabs to this GUI
    private void loadTabs() {
        JPanel homeTab = new HomeTab(this);
        JPanel playerProfileTab = new PlayerProfileTab(this);
        JPanel adoptNewPetTab = new AdoptNewPetTab(this);
        JPanel saveTab = new SaveTab(this);
        JPanel loadTab = new LoadTab(this);

        sidebar.add(homeTab, HOME_TAB_INDEX);
        sidebar.setTitleAt(HOME_TAB_INDEX, "Home");
        sidebar.add(playerProfileTab, PLAYER_PROFILE_TAB_INDEX);
        sidebar.setTitleAt(PLAYER_PROFILE_TAB_INDEX, "Player Profile");
        sidebar.add(adoptNewPetTab, ADOPT_NEW_PET_TAB_INDEX);
        sidebar.setTitleAt(ADOPT_NEW_PET_TAB_INDEX, "Adopt a New Pet");
        sidebar.add(saveTab, SAVE_TAB_INDEX);
        sidebar.setTitleAt(SAVE_TAB_INDEX, "Save");
        sidebar.add(loadTab, LOAD_TAB_INDEX);
        sidebar.setTitleAt(LOAD_TAB_INDEX, "Load");
    }
    
    //EFFECTS: returns petSimulator object controlled by this GUI
    public PetSimulator getPetSimulator() {
        return petSimulator;
    }
}
