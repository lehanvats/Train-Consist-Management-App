/**
 * Use Case 16: Sort Passenger Bogies by Capacity
 * This class demonstrates manual sorting of passenger bogie capacities
 * using the Bubble Sort algorithm instead of built-in sorting utilities[cite: 21, 23].
 */
public class UseCase16TrainConsist {

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println(" UC16 - Manual Sorting using Bubble Sort ");
        System.out.println("=================================================");

        // Create array of passenger bogie capacities [cite: 38, 39, 67]
        int[] capacities = {72, 56, 24, 70, 60};

        // Display original order [cite: 40, 41]
        System.out.println("Original Capacities:");
        printArray(capacities);

        // Perform Bubble Sort [cite: 44]
        bubbleSort(capacities);

        // Display sorted result [cite: 47, 48, 71]
        System.out.println("\nSorted Capacities (Ascending):");
        printArray(capacities);

        System.out.println("\nUC16 sorting completed..."); [cite: 85]
    }

    /**
     * Sorts an integer array using the Bubble Sort algorithm[cite: 16, 60].
     * Time Complexity: O(n^2)[cite: 65].
     * @param arr The array to be sorted.
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // Outer loop controls number of passes [cite: 45, 62]
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for adjacent comparisons [cite: 53, 68]
            for (int j = 0; j < n - i - 1; j++) {
                // If the left element is greater than the right, swap them [cite: 54, 55, 69]
                if (arr[j] > arr[j + 1]) {
                    // Swapping Logic [cite: 63]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}