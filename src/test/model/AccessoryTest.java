package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

public class AccessoryTest {
    private List<String> namesPool = Arrays.asList(new String[] { "Silver Pendant",
            "Galaxy Hat",
            "Red Bow Tie",
            "B&W Socks",
            "Cowboy Hat" });

    private Accessory testAccess1;
    private Accessory testAccess2;

    @BeforeEach
    void runBefore() {
        testAccess1 = new Accessory();
        testAccess2 = new Accessory("Silver Pendant");
    }

    @Test
    void testConstructor1() {
        assertTrue(namesPool.contains(testAccess1.getName()));
    }

    @Test
    void testConstructor2() {
        assertEquals("Silver Pendant", testAccess2.getName());
    }
}
