package model;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;

// Represents a player having a name, list of owned pets, and list of accessories obtained
public class Player implements Writable {
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

    /*
     * REQUIRES: name has a length > 0;
     * EFFECTS: creates a player profile with a name set to the given name;
     *          initializes a list of empty owned pets;
     *          initialzes an empty list of obtained accessories
     */
    public Player(String name) {
        this.name = name;
        ownedPets = new ArrayList<>();
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
     * REQUIRES: canAdopt() is true
     * MODIFIES: this
     * EFFECTS: adds the given pet to the list of owned pets.
     */
    public void adoptPet(Pet newPet) {
        ownedPets.add(newPet);
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
     * EFFECTS: returnes whether or not the player can adopt a new pet:
     *          If all currently owned pets have mood, hunger, and thirst
     *          >= 90 AND ownedPets.size() < 3, then the player can adopt 
     *          a new pet;
     *          If the player has no pet, return true
     */
    public boolean canAdopt() {
        // first check if we're at capaity of 3 pets
        if (ownedPets.size() == 3) {
            return false;
        } else if (ownedPets.size() == 0) {
            return true;
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
        obtainedAccessories.add(newAccesory);
    }

    /*
     * MODIFIES: this
     * EFFECTS: removes the given accesories to the list of already obtained accessories
     */
    public void removeAccesory(Accessory newAccesory) {
        obtainedAccessories.remove(newAccesory);
    }

    // REQUIRES: spot is either 1,2,3
    // EFFECTS: check if the player actually owns a pet at the given spot
    public boolean isOwning(int spot) {
        if (spot <= this.ownedPets.size()) {
            return true;
        } else {
            return false;
        }
    }




    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("obtained accessories", accessoriesToJson());
        json.put("owned pets", ownedPetsToJson());
        return json;
    }

    // EFFECTS: returns obtained accessories of this player as a JSON array
    private JSONArray accessoriesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Accessory a : obtainedAccessories) {
            jsonArray.put(a.toJson());
        }

        return jsonArray;
    }

    // EFFECTS: returns owned pets of this player as a JSON array
    private JSONArray ownedPetsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Pet p : ownedPets) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }
}
