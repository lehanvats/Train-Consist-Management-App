package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UseCase9TrainConsistMgmtTest {

    @Test
    void testGrouping_BogiesGroupedByType() {
        // Verifies that bogies are correctly grouped based on their type [cite: 135, 136]
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72));

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped.containsKey("Sleeper"), "Bogies with the same name should appear under the same Map key."); [cite: 137]
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        // Verifies that multiple bogies sharing the same name are grouped together [cite: 138, 139]
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 70));

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(2, grouped.get("Sleeper").size(), "Two or more bogies with the same type are stored in the same group."); [cite: 140]
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        // Verifies that bogies with different types are separated into different groups [cite: 141, 142]
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("AC Chair", 56));

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped.containsKey("Sleeper") && grouped.containsKey("AC Chair"), "Each bogie type appears as a distinct key."); [cite: 143]
    }

    @Test
    void testGrouping_EmptyBogieList() {
        // Verifies that grouping an empty bogie list does not produce errors [cite: 144, 145]
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>();

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped.isEmpty(), "The resulting Map should be empty."); [cite: 145]
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        // Verifies behavior when only one bogie type exists [cite: 146, 147]
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("First Class", 24));
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("First Class", 26));

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(1, grouped.keySet().size(), "The Map contains only one key."); [cite: 148]
        assertTrue(grouped.containsKey("First Class"));
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        // Verifies that the grouped Map contains the expected bogie type keys [cite: 149, 150]
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("AC Chair", 56));
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("First Class", 24));

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped.keySet().containsAll(List.of("Sleeper", "AC Chair", "First Class")), "Keys such as Sleeper, AC Chair, and First Class exist."); [cite: 151]
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        // Verifies that the number of bogies within each group matches the expected count [cite: 152, 153]
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 70));
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("AC Chair", 60));

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(2, grouped.get("Sleeper").size(), "The Sleeper group contains two bogies if two sleeper bogies exist."); [cite: 154]
        assertEquals(1, grouped.get("AC Chair").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        // Verifies that the original bogie list remains unchanged after the grouping operation [cite: 155, 156]
        List<UseCase9TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmt.Bogie("AC Chair", 56));

        List<UseCase9TrainConsistMgmt.Bogie> originalCopy = new ArrayList<>(bogies);

        bogies.stream().collect(Collectors.groupingBy(b -> b.name));

        assertEquals(originalCopy.size(), bogies.size(), "The original list size and contents remain the same."); [cite: 157]
        for (int i = 0; i < bogies.size(); i++) {
            assertEquals(originalCopy.get(i).name, bogies.get(i).name);
            assertEquals(originalCopy.get(i).capacity, bogies.get(i).capacity);
        }
    }
}