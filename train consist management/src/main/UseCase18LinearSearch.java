/**
 * Use Case 18: Linear Search for Bogie ID
 * This class demonstrates searching for a specific bogie ID using
 * a sequential traversal algorithm.
 */
public class UseCase18LinearSearch {

    public static void main(String[] args) {
        // Create array of bogie IDs [cite: 41, 70]
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Bogie ID to search [cite: 44, 71]
        String searchId = "BG309";

        System.out.println("UC18 Linear Search for Bogie ID");
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // Execute search logic
        UseCase18LinearSearch app = new UseCase18LinearSearch();
        boolean found = app.findBogie(bogieIds, searchId);

        if (found) {
            System.out.println("Bogie " + searchId + " found in train consist."); [cite: 90]
        } else {
            System.out.println("Bogie " + searchId + " not found.");
        }

        System.out.println("UC18 search completed..."); [cite: 91]
    }

    /**
     * Performs a linear search on the provided array.
     * Time Complexity: $O(n)$ [cite: 68]
     * * @param bogieIds The array to search through
     * @param searchId The ID to locate
     * @return true if found, false otherwise
     */
    public boolean findBogie(String[] bogieIds, String searchId) {
        boolean found = false;
        // Sequential traversal [cite: 30, 49, 72]
        for (String id : bogieIds) {
            // Equality comparison using equals() [cite: 66, 73]
            if (id.equals(searchId)) {
                found = true;
                break; // Early termination once match is found [cite: 31, 67, 74]
            }
        }
        return found;
    }
}
