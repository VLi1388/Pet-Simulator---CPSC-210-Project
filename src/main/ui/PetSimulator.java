package ui;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.Pet;
import model.Player;
import persistence.JsonReader;
import persistence.JsonWriter;
import model.Accessory;

// a pet simulator that allows the player to adopt pets and interact with their pets
// many methods in this class are referenced off lab 3 and lab 4
public class PetSimulator {
    // private final int TICKS_PER_SECOND = 1;
    private static final String JSON_STORE = "./data/player.json";

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private Player player;

    private Scanner scanner;
    private boolean isSimulatorRunning;
    private boolean inWelcomeMenu;

    private boolean inPetsMenu;

    // EFFECTS: creates an instance of the PetSimulator console ui application
    public PetSimulator() throws IOException, InterruptedException, FileNotFoundException {
        this.scanner = new Scanner(System.in);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        // run the simulator
        this.isSimulatorRunning = true;


        this.inWelcomeMenu = true;
        while (inWelcomeMenu) {
            handleWelcomeMenu();
        }

        // TODO: implement a tick method that will decrease pet status with time
        // beginTicks();

        while (isSimulatorRunning == true) {
            handleMenu();
        }

    }

    // EFFECTS: handles the welcoming screen menu
    private void handleWelcomeMenu() {
        printSeparation();

        System.out.println("Welcome to the pet simulator!");

        printSeparation();

        System.out.println("Please select an option:\n");
        System.out.println("n: Create a new player profile");
        System.out.println("l: Load player profile from file");

        String input = this.scanner.nextLine();

        processWelcomeMenuCommands(input);
    }

    // EFFECTS: processes the user command for the welcome menu
    private void processWelcomeMenuCommands(String input) {
        switch (input) {
            case "n":
                createPlayerProfile();
                inWelcomeMenu = false;
                break;
            case "l":
                loadPlayerProfile();
                inWelcomeMenu = false;
                break;
            default:
                System.out.println("Invalid option inputted. Please try again.");
        }
    }

    // MODIFIES: player, initialPet
    // EFFECTS: initializes the simulator by setting up a player profile
    private void createPlayerProfile() {
        printSeparation();

        System.out.println("What is your name?");
        String playerName = this.scanner.nextLine();

        System.out.println("What species would you like to adopt?");
        String initialPetSpecies = this.scanner.nextLine();

        System.out.println("What would you like to name your first pet as?");
        String initialPetName = this.scanner.nextLine();

        Pet initialPet = new Pet(initialPetSpecies, initialPetName);

        player = new Player(playerName, initialPet);
    }

    // // EFFECTS: runs tick TICKS_PER_SECOND times per second until the user quits,
    // then exits
    // // this method was based off lab 4
    // private void beginTicks() throws IOException, InterruptedException {
    // while (isSimulatorRunning == true) {
    // tick();
    // Thread.sleep(1000L / TICKS_PER_SECOND);
    // }

    // System.exit(0);
    // }

    // private void tick() {
    // for (Pet p : player.getOwnedPets()) {
    // p.decreaseMood();
    // p.decreaseHunger();
    // p.decreaseThirst();
    // }
    // }

    // MODIFIES: p
    // EFFECTS: decreases the pets' status
    private void decreasePetStatus() {
        for (Pet p : player.getOwnedPets()) {
            p.decreaseMood();
            p.decreaseHunger();
            p.decreaseThirst();
        }
    }

    // EFFECTS: displayers the player's name, list of currently owned pets, list of
    // obtained accessories
    // and a menu for further action with the pets and accessories
    private void displayPlayerProfile() {
        printSeparation();

        System.out.println("Player: " + player.getName());

        printObtainedAccessories();

        printOwnedPets();

        handlePet();
    }

    // EFFECTS: prints out the players' currently obtained accessories
    private void printObtainedAccessories() {
        System.out.println("Obtained accessories: ");
        List<Accessory> obtainedAccess = this.player.getObtainedAccessories();
        for (Accessory a : obtainedAccess) {
            System.out.println(a.getName());
        }

        System.out.println();
    }

