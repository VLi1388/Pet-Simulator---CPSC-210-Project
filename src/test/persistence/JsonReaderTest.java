package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Code for this class was referenced off the sample project given for phase 2
class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Player player = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderInitialPlayerProfile() {
        // in my case, there wouldn't be an empty player profile since the player always have one pet
        JsonReader reader = new JsonReader("./data/testReaderInitialPlayerProfile.json");
        try {
            Player player = reader.read();
            assertEquals("Jane", player.getName());

            List<Pet> ownedPets = player.getOwnedPets(); 
            assertEquals(1, ownedPets.size());
            
            Pet initialPet = ownedPets.get(0);
            checkPet("Bill", "Dog", 80, 80, 80, initialPet);

            List<Accessory> equippedAccessories = initialPet.getEquippedAccessories();
            assertEquals(0, equippedAccessories.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    // @Test
    // void testReaderGeneralWorkRoom() {
    //     JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
    //     try {
    //         WorkRoom wr = reader.read();
    //         assertEquals("My work room", wr.getName());
    //         List<Thingy> thingies = wr.getThingies();
    //         assertEquals(2, thingies.size());
    //         checkThingy("needle", Category.STITCHING, thingies.get(0));
    //         checkThingy("saw", Category.WOODWORK, thingies.get(1));
    //     } catch (IOException e) {
    //         fail("Couldn't read from file");
    //     }
    // }

    @Test
    void testReaderOnePetPlayerProfile() {
        // player has no accessories, pet has no accessories, pet stats changed
        JsonReader reader = new JsonReader("./data/testReaderOnePetPlayerProfile.json");
        try {
            Player player = reader.read();
            assertEquals("Joe", player.getName());

            List<Pet> ownedPets = player.getOwnedPets(); 
            assertEquals(1, ownedPets.size());
            
            Pet initialPet = ownedPets.get(0);
            checkPet("Bob", "Dog", 52, 78, 67, initialPet);

            List<Accessory> equippedAccessories = initialPet.getEquippedAccessories();
            assertEquals(0, equippedAccessories.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderTwoPetPlayerProfile() {
        // player has no accesorries, one pet has accessories one doesn't
        JsonReader reader = new JsonReader("./data/testReaderTwoPetPlayerProfile.json");
        try {
            Player player = reader.read();
            assertEquals("Bob", player.getName());

            List<Pet> ownedPets = player.getOwnedPets(); 
            assertEquals(2, ownedPets.size());
            
            Pet initialPet = ownedPets.get(0);
            checkPet("Bill", "Dog", 82, 78, 80, initialPet);

            List<Accessory> equippedAccessories1 = initialPet.getEquippedAccessories();
            assertEquals(0, equippedAccessories1.size());

            Pet secondPet = ownedPets.get(1);
            checkPet("Milk", "Cat", 67, 67, 67, secondPet);

            List<Accessory> equippedAccessories2 = secondPet.getEquippedAccessories();
            assertEquals(1, equippedAccessories2.size());
            assertEquals("Galaxy Hat", equippedAccessories2.get(0).getName());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderThreePetPlayerProfile() {
        // player has accessories, two pets have accessories one doesn't
        JsonReader reader = new JsonReader("./data/testReaderThreePetPlayerProfile.json");
        try {
            Player player = reader.read();
            assertEquals("Anny", player.getName());

            List<Pet> ownedPets = player.getOwnedPets(); 
            assertEquals(3, ownedPets.size());
            
            Pet initialPet = ownedPets.get(0);
            checkPet("Bill", "Dog", 82, 78, 80, initialPet);

            List<Accessory> equippedAccessories1 = initialPet.getEquippedAccessories();
            assertEquals(0, equippedAccessories1.size());

            Pet secondPet = ownedPets.get(1);
            checkPet("Milk", "Cat", 67, 67, 67, secondPet);

            List<Accessory> equippedAccessories2 = secondPet.getEquippedAccessories();
            assertEquals(1, equippedAccessories2.size());
            assertEquals("Galaxy Hat", equippedAccessories2.get(0).getName());

            Pet thirdPet = ownedPets.get(2);
            checkPet("Chiu", "Bird", 72, 55, 70, thirdPet);

            List<Accessory> equippedAccessories3 = thirdPet.getEquippedAccessories();
            assertEquals(3, equippedAccessories3.size());
            assertEquals("B&W Socks", equippedAccessories3.get(0).getName());
            assertEquals("Silver Pendant", equippedAccessories3.get(1).getName());
            assertEquals("Red Bow Tie", equippedAccessories3.get(2).getName());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
        
    }
}