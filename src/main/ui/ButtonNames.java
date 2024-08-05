package ui;

// this class was referenced off the smart home project
public enum ButtonNames {
    SAVE("Save"),
    LOAD("Load"),
    NEW_GAME("New game"),
    LOAD_GAME("Load game"),
    VIEW_PET_1("View pet 1"),
    VIEW_PET_2("View pet 2"),
    VIEW_PET_3("View pet 3"),
    FEED("Feed"),
    FILL_WATER("Fill water"),
    INTERACT("Interact"),
    EQUIP_ACCESSORIES("Equip accessories"),
    UNEQUIP_ACCESSORIES("Unequip accessories"),
    CHECK_INVENTORY("Check inventory");

    private final String name;

    ButtonNames(String name) {
        this.name = name;
    }

    //EFFECTS: returns name value of this button
    public String getValue() {
        return name;
    }
}
