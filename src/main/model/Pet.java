package model;

import java.util.*;

// Represents a pet with a name, species, mood, hunger, thirst, equipped accessories, and preferences
public class Pet {
    private String species; // pet species
    private String name; // pet name
    private int mood; // pet's mood, out of 100
    private int hunger; // pet's hunger, out of 100
    private int thirst; // pet's thirst, out of 100
    private ArrayList<Accessory> equippedAccessories; // list of equipped accessories of the pet

    // pet location in the room
    private int theXPos;
    private int theYPos;

    private ArrayList<Food> preferredFood = new ArrayList<>(); // list of preferred food
    private ArrayList<Drink> preferredDrinks = new ArrayList<>(); // list of preferred drinks
    private ArrayList<Interaction> preferredInteractions = new ArrayList<>(); // list of preferred interactions

    // private ArrayList<String> discoveredPreferences; // list of discovered preferences
    // remember to conver Food, Drink, Interaction objects to string using toString();
    // mayber better to make into a method?

    /*
     * REQUIRES: name has a length > 0
     * EFFECTS: creates a pet with a name set to the given name;
     *          sets the intial mood = (hunger + thirst) / 2 = 80,
     *                          hunger = 80, 
     *                          thirst = 80;
     *          initializes an empty list of equipped accessories
     *          initialzes a list of preferred food, drinks, and interactions, each consisting of 3 itmes,
     *          where items are selected by random from the corresponding class;
     * 
     *          // TODO: 
     *          initialzes an empty list of discovered preferences.
     */
    public Pet(String species, String name) {
        this.species = species;
        this.name = name;
        this.hunger = 80;
        this.thirst = 80;
        this.mood = (hunger + thirst) / 2;
        this.equippedAccessories = new ArrayList<>();

        // for now, default position at (0,0)
        // TODO: for future implementations, give pet a random location at the start
        this.theXPos = 0;
        this.theYPos = 0;

        generatePreferences();
    }

    // for future implementation, if I want to allow the player to
    // change the name of their pet
    // public void setName(String name) {
    //     // allows the player to change the pets' name
    // }

    public String getSpecies() {
        return this.species;
    }

    public String getName() {
        return this.name;
    }

    public int getMood() {
        return this.mood;
    }

    // for testing purposes
    public void setMood(int mood) {
        this.mood = mood;
    }

    public int getHunger() {
        return this.hunger;
    }

    // for testing purposes
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return this.thirst;
    }

    // for testing purposes
    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getXCoord() {
        return this.theXPos;
    }

    // public void setXCoord(int xCoord) {
    //     this.xCoord = xCoord;
    // }

    public int getYCoord() {
        return this.theYPos;
    }

    // public void setYCoord(int yCoord) {
    //     this.yCoord = yCoord;
    // }


    public ArrayList<Accessory> getEquippedAccessories() {
        return this.equippedAccessories;
    }

    public ArrayList<Food> getPreferredFood() {
        return this.preferredFood;
    }

    public ArrayList<Drink> getPreferredDrinks() {
        return this.preferredDrinks;
    }

    public ArrayList<Interaction> getPreferredInteractions() {
        return this.preferredInteractions;
    }

    // MODIFIES: this
    // EFFECTS: updates this pets' mood based on current hunger and thirst
    //          only if the newMood is larger than the current mood
    //          mood is the average of hunger and thirst rounded down to 
    //          nearest integer
    public void updateMood() {
        int newMood = (hunger + thirst) / 2;
        if (newMood > mood) {
            this.mood = newMood;
        }
    }

    // REQUIRES: 0 < applyMoodVal <= 100
    // MODIFIES: this
    // EFFECTS: applies the given applyMoodVal to this pets' mood, 
    //          this pets' mood cannot go below 0 and cannot
    //          go above 100;
    public void applyMood(int applyMoodVal) {
        // mood can also be directly modified, a change in hunger or thirst always changes mood,
        // but a change in mood does not impact hunger or thirst
        if ((this.mood + applyMoodVal) > 100) {
            this.mood = 100;
        } else {
            this.mood += applyMoodVal;
        }
    }

    // MODIFIES: this
    // EFFECTS: decrease mood by 1
    public void decreaseMood() {
        this.mood--;
    }

    // REQUIRES: 0 < applyHungerVal <= 100
    // MODIFIES: this
    // EFFECTS: applies the given applyHungerVal to this pets' hunger, 
    //          this pets' hunger cannot go below 0 and cannot
    //          go above 100;
    //          since hunger changed, mood should be updated
    public void applyHunger(int applyHungerVal) {
        if ((this.hunger + applyHungerVal) > 100) {
            this.hunger = 100;
            updateMood();
        } else {
            this.hunger += applyHungerVal;
            updateMood();
        }
    }

    // MODIFIES: this
    // EFFECTS: decrease hunger by 1
    public void decreaseHunger() {
        this.hunger--;
    }

    // REQUIRES: 0 < applyThirstVal <= 100
    // MODIFIES: this
    // EFFECTS: applies the given applyThirstVal to this pets' thirst, 
    //          this pets' thirst cannot go below 0 and cannot
    //          go above 100;
    //          since thirst changed, mood should be updated
    public void applyThirst(int applyThirstVal) {
        if ((this.thirst + applyThirstVal) > 100) {
            this.thirst = 100;
            updateMood();
        } else {
            this.thirst += applyThirstVal;
            updateMood();
        }
    }

    // MODIFIES: this
    // EFFECTS: decrease thirst by 1
    public void decreaseThirst() {
        this.thirst--;
    }
    
    // TODO: for future implementation, 
    // separate preferences into discovered and undiscovered
    // public ArrayList<String> getDiscoveredPreferences() {
    //     return this.discoveredPreferences;
    // }

    // MODIFIES: this
    // EFFECTS: generates a list of preferred food, drinks, and interactions at ramdom,
    //          each consisting of 3
    public void generatePreferences() {
        // food preferences
        for (int i = 0; i < 3; i++) {
            preferredFood.add(new Food());
        }
        
        // drink preferences
        for (int i = 0; i < 3; i++) {
            preferredDrinks.add(new Drink());
        }

        // interaction preferences
        for (int i = 0; i < 3; i++) {
            preferredInteractions.add(new Interaction());
        }
    }

    // REQUIRES: accessory.size() > 0
    // MODIFIES: this
    // EFFECTS: adds the given list of accessories to this pet's equippedAccessories
    //          in the order it was given, ignores any duplicates
    public void equipAccessories(List<Accessory> accessories) {
        for (Accessory a : accessories) {
            if (!equippedAccessories.contains(a)) {
                equippedAccessories.add(a);
            }
        }
    }

    // REQUIRES: accessory.size() > 0; 
    //           all items in accessories already exsit in equippedAccessories
    //           // UI would ask player to "select" accessories out of equipped accessories
    //           // to unequip them, so it is assumed that the 2nd condition is met
    // MODIFIES: this
    // EFFECTS: removes the given list of accessories to this pet's equippedAccessories
    public void unequipAccessories(List<Accessory> accessories) {
        for (Accessory a : accessories) {
            equippedAccessories.remove(a);
        }
    }
}
