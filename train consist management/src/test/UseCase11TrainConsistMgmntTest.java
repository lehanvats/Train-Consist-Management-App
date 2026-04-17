package test;

import main.UseCase11TrainConsistMgmnt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase11TrainConsistMgmntTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(UseCase11TrainConsistMgmnt.validateTrainId("TRN-1234"));
        assertTrue(UseCase11TrainConsistMgmnt.validateTrainId("TRN-6524"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("TRAIN12"));
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("TRN12A"));
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(UseCase11TrainConsistMgmnt.validateCargoCode("PET-AB"));
        assertTrue(UseCase11TrainConsistMgmnt.validateCargoCode("PET-FH"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("PET-ab"));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("PET123"));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("TRN-123"));
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("PET-Ab"));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("PET-aB"));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("pet-ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId(""));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode(""));
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId(null));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode(null));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("TRN-1234-EXTRA"));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("EXTRA-PET-AB"));
    }
}