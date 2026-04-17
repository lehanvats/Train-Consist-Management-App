import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class UseCase13TrainConsistMgmtTest {

    private List<UseCase13TrainConsistMgmt.Bogie> smallDataset;

    @BeforeEach
    void setUp() {
        smallDataset = Arrays.asList(
                new UseCase13TrainConsistMgmt.Bogie("Sleeper", 50),
                new UseCase13TrainConsistMgmt.Bogie("AC Chair", 75),
                new UseCase13TrainConsistMgmt.Bogie("First Class", 60),
                new UseCase13TrainConsistMgmt.Bogie("Sleeper", 80)
        );
    }

    @Test
    void testLoopFilteringLogic() {
        List<UseCase13TrainConsistMgmt.Bogie> result = UseCase13TrainConsistMgmt.filterUsingLoop(smallDataset);
        assertEquals(2, result.size(), "Loop filtering should exclude bogies with capacity <= 60");
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<UseCase13TrainConsistMgmt.Bogie> result = UseCase13TrainConsistMgmt.filterUsingStream(smallDataset);
        assertEquals(2, result.size(), "Stream filtering should exclude bogies with capacity <= 60");
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<UseCase13TrainConsistMgmt.Bogie> loopResult = UseCase13TrainConsistMgmt.filterUsingLoop(smallDataset);
        List<UseCase13TrainConsistMgmt.Bogie> streamResult = UseCase13TrainConsistMgmt.filterUsingStream(smallDataset);

        assertEquals(loopResult.size(), streamResult.size(), "Result sizes must be equal");
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<UseCase13TrainConsistMgmt.Bogie> largeDataset = UseCase13TrainConsistMgmt.createLargeDataset(1000);

        long startLoopTime = System.nanoTime();
        UseCase13TrainConsistMgmt.filterUsingLoop(largeDataset);
        long endLoopTime = System.nanoTime();

        long duration = endLoopTime - startLoopTime;
        assertTrue(duration > 0, "Elapsed execution time should be greater than zero");
    }

    @Test
    void testLargeDatasetProcessing() {
        int datasetSize = 100000;
        List<UseCase13TrainConsistMgmt.Bogie> largeDataset = UseCase13TrainConsistMgmt.createLargeDataset(datasetSize);

        List<UseCase13TrainConsistMgmt.Bogie> result = UseCase13TrainConsistMgmt.filterUsingStream(largeDataset);

        assertNotNull(result, "Filtering should complete successfully");
        assertEquals(50000, result.size(), "Filtering a 100,000 alternating dataset should return 50,000 records");
    }
}