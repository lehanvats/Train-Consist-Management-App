/**
 * UC20: Exception Handling During Search Operations
 * This class demonstrates defensive programming by throwing an IllegalStateException
 * if a search is attempted on an empty train consist.
 */
public class UseCase20TrainConsistMgmt {

    public static void main(String[] args) {
        // Create empty bogie array (empty train scenario) [cite: 39]
        String[] bogieIds = {};
        String searchId = "86101"; [cite: 41]

        try {
            System.out.println("UC20 Exception Handling During Search"); [cite: 81]
            boolean found = searchBogie(bogieIds, searchId);

            if (found) {
                System.out.println("Bogie " + searchId + " found.");
            } else {
                System.out.println("Bogie " + searchId + " not found.");
            }
        } catch (IllegalStateException e) {
            // Display meaningful message when state validation fails [cite: 31, 71]
            System.err.println("Exception in thread \"main\" " + e.getClass().getName() + ": " + e.getMessage()); [cite: 82]
        }

        System.out.println("\nUC20 execution completed..."); [cite: 52]
    }

    /**
     * Performs a fail-fast search for a bogie ID.
     * @param bogieIds The collection of bogies.
     * @param searchId The ID to search for.
     * @return true if found, false otherwise.
     * @throws IllegalStateException if the bogie collection is empty.
     */
    public static boolean searchBogie(String[] bogieIds, String searchId) {
        // FAIL-FAST VALIDATION: Check if train has bogies [cite: 43, 44, 68]
        if (bogieIds == null || bogieIds.length == 0) {
            // Throws exception if empty to stop invalid search early [cite: 29, 30, 57, 70]
            throw new IllegalStateException("No bogies available in train. Cannot perform search."); [cite: 82, 87]
        }

        // SEARCH LOGIC: Executes only if data exists [cite: 47, 85, 88]
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true; [cite: 91]
            }
        }
        return false; [cite: 93]
    }
}