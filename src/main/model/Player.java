package model;

import java.util.*;

// Represents a player having a name, list of owned pets, and list of accessories obtained
public class Player {
    private String name; // player name
    private ArrayList<Pet> ownedPets; // list of owned pets
    private ArrayList<Accessory> obtainedAccessories; // list of accessories obtained

    /*
     * REQUIRES: name has a length > 0;
     *           initialPet != null;
     * EFFECTS: creates a player profile with a name set to the given name;
     *          initializes a list of owned pets and adds the initial pet to it;
     *          initialzes an empty list of obtained accessories
     */
    public Player(String name, Pet initialPet) {

    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Pet> getPets() {
        return this.ownedPets;
    }

    public ArrayList<Accessory> getObtainedAccessories() {
        return this.obtainedAccessories;
    }


    /*
     * MODIFIES: this
     * EFFECTS: adds the given pet to the list of owned pets,
     *          the player can only adopt one pet at a time
     */
    public void adoptPet(Pet newPet) {

    }

    /*
     * MODIFIES: this
     * EFFECTS: adds the given accesories to the list of already obtained accessories
     */
    public void addAccesory(ArrayList<Accessory> newAccesory) {

    }

}
