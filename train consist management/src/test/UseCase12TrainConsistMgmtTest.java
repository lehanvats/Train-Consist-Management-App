import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UseCase12TrainConsistMgmtTest {

    @Test
    void testSafety_AllBogiesValid() {
        // Verifies that the train is marked safe when all cylindrical bogies carry Petroleum [cite: 121]
        List<UseCase12TrainConsistMgmt.GoodsBogie> bogies = Arrays.asList(
                new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Petroleum"),
                new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Petroleum")
        );
        assertTrue(UseCase12TrainConsistMgmt.isTrainFormationSafe(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        // Verifies that cylindrical bogies carrying cargo other than Petroleum fail validation [cite: 122, 123]
        List<UseCase12TrainConsistMgmt.GoodsBogie> bogies = Arrays.asList(
                new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(UseCase12TrainConsistMgmt.isTrainFormationSafe(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        // Verifies that non-cylindrical bogies can carry any cargo without failing the rule [cite: 124, 125]
        List<UseCase12TrainConsistMgmt.GoodsBogie> bogies = Arrays.asList(
                new UseCase12TrainConsistMgmt.GoodsBogie("Open", "Coal"),
                new UseCase12TrainConsistMgmt.GoodsBogie("Box", "Grain")
        );
        assertTrue(UseCase12TrainConsistMgmt.isTrainFormationSafe(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        // Verifies that if at least one cylindrical bogie violates the rule, the entire train becomes unsafe [cite: 127, 128]
        List<UseCase12TrainConsistMgmt.GoodsBogie> bogies = Arrays.asList(
                new UseCase12TrainConsistMgmt.GoodsBogie("Open", "Coal"),
                new UseCase12TrainConsistMgmt.GoodsBogie("Box", "Grain"),
                new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(UseCase12TrainConsistMgmt.isTrainFormationSafe(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        // Verifies behavior when no goods bogies exist [cite: 130, 131]
        List<UseCase12TrainConsistMgmt.GoodsBogie> bogies = Collections.emptyList();
        // Validation should return true, since no rule violations exist [cite: 118]
        assertTrue(UseCase12TrainConsistMgmt.isTrainFormationSafe(bogies));
    }
}