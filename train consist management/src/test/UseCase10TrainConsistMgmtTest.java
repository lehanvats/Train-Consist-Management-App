package test;

import main.UseCase10TrainConsistMgmt;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase10TrainConsistMgmtTest {

    @Test
    void testReduce_TotalSeatCalculation() {
        // Verifies that the reduce operation correctly calculates the total seating capacity of all bogies.
        List<UseCase10TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("AC Chair", 56));

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(128, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        // Verifies that when multiple bogies exist, their capacities are correctly summed.
        List<UseCase10TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("AC Chair", 56));
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("First Class", 24));
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("Sleeper", 70));

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(222, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        // Verifies behavior when only one bogie exists in the list.
        List<UseCase10TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("Sleeper", 72));

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        // Verifies that aggregation on an empty bogie list returns the default identity value.
        List<UseCase10TrainConsistMgmt.Bogie> bogies = new ArrayList<>();

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        // Verifies that the map() operation correctly extracts capacity values from Bogie objects before reduction.
        List<UseCase10TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("First Class", 24));

        List<Integer> capacities = bogies.stream()
                .map(b -> b.capacity)
                .toList();

        assertEquals(1, capacities.size());
        assertEquals(24, capacities.get(0));
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        // Verifies that all bogies in the collection are included in the aggregation.
        List<UseCase10TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("Sleeper", 10));
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("AC Chair", 10));
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("First Class", 10));

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(30, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        // Verifies that the original bogie list remains unchanged after performing the aggregation operation.
        List<UseCase10TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("AC Chair", 56));

        int originalSize = bogies.size();

        bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(originalSize, bogies.size());
    }
}