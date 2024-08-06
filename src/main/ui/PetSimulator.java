package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.Accessory;
import model.Pet;
import model.Player;
import persistence.JsonReader;
import persistence.JsonWriter;

public class PetSimulator {
    private static final String JSON_STORE = "./data/player.json";

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private Player player;

    // private Scanner scanner;
    // private boolean isSimulatorRunning;
    // private boolean inWelcomeMenu;

    // private boolean inPetsMenu;

    // EFFECTS: creates an instance of the PetSimulator console ui application
    // public PetSimulator() throws IOException, InterruptedException,
    // FileNotFoundException {
    public PetSimulator() throws FileNotFoundException {
        // this.scanner = new Scanner(System.in);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        //loadPlayerProfile();
    }

    public Player getPlayer() {
        return this.player;
    }

    // MODIFIES: player, initialPet
    // EFFECTS: initializes the simulator by setting up a player profile
    public void createPlayerProfile(String playerName, String initialPetSpecies, String initialPetName) {

        Pet initialPet = new Pet(initialPetSpecies, initialPetName);
        player = new Player(playerName, initialPet);

        System.out.println("new player created");
    }

    public void testPrint() {
        System.out.println("printed something");
    }

    // MODIFIES: p
    // EFFECTS: decreases the pets' status
    public void decreasePetStatus() {
        for (Pet p : player.getOwnedPets()) {
            p.decreaseMood();
            p.decreaseHunger();
            p.decreaseThirst();
        }
    }

    // MODIFIES: player, newPet
    // EFFECTS: asks the player for a pet that they want to adopt, and adopt that
    // pet
    public void adoptPet() {

    }

    // EFFECTS: saves the player profile to file
    public void savePlayerProfile() {
        try {
            jsonWriter.open();
            jsonWriter.write(player);
            jsonWriter.close();
            System.out.println("Saved " + player.getName() + "'s profile to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: returns a String list of obtained accessories of this player
    public String displayObtainedAccrssories() {
        List<Accessory> obtainedAccess = this.player.getObtainedAccessories();
        StringBuilder inventory = new StringBuilder();

        for (Accessory a : obtainedAccess) {
            inventory.append("\n").append(a.getName());
        }

        return inventory.toString();
    }

    // EFFECTS: returns a String list of equipped accessories of this player's pet
    public String displayEquippedAccess(int index) {
        Pet thisPet = player.getOwnedPets().get(index);
        List<Accessory> equippedAccess = thisPet.getEquippedAccessories();
        StringBuilder inventory = new StringBuilder();

        for (Accessory a : equippedAccess) {
            inventory.append("\n").append(a.getName()).append(", ");
        }

        return inventory.toString();
    }

    public String testString() {
        return "String";
    }

    // MODIFIES: this
    // EFFECTS: loads player profile from file
    public void loadPlayerProfile() {
        try {
            player = jsonReader.read();
            System.out.println("Loaded " + player.getName() + "'s profile from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // MODIFIES: droppedAccessory, player
    // EFFECTS: when the player interacts with the pet, there is a chance for a
    // random accessory, the accessory is automatically obtained by the player
    // to be dropped (by creating a new accessory object)
    public void dropAccessory(Pet pet) {
        // TODO: implement so that there is a 30% chance of dropping an accessory
        // everytime the player interacts with a pet. For now, we are just
        // letting it drop an accessory everytime

        Accessory droppedAccessory = new Accessory();
        this.player.addAccesory(droppedAccessory);
        System.out.println(pet.getName() + " dropped a " + droppedAccessory.getName() + "!");
    }

    // REQUIRES: selected accessories are within player.getObtainedAccessories();
    // MODIFIES: player, pet
    // EFFECTS: adds the selected accessories to the pets' equippedAccessories and
    // removes the selected accessories
    // from players' obtainedAccessories
    public void equipAccessories(Pet pet, String input) {
        List<String> inputs = new ArrayList<String>(Arrays.asList(input.split(",")));

        List<Integer> indices = new ArrayList<>();
        for (String s : inputs) {
            int index = Integer.valueOf(s) - 1;
            indices.add(index);
        }

        List<Accessory> accessToBeEquipped = new ArrayList<>();
        for (int index : indices) {
            accessToBeEquipped.add(player.getObtainedAccessories().get(index));
        }

        pet.equipAccessories(accessToBeEquipped);

        for (Accessory a : accessToBeEquipped) {
            player.removeAccesory(a);
        }
    }

    // REQUIRES: selected accessories are within pet.getEquippedAccessories();
    // MODIFIES: player, pet
    // EFFECTS: removes the selected accessories to the pets' equippedAccessories
    // and adds the selected accessories
    // from players' obtainedAccessories
    public void unequipAccessories(Pet pet, String input) {
        List<String> inputs = new ArrayList<String>(Arrays.asList(input.split(",")));

        List<Integer> indices = new ArrayList<>();
        for (String s : inputs) {
            int index = Integer.valueOf(s) - 1;
            indices.add(index);
        }

        List<Accessory> accessToBeUnequipped = new ArrayList<>();
        for (int index : indices) {
            accessToBeUnequipped.add(pet.getEquippedAccessories().get(index));
        }

        pet.unequipAccessories(accessToBeUnequipped);

        for (Accessory a : accessToBeUnequipped) {
            player.addAccesory(a);
        }
    }
}
