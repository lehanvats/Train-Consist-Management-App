package test;

import main.UseCase15TrainConsistMgmt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase15TrainConsistMgmtTest {

    @Test
    void testCargo_SafeAssignment() {
        // Verifies that safe cargo assignments are processed successfully.
        UseCase15TrainConsistMgmt.GoodsBogie bogie = new UseCase15TrainConsistMgmt.GoodsBogie("Cylindrical");

        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
        assertEquals("Petroleum", bogie.cargo, "Cargo should be successfully assigned to a compatible bogie.");
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        // Verifies that assigning petroleum to a rectangular bogie triggers safety validation.
        UseCase15TrainConsistMgmt.GoodsBogie bogie = new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");

        // Since the assignCargo method catches its own exception, the method execution itself should not throw outward.
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"), "The exception should be caught internally without crashing.");
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        // Verifies that cargo is not assigned when an unsafe combination occurs.
        UseCase15TrainConsistMgmt.GoodsBogie bogie = new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo, "Cargo must remain null (unassigned) after a failed safety validation.");
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        // Verifies that the application continues execution after exception handling.
        UseCase15TrainConsistMgmt.GoodsBogie bogie1 = new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");
        UseCase15TrainConsistMgmt.GoodsBogie bogie2 = new UseCase15TrainConsistMgmt.GoodsBogie("Cylindrical");

        // Execute sequentially to simulate program continuation
        assertDoesNotThrow(() -> {
            bogie1.assignCargo("Petroleum"); // This will fail internally but be caught
            bogie2.assignCargo("Petroleum"); // This should execute successfully right after
        });

        assertNull(bogie1.cargo, "First bogie should reject cargo.");
        assertEquals("Petroleum", bogie2.cargo, "Program should continue and successfully assign cargo to the second bogie.");
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        // Verifies that the finally block executes regardless of assignment success or failure.
        UseCase15TrainConsistMgmt.GoodsBogie bogie = new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertTrue(bogie.validationCompleted, "The finally block should have executed and set the validation flag to true.");
    }
}