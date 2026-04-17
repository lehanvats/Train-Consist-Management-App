import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Test class for UC16 Bubble Sort implementation[cite: 110].
 */
public class UseCase16TrainConsistTest {

    @Test
    void testSort_BasicSorting() {
        // Verifies correct sorting of a typical unsorted array [cite: 98, 99]
        int[] capacities = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};
        UseCase16TrainConsist.bubbleSort(capacities);
        assertArrayEquals(expected, capacities); [cite: 100]
    }

    @Test
    void testSort_AlreadySortedArray() {
        // Verifies that an already sorted array remains unchanged [cite: 101, 102]
        int[] capacities = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};
        UseCase16TrainConsist.bubbleSort(capacities);
        assertArrayEquals(expected, capacities); [cite: 103]
    }

    @Test
    void testSort_DuplicateValues() {
        // Verifies that duplicate capacities are handled correctly [cite: 104]
        int[] capacities = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};
        UseCase16TrainConsist.bubbleSort(capacities);
        assertArrayEquals(expected, capacities); [cite: 105]
    }

    @Test
    void testSort_SingleElementArray() {
        // Verifies that sorting a single element array does not modify it [cite: 106, 107]
        int[] capacities = {50};
        int[] expected = {50};
        UseCase16TrainConsist.bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }

    @Test
    void testSort_AllEqualValues() {
        // Verifies that arrays containing identical values remain unchanged [cite: 108, 109]
        int[] capacities = {40, 40, 40};
        int[] expected = {40, 40, 40};
        UseCase16TrainConsist.bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }
}