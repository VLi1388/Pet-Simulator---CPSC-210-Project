package model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

// represents a food with a name and how much hunger it gives
public class Food {
    private String name;
    private int hunger;

    private List<String> namesPool = Arrays.asList(new String[]{"Fish", 
                                                                "Pork", 
                                                                "Beef", 
                                                                "Chicken",
                                                                "Lamb"});
    // using fixed-sized arrays here as there should be a fixed pool to choose from

    // EFFECTS: creates a food with a random name selected from the names pool
    //          and a random hunger between 1 and 100
    public Food() {

    }

}
