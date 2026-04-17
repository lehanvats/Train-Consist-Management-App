import java.util.Arrays;

/**
 * Use Case 19: Binary Search for Bogie ID
 * Implementation of optimized searching logic using a divide-and-conquer strategy.
 * [cite: 16, 26]
 */
public class UseCase19TrainConsistigant {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC19 - Binary Search for Bogie ID ");
        System.out.println("==========================================");

        // Create array of bogie IDs [cite: 35, 38]
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Ensure data is sorted before binary search (precondition) [cite: 39, 62, 67]
        Arrays.sort(bogieIds);

        String key = "BG309"; // [cite: 41]

        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        boolean found = performBinarySearch(bogieIds, key);

        if (found) {
            System.out.println("\nBogie " + key + " found using Binary Search."); // [cite: 86]
        } else {
            System.out.println("\nBogie " + key + " not found.");
        }

        System.out.println("\nUC19 search completed..."); // [cite: 87]
    }

    /**
     * Optimized search using Binary Search logic.
     * @param array The sorted array of Bogie IDs [cite: 49]
     * @param key The Bogie ID to search for [cite: 50]
     * @return true if found, false otherwise
     */
    public static boolean performBinarySearch(String[] array, String key) {
        if (array == null || array.length == 0) {
            return false; // Handle empty array [cite: 102, 122]
        }

        // Initialize low and high indexes [cite: 51, 68]
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            // Compute mid index correctly [cite: 52, 69]
            int mid = low + (high - low) / 2;

            // Compare key with mid element using compareTo() [cite: 53, 64, 70]
            int comparison = key.compareTo(array[mid]);

            if (comparison == 0) {
                return true; // Search Match Found [cite: 92]
            } else if (comparison < 0) {
                high = mid - 1; // Narrows search range to the left [cite: 24, 54]
            } else {
                low = mid + 1; // Narrows search range to the right [cite: 24, 54]
            }
        }
        return false; // Stop when range is exhausted [cite: 55, 71, 94]
    }
}