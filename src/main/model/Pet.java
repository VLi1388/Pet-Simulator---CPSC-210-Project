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

    private ArrayList<Food> preferredFood; // list of preferred food
    private ArrayList<Drink> preferredDrinks; // list of preferred drinks
    private ArrayList<Interaction> preferredInteractions; // list of preferred interactions

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
     * 
     *          // TODO: 
     *          initialzes a list of preferred food, drinks, and interactions, each consisting of 3 itmes,
     *          where items are selected by random from the corresponding class;
     *          initialzes an empty list of discovered preferences.
     */
    public Pet(String species, String name) {
        
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
    // EFFECTS: updates this pets' mood based on current hunger and thirst,
    //          mood = (hunger + thirst) / 2 rounded down to nearest integer
    public void updateMood() {

    }

    // REQUIRES: 0 < applyHunger <= 100
    // MODIFIES: this
    // EFFECTS: applies the given applyHunger to this pets' hunger, 
    //          this pets' hunger cannot go below 0 and cannot
    //          go above 100
    public void applyHunger(int applyHunger) {

    }

    // REQUIRES: 0 < applyThirst <= 100
    // MODIFIES: this
    // EFFECTS: applies the given applyThirst to this pets' thirst, 
    //          this pets' thirst cannot go below 0 and cannot
    //          go above 100
    public void applyThirst(int applyThirst) {

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
        // this.preferredFood = ...
        // this.preferredDrinks = ...
        // this.preferredInteractions = ...
    }

    // REQUIRES: accessory.size() > 0
    // MODIFIES: this
    // EFFECTS: adds the given list of accessories to this pet's equippedAccessories
    //          in the order it was given, ignores any duplicates
    public void equipAccessories(List<Accessory> accessories) {
        // use a for loop to merge the two lists
    }

    // REQUIRES: accessory.size() > 0; 
    //           all items in accessories already exsit in equippedAccessories
    // MODIFIES: this
    // EFFECTS: removes the given list of accessories to this pet's equippedAccessories
    public void unequipAccessories(List<Accessory> accessories) {
        // use a for loop to merge the two lists
    }
}
