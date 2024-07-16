package model;

import java.util.*;

// Represents a pet with a name, mood, hunger, thirst, equipped accessories, and preferences
public class Pet {
    private String name; // pet name
    private int mood; // pet's mood, out of 100
    private int hunger; // pet's hunger, out of 100
    private int thirst; // pet's thirst, out of 100
    private ArrayList<Accessory> equippedAccessories; // list of equipped accessories of the pet

    private ArrayList<Food> preferredFood; // list of preferred food
    private ArrayList<Drink> preferredDrinks; // list of preferred drinks
    private ArrayList<Interaction> preferredInteractions; // list of preferred interactions

    private ArrayList<String> discoveredPreferences; // list of discovered preferences
    // remember to conver Food, Drink, Interaction objects to string using toString();

    /*
     * REQUIRES: name has a length > 0
     * EFFECTS: creates a pet with a name set to the given name;
     *          sets the intial mood, hunger, and thirst to 80;
     *          initializes an empty list of equipped accessories
     *          initialzes a list of preferred food, drinks, and interactions, each consisting of 3 itmes,
     *          where items are selected by random from the corresponding class;
     *          initialzes an empty list of discovered preferences.
     */
    public Pet(String name) {

    }

    //*** maybe?? */
    public void setName(String name) {
        // allows the player to change the pets' name
    }

    public String getName() {
        return this.name;
    }

    public int getMood() {
        return this.mood;
    }

    public int getHunger() {
        return this.hunger;
    }

    public int getThirst() {
        return this.thirst;
    }

    public ArrayList<Accessory> getEquippedAccessories() {
        return this.equippedAccessories;
    }
    
    public ArrayList<String> getDiscoveredPreferences() {
        return this.discoveredPreferences;
    }
}
