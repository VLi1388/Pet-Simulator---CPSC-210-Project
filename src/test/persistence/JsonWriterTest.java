package persistence;

import model.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Code for this class was referenced off the sample project given for phase 2
class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            Player player = new Player("Jane");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterInitialPlayerProfile() {
        try {
            Pet pet = new Pet("Dog","Bill");
            Player player = new Player("Jane", pet);
            JsonWriter writer = new JsonWriter("./data/testWriterInitialPlayerProfile.json");
            writer.open();
            writer.write(player);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterInitialPlayerProfile.json");
            player = reader.read();
            assertEquals("Jane", player.getName());

            List<Accessory> obtainedAccessories = player.getObtainedAccessories();
            assertEquals(0, obtainedAccessories.size());

            List<Pet> ownedPets = player.getOwnedPets(); 
            assertEquals(1, ownedPets.size());
            
            Pet initialPet = ownedPets.get(0);
            checkPet("Bill", "Dog", 80, 80, 80, initialPet);

            List<Accessory> equippedAccessories = initialPet.getEquippedAccessories();
            assertEquals(0, equippedAccessories.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterTwoPetsPlayerProfile() {
        // player has no accesorries, one pet has accessories one doesn't
        try {
            Pet pet1 = new Pet("Dog","Bill");
            Pet pet2 = new Pet("Cat","Mill");
            Player player = new Player("Jane", pet1);

            player.adoptPet(pet2);
            pet2.setMood(70);
            
            List<Accessory> accessories = new ArrayList<>();
            accessories.add(new Accessory("Red Bow Tie"));

            pet1.equipAccessories(accessories);

            JsonWriter writer = new JsonWriter("./data/testWriterTwoPetsPlayerProfile.json");
            writer.open();
            writer.write(player);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterTwoPetsPlayerProfile.json");
            player = reader.read();
            assertEquals("Jane", player.getName());

            List<Accessory> obtainedAccessories = player.getObtainedAccessories();
            assertEquals(0, obtainedAccessories.size());

            List<Pet> ownedPets = player.getOwnedPets(); 
            assertEquals(2, ownedPets.size());
            
            Pet initialPet = ownedPets.get(0);
            checkPet("Bill", "Dog", 80, 80, 80, initialPet);

            List<Accessory> equippedAccessories1 = initialPet.getEquippedAccessories();
            assertEquals(1, equippedAccessories1.size());
            assertEquals("Red Bow Tie", equippedAccessories1.get(0).getName());

            Pet secondPet = ownedPets.get(1);
            checkPet("Mill", "Cat", 70, 80, 80, secondPet);

            List<Accessory> equippedAccessories2 = secondPet.getEquippedAccessories();
            assertEquals(0, equippedAccessories2.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterThreePetsPlayerProfile() {
        // player has accessories, two pets have accessories one doesn't
        try {
            Pet pet1 = new Pet("Dog","Bill");
            Pet pet2 = new Pet("Cat","Mill");
            Pet pet3 = new Pet("Bird","Chippy");
            Player player = new Player("Jane", pet1);

            player.adoptPet(pet2);
            pet2.setMood(70);

            player.adoptPet(pet3);

            player.addAccesory(new Accessory("Silver Pendant"));
            player.addAccesory(new Accessory("Galaxy Hat"));
            
            List<Accessory> accessories = new ArrayList<>();
            accessories.add(new Accessory("Red Bow Tie"));

            pet1.equipAccessories(accessories); // pet1 has red bow tie

            accessories.add(new Accessory("B&W Socks"));

            pet2.equipAccessories(accessories); // pet2 has red bow tie, b&w socks

            JsonWriter writer = new JsonWriter("./data/testWriterThreePetsPlayerProfile.json");
            writer.open();
            writer.write(player);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterThreePetsPlayerProfile.json");
            player = reader.read();
            assertEquals("Jane", player.getName());

            List<Accessory> obtainedAccessories = player.getObtainedAccessories();
            assertEquals(2, obtainedAccessories.size());
            assertEquals("Silver Pendant", obtainedAccessories.get(0).getName());
            assertEquals("Galaxy Hat", obtainedAccessories.get(1).getName());

            List<Pet> ownedPets = player.getOwnedPets(); 
            assertEquals(3, ownedPets.size());
            
            Pet initialPet = ownedPets.get(0);
            checkPet("Bill", "Dog", 80, 80, 80, initialPet);

            List<Accessory> equippedAccessories1 = initialPet.getEquippedAccessories();
            assertEquals(1, equippedAccessories1.size());
            assertEquals("Red Bow Tie", equippedAccessories1.get(0).getName());

            Pet secondPet = ownedPets.get(1);
            checkPet("Mill", "Cat", 70, 80, 80, secondPet);

            List<Accessory> equippedAccessories2 = secondPet.getEquippedAccessories();
            assertEquals(2, equippedAccessories2.size());
            assertEquals("Red Bow Tie", equippedAccessories2.get(0).getName());
            assertEquals("B&W Socks", equippedAccessories2.get(1).getName());

            Pet thirdPet = ownedPets.get(2);
            checkPet("Chippy", "Bird", 80, 80, 80, thirdPet);

            List<Accessory> equippedAccessories3 = thirdPet.getEquippedAccessories();
            assertEquals(0, equippedAccessories3.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}