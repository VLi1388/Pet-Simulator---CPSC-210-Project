package model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

public class PlayerTest {
    private Player jane;

    private Pet bill = new Pet("Horse", "Bill");

    @BeforeEach
    void runBefore() {
        jane = new Player("Jane", bill);
    }

    @Test
    void testConstructor() {
        assertEquals("Jane", jane.getName());

        List<Pet> ownedPets = jane.getOwnedPets();
        assertEquals(1, ownedPets.size());
        assertEquals(bill, ownedPets.get(0));

        List<Accessory> obtainedAccess = jane.getObtainedAccessories();
        assertEquals(0, obtainedAccess.size());
    }

    @Test
    void testAdoptPetOwningOneAlreadySucess() {
        bill.applyHunger(10); // h = 90, m = 85
        bill.applyMood(10); // m = 95
        bill.applyThirst(10); // t = 90, m = 95
        // h = 90, m = 95, t = 90, can adopt

        Pet bow = new Pet("Dragon", "Bow");
        jane.adoptPet(bow);

        List<Pet> ownedPets = jane.getOwnedPets();
        assertEquals(2, ownedPets.size());
        assertEquals(bill, ownedPets.get(0));
        assertEquals(bow, ownedPets.get(1));
    }

    @Test
    void testAdoptPetOwningOneAlreadyFail() {
        Pet bow = new Pet("Dragon", "Bow");
        // by default: h = 80, m = 80, t = 80, can't adopt

        jane.adoptPet(bow);

        List<Pet> ownedPets = jane.getOwnedPets();
        assertEquals(1, ownedPets.size());
        assertEquals(bill, ownedPets.get(0));
    }

    @Test
    void testAdoptPetOwningTwoAlreadySuccess() {
        bill.applyHunger(10);
        bill.applyMood(10);
        bill.applyThirst(10);

        Pet bow = new Pet("Dragon", "Bow");
        jane.adoptPet(bow); // successful adoption

        bow.applyHunger(10);
        bow.applyMood(10);
        bow.applyThirst(10);

        Pet hyu = new Pet("Elephant", "Hyu");
        jane.adoptPet(hyu); // successful adoption

        List<Pet> ownedPets = jane.getOwnedPets();
        assertEquals(3, ownedPets.size());
        assertEquals(bill, ownedPets.get(0));
        assertEquals(bow, ownedPets.get(1));
        assertEquals(hyu, ownedPets.get(2));
    }

    @Test
    void testAdoptPetOwningTwoAlreadyFail() {
        bill.applyHunger(10);
        bill.applyMood(10);
        bill.applyThirst(10);

        Pet bow = new Pet("Dragon", "Bow");
        jane.adoptPet(bow); // successful adoption

        Pet hyu = new Pet("Elephant", "Hyu");
        jane.adoptPet(hyu); // unsuccessful adoption

        List<Pet> ownedPets = jane.getOwnedPets();
        assertEquals(2, ownedPets.size());
        assertEquals(bill, ownedPets.get(0));
        assertEquals(bow, ownedPets.get(1));
    }

    @Test
    void testAdoptPetOwningThreeAlready() {
        bill.applyHunger(10);
        bill.applyMood(10);
        bill.applyThirst(10);

        Pet bow = new Pet("Dragon", "Bow");
        jane.adoptPet(bow); // successful adoption

        bow.applyHunger(10);
        bow.applyMood(10);
        bow.applyThirst(10);

        Pet hyu = new Pet("Elephant", "Hyu");
        jane.adoptPet(hyu); // successful adoption

        hyu.applyHunger(10);
        hyu.applyMood(10);
        hyu.applyThirst(10);

        Pet kio = new Pet("Bird", "Kio");
        jane.adoptPet(kio); // unsuccessful adoption, already has 3 pets

        List<Pet> ownedPets = jane.getOwnedPets();
        assertEquals(3, ownedPets.size());
        assertEquals(bill, ownedPets.get(0));
        assertEquals(bow, ownedPets.get(1));
        assertEquals(hyu, ownedPets.get(2));
    }

    @Test
    void testAdoptPetOwningNone() {
        jane.giveAwayPet(bill);

        Pet hyu = new Pet("Elephant", "Hyu");
        jane.adoptPet(hyu); // successful adoption

        List<Pet> ownedPets = jane.getOwnedPets();
        assertEquals(1, ownedPets.size());
        assertEquals(hyu, ownedPets.get(0));
    }

