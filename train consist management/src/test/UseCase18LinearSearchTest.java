import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase18LinearSearchTest {

    private final UseCase18LinearSearch searchApp = new UseCase18LinearSearch();
    private final String[] consist = {"BG101", "BG205", "BG309", "BG412", "BG550"};

    @Test
    void testSearch_BogieFound() {
        // Verifies successful identification of an existing bogie ID [cite: 105, 106]
        assertTrue(searchApp.findBogie(consist, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        // Verifies negative result for non-existent ID [cite: 108, 109]
        assertFalse(searchApp.findBogie(consist, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        // Verifies match at the first position [cite: 111, 112]
        assertTrue(searchApp.findBogie(consist, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        // Verifies match at the last position [cite: 114, 115]
        assertTrue(searchApp.findBogie(consist, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        // Verifies search works with only one element present [cite: 117, 118]
        String[] singleConsist = {"BG101"};
        assertTrue(searchApp.findBogie(singleConsist, "BG101"));
    }
}