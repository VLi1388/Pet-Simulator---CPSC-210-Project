package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads player from JSON data stored in file
// Code for this class was referenced off the sample project given for phase 2
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Player read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);

        EventLog.getInstance().logEvent(new Event("Player profile loaded from file " + source));
        // System.out.println("Player profile loaded from file " + source);

        return parsePlayer(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses player from JSON object and returns it
    private Player parsePlayer(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Player player = new Player(name);
        addObtainedAccessories(player, jsonObject);
        addPets(player, jsonObject);

        return player;
    }

    // MODIFIES: player
    // EFFECTS: parses obtained accessories from JSON object and adds them to player
    private void addObtainedAccessories(Player player, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("obtained accessories");
        for (Object json : jsonArray) {
            JSONObject nextAccessory = (JSONObject) json;
            addObtainedAccessory(player, nextAccessory);
        }
    }

    // MODIFIES: player
    // EFFECTS: parses accessory from JSON object and adds it to player
    private void addObtainedAccessory(Player player, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Accessory accessory = new Accessory(name);
        player.addAccesory(accessory);
    }


    // MODIFIES: player
    // EFFECTS: parses pets from JSON object and adds them to player
    private void addPets(Player player, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("owned pets");
        for (Object json : jsonArray) {
            JSONObject nextPet = (JSONObject) json;
            addPet(player, nextPet);
        }
    }

    // MODIFIES: player
    // EFFECTS: parses pet from JSON object and adds it to player
    private void addPet(Player player, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String species = jsonObject.getString("species");
        int mood = jsonObject.getInt("mood");
        int hunger = jsonObject.getInt("hunger");
        int thirst = jsonObject.getInt("thirst");
        
        Pet pet = new Pet(species, name);
        pet.setMood(mood);
        pet.setHunger(hunger);
        pet.setThirst(thirst);

        addEquippedAccessories(pet, jsonObject);

        player.adoptPet(pet);
    }

    // MODIFIES: pet
    // EFFECTS: parses equipped accessories from JSON object and adds them to pet
    private void addEquippedAccessories(Pet pet, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("equipped accessories");
        
        List<Accessory> equippedAccessories = new ArrayList<>();

        for (Object json : jsonArray) {
            JSONObject nextAccessory = (JSONObject) json;
            String name = nextAccessory.getString("name");
            Accessory accessory = new Accessory(name);
            equippedAccessories.add(accessory);
        }

        pet.equipAccessories(equippedAccessories);
    }



    // by parsing, basically getting values from the json file and call the 
    // corresponding constructor on them, basically getting constructor
    // parameters from the file, so in our case, we're gonna need one for player
    // and for pet, since to construct a player, we need a name and an initial pet
}
