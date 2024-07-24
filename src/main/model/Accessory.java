package model;

import java.util.*;

import org.json.JSONObject;

import persistence.Writable;

// represents an accessory with a name and effect
// player is allowed to have multiple of the same accessories
public class Accessory implements Writable {
    private String name;

    // TODO: give random effects to accessories
    // private String effect;

    private List<String> namesPool = Arrays.asList(new String[]{"Silver Pendant", 
                                                                "Galaxy Hat", 
                                                                "Red Bow Tie", 
                                                                "B&W Socks",
                                                                "Cowboy Hat"});
    // using fixed-sized arrays here as there should be a fixed pool to choose from

    // EFFECTS: creates an accessory with a random name selected from the names pool
    //
    //          TODO: and a random effect selected from the effects pool
    public Accessory() {
        Random rand = new Random();
        int selectIndex = rand.nextInt(4);

        this.name = namesPool.get(selectIndex);
    }

    // EFFECTS: creates an accessory with the given name
    public Accessory(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);

        return json;
    }
}
