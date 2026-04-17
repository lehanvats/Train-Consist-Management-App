import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase14TrainConsistMgmtTest {

    @Test
    void testException_ValidCapacityCreation() throws UseCase14TrainConsistMgmt.InvalidCapacityException { [cite: 120]
        // Verifies that a passenger bogie with valid capacity is created successfully [cite: 104]
        UseCase14TrainConsistMgmt.PassengerBogie bogie = new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", 72);
        assertNotNull(bogie); [cite: 105]
    }

    @Test
    void testException_NegativeCapacityThrowsException() { [cite: 122]
        // Verifies that a negative capacity value triggers the custom exception [cite: 106]
        assertThrows(UseCase14TrainConsistMgmt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmt.PassengerBogie("AC Chair", -10); [cite: 107]
        });
    }

    @Test
    void testException_ZeroCapacityThrowsException() { [cite: 124]
        // Verifies that zero capacity is treated as invalid input [cite: 109]
        assertThrows(UseCase14TrainConsistMgmt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmt.PassengerBogie("First Class", 0); [cite: 110]
        });
    }

    @Test
    void testException_ExceptionMessageValidation() { [cite: 126]
        // Verifies that the correct exception message is returned when invalid capacity is detected [cite: 112]
        UseCase14TrainConsistMgmt.InvalidCapacityException exception = assertThrows(
                UseCase14TrainConsistMgmt.InvalidCapacityException.class,
                () -> new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", 0)
        );
        assertEquals("Capacity must be greater than zero", exception.getMessage()); [cite: 113]
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws UseCase14TrainConsistMgmt.InvalidCapacityException { [cite: 128]
        // Verifies that valid bogie objects store correct type and capacity values after creation [cite: 115]
        UseCase14TrainConsistMgmt.PassengerBogie bogie = new UseCase14TrainConsistMgmt.PassengerBogie("First Class", 24);
        assertEquals("First Class", bogie.getType()); [cite: 115]
        assertEquals(24, bogie.getCapacity()); [cite: 115]
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws UseCase14TrainConsistMgmt.InvalidCapacityException { [cite: 130]
        // Verifies that multiple valid bogies can be created without triggering exceptions [cite: 117]
        UseCase14TrainConsistMgmt.PassengerBogie b1 = new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", 72);
        UseCase14TrainConsistMgmt.PassengerBogie b2 = new UseCase14TrainConsistMgmt.PassengerBogie("AC Chair", 60);

        assertNotNull(b1); [cite: 117]
        assertNotNull(b2); [cite: 117]
    }
}