    // EFFECTS: prints out the players' currently owned pets
    private void printOwnedPets() {
        System.out.println("Currently owned pets: ");
        for (Pet p : player.getOwnedPets()) {
            System.out.println("Name: " + p.getName());
            System.out.println("Species: " + p.getSpecies());
            System.out.println("Mood: " + p.getMood());
            System.out.println("Hunger: " + p.getHunger());
            System.out.println("Thirst: " + p.getThirst());

            printPetEquippedAccessories(p);

            System.out.println();
        }
    }

    // EFFECTS: lists out the accessories currently equipped by the given pet
    private void printPetEquippedAccessories(Pet pet) {
        System.out.println("Equipped accessories:");
        for (Accessory a : pet.getEquippedAccessories()) {
            System.out.println(a.getName());
        }
    }

    // EFFECTS: asks whether the player wants to do anything with their pets
    private void handlePet() {
        boolean inLoop = true;

        while (inLoop) {
            printSeparation();

            System.out.println("Would you like to do anything with your pets? (y/n)");
            String input = this.scanner.nextLine();

            switch (input) {
                case "y":
                    inPetsMenu = true;
                    while (inPetsMenu) {
                        handlePetsMenu();
                    }
                    inLoop = false;
                    break;
                case "n":
                    inLoop = false;
                    break;
                default:
                    System.out.println("Invalid option inputted. Please try again.");
            }

            decreasePetStatus();
            // stub implementation: pet status will decrease everytime the user inputs a command
        }
    }

    // EFFECTS: displays and handles user inputs for the main menu
    private void handleMenu() {
        displayMenu();
        String input = this.scanner.nextLine();

        processMenuCommands(input);

        decreasePetStatus();
        // stub implementation: pet status will decrease everytime the user inputs a command
    }

    // EFFECTS: displays a list of commands the user can choose to input from the
    // main menu
    private void displayMenu() {
        printSeparation();

        System.out.println("Please select an option:\n");
        System.out.println("p: View my profile");
        System.out.println("a: Adopt a new pet (All current pets must have all stats >= 90)");
        System.out.println("s: Save player profile to file");
        System.out.println("l: Load player profile from file");
        System.out.println("q: Quit game");
    }

    // EFFECTS: processes the user's input in the main menu
    private void processMenuCommands(String input) {
        switch (input) {
            case "p":
                displayPlayerProfile();
                break;
            case "a":
                adoptPet();
                break;
            case "s":
                savePlayerProfile();
                break;
            case "l":
                loadPlayerProfile();
                break;
            case "q":
                quitGame();
                break;
            default:
                System.out.println("Invalid option inputted. Please try again.");
        }
    }

    // MODIFIES: player, newPet
    // EFFECTS: asks the player for a pet that they want to adopt, and adopt that
    // pet
    private void adoptPet() {
        printSeparation();

        if (player.canAdopt() == false) {
            System.out.println("Sorry, you cannot adopt a pet for now.");
        } else {
            System.out.println("What species would you like to adopt?");
            String species = this.scanner.nextLine();

            System.out.println("What would you like to name your pet as?");
            String name = this.scanner.nextLine();

            Pet newPet = new Pet(species, name);

            this.player.adoptPet(newPet);
        }
    }

