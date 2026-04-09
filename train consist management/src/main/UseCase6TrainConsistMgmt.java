package main;

import java.util.HashMap;
import java.util.Map;

/**
 * Use Case 6: Map Bogie to Capacity (HashMap)
 * Description: Associates each bogie with its seating or load capacity
 * using a key-value mapping structure.
 */
public class UseCase6TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" UC6 - Map Bogie to Capacity (HashMap)");
        System.out.println("=========================================\n");

        UseCase6TrainConsistMgmt app = new UseCase6TrainConsistMgmt();

        // 1 & 2. Create HashMap and insert capacities
        Map<String, Integer> capacityMap = app.getBogieCapacities();

        System.out.println("Bogie Capacity Details:");

        // 3. Iterate over the map using entrySet()
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            // 4. Display each bogie along with its corresponding capacity
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUC6 bogie-capacity mapping completed...");
    }

    /**
     * Creates and populates the HashMap with bogie capacities.
     * Separated into its own method to facilitate Unit Testing.
     * * @return A populated HashMap of Bogie names (String) to Capacities (Integer)
     */
    public Map<String, Integer> getBogieCapacities() {
        // HashMap stores data in key-value format
        Map<String, Integer> capacityMap = new HashMap<>();

        // Insert bogie capacities
        capacityMap.put("First Class", 24);
        capacityMap.put("Cargo", 120);
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);

        return capacityMap;
    }
}