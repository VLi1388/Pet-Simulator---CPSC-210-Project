package model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

public class DrinkTest {
    private List<String> namesPool = Arrays.asList(new String[]{"Milk", 
                                                                "Water", 
                                                                "Vegetable Juice"});
                                                                
    private Drink testDrink;

    @BeforeEach
    void runBefore() {
        testDrink = new Drink();
    }

    @Test
    void testConstructor() {
        assertTrue(namesPool.contains(testDrink.getName()));
        assertTrue(1 <= testDrink.getThirst() && testDrink.getThirst() <= 100);
    }
}