    // EFFECTS: saves the player profile to file
    private void savePlayerProfile() {
        try {
            jsonWriter.open();
            jsonWriter.write(player);
            jsonWriter.close();
            System.out.println("Saved " + player.getName() + "'s profile to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads player profile from file
    private void loadPlayerProfile() {
        try {
            player = jsonReader.read();
            System.out.println("Loaded " + player.getName() + "'s profile from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: quits the game
    public void quitGame() {
        printSeparation();

        System.out.println("Thanks for trying the pet simulator!");
        System.out.println("Have a good day!");
        this.isSimulatorRunning = false;
    }

    // EFFECTS: displays and handles user inputs for the pet menu
    private void handlePetsMenu() {
        printSeparation();

        System.out.println("Please select a pet: (1/2/3), or \"q\" to return to the main menu");
        String select = this.scanner.nextLine();

        processPetsMenuCommand(select);

        decreasePetStatus();
        // stub implementation: pet status will decrease everytime the user inputs a command
    }

    // EFFECTS: proccesses input commands for the pets menu
    private void processPetsMenuCommand(String select) {
        int petIndex = 0;
        try {
            petIndex = Integer.valueOf(select);
        } catch (NumberFormatException e) {
            // System.out.println("Invalid option inputted. Please try again.");
        }

        if (select.equals("q")) {
            inPetsMenu = false;
        } else if (petIndex < 1 || petIndex > 3) {
            System.out.println("Invalid option inputted. Please try again.");
        } else if (this.player.isOwning(petIndex) == true) {
            handleSpecificPetMenu(player.getOwnedPets().get(petIndex - 1));
        } else {
            System.out.println("Sorry you don't own that pet");
        }
    }

    // MODIFIES: pet, player
    // EFFECTS: displays and handles user inputs for a specific pet
    private void handleSpecificPetMenu(Pet pet) {
        displaySpecificPetMenu();
        String input = this.scanner.nextLine();

        processSpecificPetCommand(input, pet);

        decreasePetStatus();
        // stub implementation: pet status will decrease everytime the user inputs a command
    }

    // EFFECTS: displays the menu for a specific pet
    private void displaySpecificPetMenu() {
        printSeparation();

        System.out.println("Please select an option:\n");
        System.out.println("f: Give the pet food");
        System.out.println("w: Give the pet drinks");
        System.out.println("i: Interact with the pet");
        System.out.println("e: Equip the pet with accessories");
        System.out.println("u: Unequip the pet with accessories");
    }

    // MODIFIES: pet
    // EFFECTS: processes the commands for a specific pet
    private void processSpecificPetCommand(String input, Pet pet) {
        switch (input) {
            case "f":
                pet.applyHunger(30);
                System.out.println(pet.getName() + "'s hunger increased by 30!");
                // TODO: implement so that we use a Food object to call on applyHunger
                break;
            case "w":
                pet.applyThirst(30);
                System.out.println(pet.getName() + "'s thirst increased by 30!");
                // TODO: implement so that we use a Drink object to call on applyThirst
                break;
            case "i":
                pet.applyMood(30);
                System.out.println(pet.getName() + "'s mood increased by 30!");
                // TODO: implement so that we use an Interaction object to call on applyMood
                // for now, just assume that interacting with the pet adds on to its moodC
                dropAccessory(pet);
                break;
            case "e":
                equipAccessories(pet);
                break;
            case "u":
                unequipAccessories(pet);
                break;
            default:
                System.out.println("Invalid option inputted. Please try again.");
        }
    }

    // MODIFIES: droppedAccessory, player
    // EFFECTS: when the player interacts with the pet, there is a chance for a
    // random accessory, the accessory is automatically obtained by the player
    // to be dropped (by creating a new accessory object)
    private void dropAccessory(Pet pet) {
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
    private void equipAccessories(Pet pet) {
        printSeparation();

        System.out.println(
                "Please select the accessories you want to equip your pet with >>>");

        printObtainedAccessories();

        System.out.println("Please input based on accessory order position, separated by \",\"");
        String input = this.scanner.nextLine();

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

        decreasePetStatus();
        // stub implementation: pet status will decrease everytime the user inputs a command
    }

    // REQUIRES: selected accessories are within pet.getEquippedAccessories();
    // MODIFIES: player, pet
    // EFFECTS: removes the selected accessories to the pets' equippedAccessories
    // and adds the selected accessories
    // from players' obtainedAccessories
    private void unequipAccessories(Pet pet) {
        printSeparation();

        System.out.println(
                "Please select the accessories you want to unequip your pet with >>>");

        printPetEquippedAccessories(pet);

        System.out.println("Please input based on accessory order position, separated by \",\"");
        String input = this.scanner.nextLine();

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

        decreasePetStatus();
        // stub implementation: pet status will decrease everytime the user inputs a command
    }

    // EFFECTS: prints a separation line
    private void printSeparation() {
        System.out.println("------------------------------------------------------------------------------");
    }
}
