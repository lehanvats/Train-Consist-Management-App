import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 Test Suite for UC20 Exception Handling
 */
class UseCase20TrainConsistMgmtTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        // Verifies system throws exception when searching an empty array [cite: 95, 96]
        String[] emptyTrain = {};
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            UseCase20TrainConsistMgmt.searchBogie(emptyTrain, "BG101");
        });

        // Verifies the specific error message [cite: 97]
        assertEquals("No bogies available in train. Cannot perform search.", exception.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        // Verifies system allows search execution when data is present [cite: 98, 99]
        String[] train = {"BG101", "BG205"};
        assertDoesNotThrow(() -> UseCase20TrainConsistMgmt.searchBogie(train, "BG101")); [cite: 100]
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        // Verifies bogie is correctly found after passing validation [cite: 101, 102]
        String[] train = {"BG101", "BG205", "BG309"};
        assertTrue(UseCase20TrainConsistMgmt.searchBogie(train, "BG205")); [cite: 103]
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        // Verifies system returns false when bogie is not found [cite: 104, 105]
        String[] train = {"BG101", "BG205", "BG309"};
        assertFalse(UseCase20TrainConsistMgmt.searchBogie(train, "BG999")); [cite: 106]
    }

    @Test
    void testSearch_SingleElementValidCase() {
        // Verifies correct behavior when only one bogie exists [cite: 107, 108]
        String[] train = {"BG101"};
        assertTrue(UseCase20TrainConsistMgmt.searchBogie(train, "BG101"));
    }
}