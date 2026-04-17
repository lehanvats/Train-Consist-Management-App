package test;

import main.UseCase17TrainConsistMgmt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Test class for UC17 sorting functionality. [cite: 98]
 */
class UseCase17TrainConsistMgmtTest {

    private final UseCase17TrainConsistMgmt app = new UseCase17TrainConsistMgmt();

    @Test
    void testSort_BasicAlphabeticalSorting() {
        // [cite: 83, 85]
        String[] input = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        assertArrayEquals(expected, app.sortBogieNames(input));
    }

    @Test
    void testSort_UnsortedInput() {
        // [cite: 86, 88, 89]
        String[] input = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};
        assertArrayEquals(expected, app.sortBogieNames(input));
    }

    @Test
    void testSort_AlreadySortedArray() {
        // [cite: 90, 92]
        String[] input = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};
        assertArrayEquals(expected, app.sortBogieNames(input));
    }

    @Test
    void testSort_DuplicateBogieNames() {
        // [cite: 93, 95]
        String[] input = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};
        assertArrayEquals(expected, app.sortBogieNames(input));
    }

    @Test
    void testSort_SingleElementArray() {
        // [cite: 96, 97]
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};
        assertArrayEquals(expected, app.sortBogieNames(input));
    }
}