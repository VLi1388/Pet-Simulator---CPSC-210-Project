package model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

public class FoodTest extends Food{
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
