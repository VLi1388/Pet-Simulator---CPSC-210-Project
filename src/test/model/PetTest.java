package model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

public class PetTest {
    public Pet cat;
    public Pet dog;

    @BeforeEach
    void runBefore() {
        cat = new Pet("Cat", "Bob");
        dog = new Pet("Dog", "Gill");
    }

    @Test
    void testConstructorCat() {
        assertEquals("Cat", cat.getSpecies());
        assertEquals("Bob", cat.getName());

        assertEquals(80, cat.getHunger());
        assertEquals(80, cat.getMood());
        assertEquals(80, cat.getThirst());

        assertEquals(0, cat.getXCoord());
        assertEquals(0, cat.getYCoord());

        List<Accessory> equippedAcces = cat.getEquippedAccessories();
        assertEquals(0, equippedAcces.size());


        List<Food> prefFood = cat.getPreferredFood();
        assertEquals(3, prefFood.size());

        List<Drink> prefDrinks = cat.getPreferredDrinks();
        assertEquals(3, prefDrinks.size());

        List<Interaction> prefInterac = cat.getPreferredInteractions();
        assertEquals(3, prefInterac.size());
    }

    @Test
    void testConstructorDog() {
        assertEquals("Dog", dog.getSpecies());
        assertEquals("Gill", dog.getName());

        assertEquals(80, dog.getHunger());
        assertEquals(80, dog.getMood());
        assertEquals(80, dog.getThirst());

        assertEquals(0, dog.getXCoord());
        assertEquals(0, dog.getYCoord());

        List<Accessory> equippedAcces = dog.getEquippedAccessories();
        assertEquals(0, equippedAcces.size());


        List<Food> prefFood = dog.getPreferredFood();
        assertEquals(3, prefFood.size());

        List<Drink> prefDrinks = dog.getPreferredDrinks();
        assertEquals(3, prefDrinks.size());

        List<Interaction> prefInterac = dog.getPreferredInteractions();
        assertEquals(3, prefInterac.size());
    }



    @Test
    void applyHungerDogByOne() {
        // remember default stat is 80
        dog.applyHunger(1);
        assertEquals(81, dog.getHunger());
        assertEquals(80, dog.getMood());
    }

    @Test
    void applyHungerDogBy100() {
        dog.setHunger(0);
        dog.applyHunger(100);
        assertEquals(100, dog.getHunger());
        assertEquals(90, dog.getMood());
    }

    @Test
    void applyHungerDogToBelow100() {
        dog.applyHunger(10);
        assertEquals(90, dog.getHunger());
        assertEquals(85, dog.getMood());
    }

    @Test
    void applyHungerDogTo100() {
        dog.applyHunger(20);
        assertEquals(100, dog.getHunger());
        assertEquals(90, dog.getMood());
    }
    
    @Test
    void applyHungerDogToOver100() {
        dog.applyHunger(50);
        assertEquals(100, dog.getHunger());
        assertEquals(90, dog.getMood());
    }
    
    @Test
    void applyHungerDogTwice() {
        dog.applyHunger(5);
        assertEquals(85, dog.getHunger());
        assertEquals(82, dog.getMood());

        dog.applyHunger(10);
        assertEquals(95, dog.getHunger());
        assertEquals(87, dog.getMood());
    }



    @Test
    void applyThisrtCatByOne() {
        // remember default stat is 80
        cat.applyThirst(1);
        assertEquals(81, cat.getThirst());
        assertEquals(80, cat.getMood());
    }

    @Test
    void applyThisrtCatBy100() {
        cat.setThirst(0);
        cat.applyThirst(100);
        assertEquals(100, cat.getThirst());
        assertEquals(90, cat.getMood());
    }

    @Test
    void applyThisrtCatToBelow100() {
        cat.applyThirst(10);
        assertEquals(90, cat.getThirst());
        assertEquals(85, cat.getMood());
    }

    @Test
    void applyThisrtCatTo100() {
        cat.applyThirst(20);
        assertEquals(100, cat.getThirst());
        assertEquals(90, cat.getMood());
    }
    
    @Test
    void applyThisrtCatToOver100() {
        cat.applyThirst(50);
        assertEquals(100, cat.getThirst());
        assertEquals(90, cat.getMood());
    }
    
    @Test
    void applyThisrtCatTwice() {
        cat.applyThirst(5);
        assertEquals(85, cat.getThirst());
        assertEquals(82, cat.getMood());

        cat.applyThirst(10);
        assertEquals(95, cat.getThirst());
        assertEquals(87, cat.getMood());
    }

    

