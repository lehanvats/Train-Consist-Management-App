package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Use Case 7: Sort Bogies by Capacity (Comparator)
 * Description: This class sorts passenger bogies based on seating
 * capacity using a custom Comparator.
 */
public class UseCase7TrainConsistMgmt {

    // Inner Bogie class to model passenger bogies
    public static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    // Extracted method to make sorting testable
    public static void sortBogies(List<Bogie> bogies) {
        bogies.sort(Comparator.comparingInt(b -> b.capacity));
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UC7 Sort Bogies by Capacity (Comparator) ");
        System.out.println("==============================================\n");

        // Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("Before Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // Apply Comparator logic
        sortBogies(bogies);

        System.out.println("\nAfter Sorting by Capacity:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        System.out.println("\nUC7 sorting completed...");
    }
}