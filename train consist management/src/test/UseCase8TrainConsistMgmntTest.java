package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class UseCase8TrainConsistMgmntTest {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase8TrainConsistMgmnt.Bogie("Sleeper", 72),
                new UseCase8TrainConsistMgmnt.Bogie("First Class", 24)
        );

        List<UseCase8TrainConsistMgmnt.Bogie> filtered = UseCase8TrainConsistMgmnt.filterBogies(bogies, 70);

        assertEquals(1, filtered.size());
        assertEquals("Sleeper", filtered.get(0).name);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase8TrainConsistMgmnt.Bogie("Special", 70),
                new UseCase8TrainConsistMgmnt.Bogie("Sleeper", 72)
        );

        List<UseCase8TrainConsistMgmnt.Bogie> filtered = UseCase8TrainConsistMgmnt.filterBogies(bogies, 70);

        assertEquals(1, filtered.size());
        assertEquals("Sleeper", filtered.get(0).name); // 70 should be excluded
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase8TrainConsistMgmnt.Bogie("First Class", 24),
                new UseCase8TrainConsistMgmnt.Bogie("AC Chair", 56)
        );

        List<UseCase8TrainConsistMgmnt.Bogie> filtered = UseCase8TrainConsistMgmnt.filterBogies(bogies, 70);

        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase8TrainConsistMgmnt.Bogie("Sleeper", 72),
                new UseCase8TrainConsistMgmnt.Bogie("General", 90),
                new UseCase8TrainConsistMgmnt.Bogie("First Class", 24)
        );

        List<UseCase8TrainConsistMgmnt.Bogie> filtered = UseCase8TrainConsistMgmnt.filterBogies(bogies, 60);

        assertEquals(2, filtered.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase8TrainConsistMgmnt.Bogie("First Class", 24),
                new UseCase8TrainConsistMgmnt.Bogie("Pantry", 10)
        );

        List<UseCase8TrainConsistMgmnt.Bogie> filtered = UseCase8TrainConsistMgmnt.filterBogies(bogies, 50);

        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = List.of(
                new UseCase8TrainConsistMgmnt.Bogie("Sleeper", 72),
                new UseCase8TrainConsistMgmnt.Bogie("General", 90)
        );

        List<UseCase8TrainConsistMgmnt.Bogie> filtered = UseCase8TrainConsistMgmnt.filterBogies(bogies, 50);

        assertEquals(2, filtered.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<UseCase8TrainConsistMgmnt.Bogie> emptyList = new ArrayList<>();

        List<UseCase8TrainConsistMgmnt.Bogie> filtered = UseCase8TrainConsistMgmnt.filterBogies(emptyList, 60);

        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<UseCase8TrainConsistMgmnt.Bogie> originalList = new ArrayList<>();
        originalList.add(new UseCase8TrainConsistMgmnt.Bogie("Sleeper", 72));
        originalList.add(new UseCase8TrainConsistMgmnt.Bogie("First Class", 24));

        UseCase8TrainConsistMgmnt.filterBogies(originalList, 60);

        // Assert the original list still has 2 items and remains completely intact
        assertEquals(2, originalList.size());
        assertEquals("Sleeper", originalList.get(0).name);
        assertEquals("First Class", originalList.get(1).name);
    }
}