    @Test
    void testUpdateMoodCatWholeNum() {
        cat.setMood(0);

        cat.setHunger(45);
        cat.setThirst(67);

        cat.updateMood();

        assertEquals(56, cat.getMood());
    }

    @Test
    void testUpdateMoodCatRoundedNum() {
        cat.setMood(0);

        cat.setHunger(45);
        cat.setThirst(66);

        cat.updateMood();

        assertEquals(55, cat.getMood());
    }

    @Test
    void testUpdateMoodCatChangeHunger() {
        cat.setMood(0);

        cat.setHunger(45);

        cat.updateMood();

        assertEquals(62, cat.getMood());
    }

    @Test
    void testUpdateMoodCatChangeThirst() {
        cat.setMood(0);

        cat.setThirst(66);

        cat.updateMood();

        assertEquals(73, cat.getMood());
    }

    @Test
    void testUpdateMoodLowerThanCurrentMood() {
        cat.setMood(90);

        cat.updateMood();

        assertEquals(90, cat.getMood());
    }

    @Test
    void testUpdateMoodLargerThanCurrentMood() {
        cat.setMood(70);

        cat.updateMood();

        assertEquals(80, cat.getMood());
    }



    @Test
    void applyMoodDogByOne() {
        // remember default stat is 80
        dog.applyMood(1);
        assertEquals(81, dog.getMood());
    }

    @Test
    void applyMoodDogBy100() {
        dog.setMood(0);
        dog.applyMood(100);
        assertEquals(100, dog.getMood());
    }

    @Test
    void applyMoodDogToBelow100() {
        dog.applyMood(10);
        assertEquals(90, dog.getMood());
    }

    @Test
    void applyMoodDogTo100() {
        dog.applyMood(20);
        assertEquals(100, dog.getMood());
    }
    
    @Test
    void applyMoodDogToOver100() {
        dog.applyMood(50);
        assertEquals(100, dog.getMood());
    }
    
    @Test
    void applyMoodDogTwice() {
        dog.applyMood(5);
        assertEquals(85, dog.getMood());

        dog.applyMood(10);
        assertEquals(95, dog.getMood());
    }




    // @Test
    // void testGeneratePreferencesCat() {

    //     List<Food> prefFood = cat.getPreferredFood();
    //     assertEquals(3, prefFood.size());

    //     List<Drink> prefDrinks = cat.getPreferredDrinks();
    //     assertEquals(3, prefDrinks.size());

    //     List<Interaction> prefInterac = cat.getPreferredInteractions();
    //     assertEquals(3, prefInterac.size());
    // }
    // covered in the constructor test



    @Test
    void testEquipAccessoriesDogOneItem() {
        Accessory access1 = new Accessory();

        List<Accessory> accessories = new ArrayList<>();
        accessories.add(access1);

        dog.equipAccessories(accessories);

        List<Accessory> equippedAccess = dog.getEquippedAccessories();
        assertEquals(1, equippedAccess.size());
        assertEquals(access1, equippedAccess.get(0));
    }

    @Test
    void testEquipAccessoriesDogMultipleItem() {
        Accessory access1 = new Accessory();
        Accessory access2 = new Accessory();
        Accessory access3 = new Accessory();

        List<Accessory> accessories = new ArrayList<>();
        accessories.add(access1);
        accessories.add(access2);
        accessories.add(access3);

        dog.equipAccessories(accessories);

        List<Accessory> equippedAccess = dog.getEquippedAccessories();
        assertEquals(3, equippedAccess.size());
        assertEquals(access1, equippedAccess.get(0));
        assertEquals(access2, equippedAccess.get(1));
        assertEquals(access3, equippedAccess.get(2));
    }

    @Test
    void testEquipAccessoriesDogDuplicate() {
        Accessory access1 = new Accessory();
        Accessory access2 = new Accessory();

        List<Accessory> accessories = new ArrayList<>();
        accessories.add(access1);
        accessories.add(access2);

        dog.equipAccessories(accessories);

        List<Accessory> equippedAccess1 = dog.getEquippedAccessories();
        assertEquals(2, equippedAccess1.size());
        assertEquals(access1, equippedAccess1.get(0));
        assertEquals(access2, equippedAccess1.get(1));

        Accessory access3 = new Accessory();
        accessories.add(access3);

        dog.equipAccessories(accessories);

        List<Accessory> equippedAccess2 = dog.getEquippedAccessories();
        assertEquals(3, equippedAccess2.size());
        assertEquals(access1, equippedAccess2.get(0));
        assertEquals(access2, equippedAccess2.get(1));
        assertEquals(access3, equippedAccess2.get(2));
    }



