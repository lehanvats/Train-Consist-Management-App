import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

/**
 * Unit tests for UC19 Binary Search functionality.
 * [cite: 126]
 */
class UseCase19TrainConsistigantTest {

    @Test
    void testBinarySearch_BogieFound() {
        // Verifies that the system successfully identifies an existing bogie ID [cite: 107]
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UseCase19TrainConsistigant.performBinarySearch(bogieIds, "BG309")); // [cite: 108]
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        // Verifies negative result when the bogie ID does not exist [cite: 110]
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(UseCase19TrainConsistigant.performBinarySearch(bogieIds, "BG999")); // [cite: 111]
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        // Verifies search correctly detects a match at the first position [cite: 113]
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UseCase19TrainConsistigant.performBinarySearch(bogieIds, "BG101")); // [cite: 114]
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        // Verifies search correctly detects a match at the last position [cite: 116]
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UseCase19TrainConsistigant.performBinarySearch(bogieIds, "BG550")); // [cite: 117]
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        // Verifies search works correctly with only one bogie ID [cite: 119]
        String[] bogieIds = {"BG101"};
        assertTrue(UseCase19TrainConsistigant.performBinarySearch(bogieIds, "BG101")); // [cite: 120]
    }

    @Test
    void testBinarySearch_EmptyArray() {
        // Verifies safe handling of an empty bogie list [cite: 122]
        String[] bogieIds = {};
        assertFalse(UseCase19TrainConsistigant.performBinarySearch(bogieIds, "BG101")); // [cite: 122]
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        // Verifies unsorted input is handled by sorting before search [cite: 124]
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        Arrays.sort(bogieIds); // System must sort data before applying Binary Search [cite: 104]
        assertTrue(UseCase19TrainConsistigant.performBinarySearch(bogieIds, "BG205")); // [cite: 125]
    }
}