    @Test
    void testGiveAwayPetWithThreePetsSecondPet() {
        bill.applyHunger(10);
        bill.applyMood(10);
        bill.applyThirst(10);

        Pet bow = new Pet("Dragon", "Bow");
        jane.adoptPet(bow); // successful adoption

        bow.applyHunger(10);
        bow.applyMood(10);
        bow.applyThirst(10);

        Pet hyu = new Pet("Elephant", "Hyu");
        jane.adoptPet(hyu); // successful adoption


        jane.giveAwayPet(bow);

        List<Pet> ownedPets = jane.getOwnedPets();
        assertEquals(2, ownedPets.size());
        assertEquals(bill, ownedPets.get(0));
        assertEquals(hyu, ownedPets.get(1));
    }

    @Test
    void testGiveAwayPetWithTwoPetsFirstPet() {
        bill.applyHunger(10);
        bill.applyMood(10);
        bill.applyThirst(10);

        Pet bow = new Pet("Dragon", "Bow");
        jane.adoptPet(bow); // successful adoption

        jane.giveAwayPet(bill);

        List<Pet> ownedPets = jane.getOwnedPets();
        assertEquals(1, ownedPets.size());
        assertEquals(bow, ownedPets.get(0));
    }

    @Test
    void testGiveAwayPetWithOnePets() {
        jane.giveAwayPet(bill);

        List<Pet> ownedPets = jane.getOwnedPets();
        assertEquals(0, ownedPets.size());
    }

    @Test
    void testCanAdoptTrue() {
        bill.applyHunger(10);
        bill.applyMood(10);
        bill.applyThirst(10);

        assertTrue(jane.canAdopt());
    }

    @Test
    void testCanAdoptFalseStatDoesntMeetOnePet() {
        assertFalse(jane.canAdopt());
    }

    @Test
    void testCanAdoptFalseStatDoesntMeetMultiplePet() {
        bill.applyHunger(10);
        bill.applyMood(10);
        bill.applyThirst(10);

        assertTrue(jane.canAdopt());

        Pet bow = new Pet("Dragon", "Bow");
        jane.adoptPet(bow); // successful adoption

        assertFalse(jane.canAdopt());
    }

    @Test
    void testCanAdoptFalseStatMetAdoptionFull() {
        bill.applyHunger(10);
        bill.applyMood(10);
        bill.applyThirst(10);

        Pet bow = new Pet("Dragon", "Bow");
        jane.adoptPet(bow); // successful adoption

        bow.applyHunger(10);
        bow.applyMood(10);
        bow.applyThirst(10);

        Pet hyu = new Pet("Elephant", "Hyu");
        jane.adoptPet(hyu); // successful adoption

        hyu.applyHunger(10);
        hyu.applyMood(10);
        hyu.applyThirst(10);

        assertFalse(jane.canAdopt());
    }

    @Test
    void testCanAdoptHungerDoesntMeet() {
        bill.setHunger(80);
        bill.setMood(90);
        bill.setThirst(90);

        assertFalse(jane.canAdopt());
    }

    @Test
    void testCanAdoptMoodDoesntMeet() {
        bill.setHunger(90);
        bill.setMood(80);
        bill.setThirst(90);

        assertFalse(jane.canAdopt());
    }

    @Test
    void testCanAdoptThirstDoesntMeet() {
        bill.setHunger(90);
        bill.setMood(90);
        bill.setThirst(80);

        assertFalse(jane.canAdopt());
    }

    @Test
    void testAddAccessoryOnce() {
        Accessory access1 = new Accessory();

        jane.addAccesory(access1);

        List<Accessory> obtainedAccess = jane.getObtainedAccessories();
        assertEquals(1, obtainedAccess.size());
        assertEquals(access1, obtainedAccess.get(0));
    }

    @Test
    void testAddAccessoryMultiple() {
        Accessory access1 = new Accessory();
        Accessory access2 = new Accessory();
        Accessory access3 = new Accessory();

        jane.addAccesory(access1);
        jane.addAccesory(access2);
        jane.addAccesory(access3);

        List<Accessory> obtainedAccess = jane.getObtainedAccessories();
        assertEquals(3, obtainedAccess.size());
        assertEquals(access1, obtainedAccess.get(0));
        assertEquals(access2, obtainedAccess.get(1));
        assertEquals(access3, obtainedAccess.get(2));
    }
}
