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
        this.name = name;
        ownedPets = new ArrayList<>();
        ownedPets.add(initialPet);
        obtainedAccessories = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Pet> getOwnedPets() {
        return this.ownedPets;
    }

    public ArrayList<Accessory> getObtainedAccessories() {
        return this.obtainedAccessories;
    }


    /*
     * MODIFIES: this
     * EFFECTS: adds the given pet to the list of owned pets.
     *          If the player has no pet, always adopt the 
     *          given pet;
     *          If te player has at least one pet, call on canAdopt
     *          // the player can only adopt one pet at a time;
     *          // the player can own up to three pets
     */
    public void adoptPet(Pet newPet) {
        if (ownedPets.size() == 0) {
            ownedPets.add(newPet);
        } else {
            if (canAdopt()) {
                ownedPets.add(newPet);
            }
        }
        // only call on canAdopt when there is at least one current pet
    }

    /* 
     * REQUIRES: ownedPets.size() > 0 AND ownedPets contains the given pet
     * // giveAwayPet would only be called on if the player selected "give away"
     * // under a specific pets' profile, so we can assume the requires clause
     * MODIFIES: this
     * EFFECTS: removes the given pet from the ownedPets list, given that
     */
    public void giveAwayPet(Pet pet) {
        ownedPets.remove(pet);
    }

    /*
     * REQUIRES: ownedPets.size() > 0
     * EFFECTS: returnes whether or not the player can adopt a new pet;
     *          if all currently owned pets have mood, hunger, and thirst
     *          >= 90 AND ownedPets.size() < 3, then the player can adopt 
     *          a new pet
     */
    public boolean canAdopt() {
        // first check if we're at capaity of 3 pets
        if (ownedPets.size() == 3) {
            return false;
        } else {
            boolean allMeetingStat = true;
            for (Pet p : ownedPets) {
                if (p.getHunger() < 90 || p.getMood() < 90 || p.getThirst() < 90) {
                    allMeetingStat = false;
                }
            }
            return allMeetingStat;
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds the given accesories to the list of already obtained accessories
     */
    public void addAccesory(Accessory newAccesory) {
        // since only one accessory will be droped at a time, addAccessory takes
        // in a single Accessory object

        obtainedAccessories.add(newAccesory);

    }
}
