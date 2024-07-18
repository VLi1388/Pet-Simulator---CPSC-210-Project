package model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

// represents a food with a name and how much thirst it gives
public class Drink {
    private String name;
    private int thirst;

    protected List<String> namesPool = Arrays.asList(new String[]{"Milk", 
                                                                "Water", 
                                                                "Vegetable Juice"});
    // using fixed-sized arrays here as there should be a fixed pool to choose from

    // EFFECTS: creates a drink with a random name selected from the names pool
    //          and a random thirst between 1 and 100
    public Drink() {
        Random rand = new Random();
        int selectIndex = rand.nextInt(2);

        this.name = namesPool.get(selectIndex);
        this.thirst = rand.nextInt(99) + 1; // +1 to make it [1,100]
    }

    public String getName() {
        return this.name;
    }

    public int getThirst() {
        return this.thirst;
    }

}
