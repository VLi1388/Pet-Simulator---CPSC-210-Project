package persistence;

import model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Code for this class was referenced off the sample project given for phase 2
public class JsonTest {
    protected void checkPet(String name, String species, int mood, int hunger, int thirst, Pet pet) {
        assertEquals(name, pet.getName());
        assertEquals(species, pet.getSpecies());
        assertEquals(mood, pet.getMood());
        assertEquals(hunger, pet.getHunger());
        assertEquals(thirst, pet.getThirst());
    }
}
