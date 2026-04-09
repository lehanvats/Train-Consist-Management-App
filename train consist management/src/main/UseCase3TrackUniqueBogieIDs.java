package main;

import java.util.HashSet;
import java.util.Set;

/**
 * Use Case 3: Track Unique Bogie IDs
 * Description: Ensures duplicate bogie IDs are not added into the train formation using HashSet.
 * @author Developer
 * @version 3.0
 */
public class UseCase3TrackUniqueBogieIDs {

    /**
     * Creates and returns a HashSet of Bogie IDs, intentionally adding duplicates
     * to demonstrate automatic deduplication.
     */
    public static Set<String> getUniqueBogies() {
        Set<String> bogies = new HashSet<>();

        // Add unique IDs
        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");

        // Attempt to add duplicate entries (these will be ignored internally)
        bogies.add("BG101");
        bogies.add("BG102");

        return bogies;
    }

    public static void main(String[] args) {
        System.out.println("-------------------------------------------------");
        System.out.println("          UC3 Track Unique Bogie IDs             ");
        System.out.println("-------------------------------------------------");

        Set<String> bogies = getUniqueBogies();

        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogies);
        System.out.println("\nNote:");
        System.out.println("Duplicates are automatically ignored by HashSet.");
        System.out.println("UC3 uniqueness validation completed...");
    }
}