    @Test
    void testUnequipAccessoriesDogOneItemFromOne() {
        Accessory access1 = new Accessory();

        List<Accessory> accessories = new ArrayList<>();
        accessories.add(access1);

        dog.equipAccessories(accessories);

        dog.unequipAccessories(accessories);
        
        List<Accessory> equippedAccess = dog.getEquippedAccessories();
        assertEquals(0, equippedAccess.size());
    }

    @Test
    void testUnequipAccessoriesDogFirstItemFromMultiple() {
        Accessory access1 = new Accessory();
        Accessory access2 = new Accessory();
        Accessory access3 = new Accessory();

        List<Accessory> equipAccess = new ArrayList<>();
        equipAccess.add(access1);
        equipAccess.add(access2);
        equipAccess.add(access3);

        dog.equipAccessories(equipAccess);

        List<Accessory> unequipAccess = new ArrayList<>();
        unequipAccess.add(access1);

        dog.unequipAccessories(unequipAccess);

        List<Accessory> equippedAccess = dog.getEquippedAccessories();
        assertEquals(2, equippedAccess.size());
        assertEquals(access2, equippedAccess.get(0));
        assertEquals(access3, equippedAccess.get(1));
    }

    @Test
    void testUnequipAccessoriesDogMiddleItemFromMultiple() {
        Accessory access1 = new Accessory();
        Accessory access2 = new Accessory();
        Accessory access3 = new Accessory();

        List<Accessory> equipAccess = new ArrayList<>();
        equipAccess.add(access1);
        equipAccess.add(access2);
        equipAccess.add(access3);

        dog.equipAccessories(equipAccess);

        List<Accessory> unequipAccess = new ArrayList<>();
        unequipAccess.add(access2);

        dog.unequipAccessories(unequipAccess);

        List<Accessory> equippedAccess = dog.getEquippedAccessories();
        assertEquals(2, equippedAccess.size());
        assertEquals(access1, equippedAccess.get(0));
        assertEquals(access3, equippedAccess.get(1));
    }

    @Test
    void testUnequipAccessoriesDogLastItemFromMultiple() {
        Accessory access1 = new Accessory();
        Accessory access2 = new Accessory();
        Accessory access3 = new Accessory();

        List<Accessory> equipAccess = new ArrayList<>();
        equipAccess.add(access1);
        equipAccess.add(access2);
        equipAccess.add(access3);

        dog.equipAccessories(equipAccess);

        List<Accessory> unequipAccess = new ArrayList<>();
        unequipAccess.add(access3);

        dog.unequipAccessories(unequipAccess);

        List<Accessory> equippedAccess = dog.getEquippedAccessories();
        assertEquals(2, equippedAccess.size());
        assertEquals(access1, equippedAccess.get(0));
        assertEquals(access2, equippedAccess.get(1));
    }

    @Test
    void testUnequipAccessoriesDogMultipleItemNoLeftOver() {
        Accessory access1 = new Accessory();
        Accessory access2 = new Accessory();
        Accessory access3 = new Accessory();

        List<Accessory> equipAccess = new ArrayList<>();
        equipAccess.add(access1);
        equipAccess.add(access2);
        equipAccess.add(access3);

        dog.equipAccessories(equipAccess);

        List<Accessory> unequipAccess = new ArrayList<>();
        unequipAccess.add(access1);
        unequipAccess.add(access2);
        unequipAccess.add(access3);

        dog.unequipAccessories(unequipAccess);

        List<Accessory> equippedAccess = dog.getEquippedAccessories();
        assertEquals(0, equippedAccess.size());
    }

    @Test
    void testUnequipAccessoriesDogMultipleItemHasLeftOver() {
        Accessory access1 = new Accessory();
        Accessory access2 = new Accessory();
        Accessory access3 = new Accessory();
        Accessory access4 = new Accessory();

        List<Accessory> equipAccess = new ArrayList<>();
        equipAccess.add(access1);
        equipAccess.add(access2);
        equipAccess.add(access3);
        equipAccess.add(access4);

        dog.equipAccessories(equipAccess);

        List<Accessory> unequipAccess = new ArrayList<>();
        unequipAccess.add(access1);
        unequipAccess.add(access3);

        dog.unequipAccessories(unequipAccess);

        List<Accessory> equippedAccess = dog.getEquippedAccessories();
        assertEquals(2, equippedAccess.size());
        assertEquals(access2, equippedAccess.get(0));
        assertEquals(access4, equippedAccess.get(1));
    }

    // multiple has left over for start, middle, end?
}
