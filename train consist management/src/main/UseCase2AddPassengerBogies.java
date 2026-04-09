package main;

import java.util.ArrayList;
import java.util.List;

public class UseCase2AddPassengerBogies {

    public static void main(String[] args) {
        System.out.println(" UC2 Add Passenger Bogies to Train ");

        UseCase2AddPassengerBogies app = new UseCase2AddPassengerBogies();

        // 1. Create and populate the ArrayList
        List<String> passengerBogies = app.initializeConsist();
        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies: " + passengerBogies);

        // 2. Remove 'AC Chair'
        app.removeBogie(passengerBogies, "AC Chair");
        System.out.println("After Removing 'AC Chair':");
        System.out.println("Passenger Bogies: " + passengerBogies);

        // 3. Check for 'Sleeper' existence
        System.out.println("Checking if 'Sleeper' exists:");
        boolean hasSleeper = app.checkBogie(passengerBogies, "Sleeper");
        System.out.println("Contains Sleeper?: " + hasSleeper);

        // 4. Print final list state
        System.out.println("Final Train Passenger Consist:");
        System.out.println(passengerBogies);
        System.out.println("UC2 operations completed successfully...");
    }

    /**
     * Initializes the ArrayList with default passenger bogies.
     * @return List containing "Sleeper", "AC Chair", and "First Class"
     */
    public List<String> initializeConsist() {
        List<String> consist = new ArrayList<>();
        consist.add("Sleeper");
        consist.add("AC Chair");
        consist.add("First Class");
        return consist;
    }

    /**
     * Removes a specific bogie from the consist.
     * @param consist The current train consist list
     * @param bogie The bogie to remove
     */
    public void removeBogie(List<String> consist, String bogie) {
        consist.remove(bogie);
    }

    /**
     * Checks if a specific bogie exists in the consist.
     * @param consist The current train consist list
     * @param bogie The bogie to look for
     * @return true if the bogie exists, false otherwise
     */
    public boolean checkBogie(List<String> consist, String bogie) {
        return consist.contains(bogie);
    }
}