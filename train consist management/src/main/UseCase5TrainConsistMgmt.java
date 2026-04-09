package main;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Use Case 5: Preserve Insertion Order of Bogies
 * Description: Maintains exact attachment order of bogies while preventing duplicates[cite: 21, 22].
 */
public class UseCase5TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC5 - Preserve Insertion Order of Bogies ");
        System.out.println("==========================================\n");

        // Fetch the formation
        Set<String> formation = getTrainFormation();

        System.out.println("Final Train Formation:");
        System.out.println(formation); [cite: 70]

        System.out.println("\nNote:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically."); [cite: 72]
        System.out.println("\nUC5 formation setup completed..."); [cite: 73]
    }

    /**
     * Constructs the train formation using LinkedHashSet to ensure order and uniqueness.
     * @return Set containing the formatted train consist.
     */
    public static Set<String> getTrainFormation() {
        // LinkedHashSet preserves order and ensures uniqueness [cite: 39]
        Set<String> formation = new LinkedHashSet<>();

        // 1. User adds bogies [cite: 42]
        formation.add("Engine"); [cite: 58]
        formation.add("Sleeper"); [cite: 58]
        formation.add("Cargo"); [cite: 58]
        formation.add("Guard"); [cite: 58]

        // Attempt to attach a duplicate bogie intentionally [cite: 59]
        formation.add("Sleeper");

        return formation;
    }
}