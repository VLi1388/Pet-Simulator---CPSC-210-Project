package model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

public class AccessoryTest extends Accessory{
    private Accessory testAccess;

    @BeforeEach
    void runBefore() {
        testAccess = new Accessory();
    }

    @Test
    void testConstructor() {
        assertTrue(namesPool.contains(testAccess.getName()));
    }
}
