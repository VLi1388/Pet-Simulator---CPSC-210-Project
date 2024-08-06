package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

public class FoodTest {
    private List<String> namesPool = Arrays.asList(new String[]{"Fish", 
                                                                "Pork", 
                                                                "Beef", 
                                                                "Chicken",
                                                                "Lamb"});
                                                                
    private Food testFood;

    @BeforeEach
    void runBefore() {
        testFood = new Food();
    }

    @Test
    void testConstructor() {
        assertTrue(namesPool.contains(testFood.getName()));
        assertTrue(1 <= testFood.getHunger() && testFood.getHunger() <= 100);
    }
}
