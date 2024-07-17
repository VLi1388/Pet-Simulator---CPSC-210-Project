package model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

// represents a food with a name and how much thirst it gives
public class Drink {
    private String name;
    private int thirst;

    private List<String> namesPool = Arrays.asList(new String[]{"Milk", 
                                                                "Water", 
                                                                "Vegetable Juice"});
    // using fixed-sized arrays here as there should be a fixed pool to choose from

    // EFFECTS: creates a drink with a random name selected from the names pool
    //          and a random thirst between 1 and 100
    public Drink() {

    }

}
