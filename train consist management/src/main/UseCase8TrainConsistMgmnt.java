import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Use Case 8: Filter Passenger Bogies Using Streams
 * This class filters passenger bogies based on seating capacity using Java Stream API.
 * * @author Developer
 * @version 8.0
 */
public class UseCase8TrainConsistMgmnt {

    // Reusing Bogie model from UC7
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    /**
     * Filters a list of bogies based on a minimum capacity threshold.
     */
    public static List<Bogie> filterBogies(List<Bogie> bogies, int capacityThreshold) {
        return bogies.stream()
                .filter(b -> b.capacity > capacityThreshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println(" UC8 - Filter Passenger Bogies Using Streams ");
        System.out.println("=================================================");

        // Create list of passenger bogies (same style as UC7)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("\nAll Bogies:");
        bogies.forEach(System.out::println);

        // Filter bogies with capacity > 60
        List<Bogie> filteredBogies = filterBogies(bogies, 60);

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);

        System.out.println("\nUC8 filtering completed...");
    }
}