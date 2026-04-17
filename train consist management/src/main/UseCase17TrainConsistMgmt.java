package main;

import java.util.Arrays;

/**
 * Use Case 17: Sort Bogie Names Using Arrays.sort()
 * This class demonstrates sorting of bogie type names alphabetically
 * using Java's built-in Arrays.sort() method. [cite: 24, 26]
 * * @author Developer
 * @version 17.0
 */
public class UseCase17TrainConsistMgmt {

    public static void main(String[] args) {
        UseCase17TrainConsistMgmt app = new UseCase17TrainConsistMgmt();

        System.out.println("=========================================");
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("=========================================");

        // Input array of bogie names [cite: 67, 85]
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("\nOriginal Bogie Names:");
        System.out.println(Arrays.toString(bogieNames)); [cite: 55, 67]

        // Sorting the array using built-in utility [cite: 29, 40]
        Arrays.sort(bogieNames);

        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames)); [cite: 55, 69]

        System.out.println("\nUC17 sorting completed..."); [cite: 70]
    }

    /**
     * Helper method for unit testing logic.
     * @param bogies The original array of bogie names.
     * @return A new sorted array of bogie names.
     */
    public String[] sortBogieNames(String[] bogies) {
        if (bogies == null) return null;
        String[] sortedArray = bogies.clone();
        Arrays.sort(sortedArray); [cite: 53]
        return sortedArray;
    }
}