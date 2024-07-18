package model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

// represents a food with a name and how much hunger it gives
public class Food {
    private String name;
    private int hunger;

    protected List<String> namesPool = Arrays.asList(new String[]{"Fish", 
                                                                "Pork", 
                                                                "Beef", 
                                                                "Chicken",
                                                                "Lamb"});
    // using fixed-sized arrays here as there should be a fixed pool to choose from

    // EFFECTS: creates a food with a random name selected from the names pool
    //          and a random hunger between 1 and 100
    public Food() {
        Random rand = new Random();
        int selectIndex = rand.nextInt(4);

        this.name = namesPool.get(selectIndex);
        this.hunger = rand.nextInt(99) + 1; // +1 to make it [1,100]
    }

    public String getName() {
        return this.name;
    }

    public int getHunger() {
        return this.hunger;
    }

}
