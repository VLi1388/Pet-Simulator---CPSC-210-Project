package ui;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws Exception {
        // try {
        //     new PetSimulatorConsoleUI();
        // } catch (FileNotFoundException e) {
        //     System.out.println("Load file was not found. Unable to run simulator.");
        // }

        new PetSimulatorGUI();
    }
}
