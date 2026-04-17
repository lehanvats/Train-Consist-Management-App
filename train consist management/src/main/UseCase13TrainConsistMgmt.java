import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Use Case 13: Performance Comparison (Loops vs Streams)
 * * Description:
 * This class compares execution time of loop-based filtering
 * versus stream-based filtering using System.nanoTime()
 * * @author Developer
 * @version 13.0
 */
public class UseCase13TrainConsistMgmt {

    // Bogie model
    public static class Bogie {
        String type;
        int capacity;

        public Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("--------------------------------------------------");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("--------------------------------------------------");

        // Create large test dataset
        List<Bogie> bogies = createLargeDataset(1000000);

        // 1. Loop-Based Processing
        long startLoopTime = System.nanoTime();
        List<Bogie> loopFiltered = filterUsingLoop(bogies);
        long endLoopTime = System.nanoTime();
        long loopDuration = endLoopTime - startLoopTime;

        // 2. Stream-Based Processing
        long startStreamTime = System.nanoTime();
        List<Bogie> streamFiltered = filterUsingStream(bogies);
        long endStreamTime = System.nanoTime();
        long streamDuration = endStreamTime - startStreamTime;

        // Display performance results
        System.out.println("Loop Execution Time (ns): " + loopDuration);
        System.out.println("Stream Execution Time (ns): " + streamDuration);
        System.out.println("UC13 performance benchmarking completed...");
    }

    // Helper method to create a large dataset of bogies
    public static List<Bogie> createLargeDataset(int size) {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            // Alternating capacities to simulate varied dataset
            int capacity = (i % 2 == 0) ? 50 : 70;
            bogies.add(new Bogie("Sleeper", capacity));
        }
        return bogies;
    }

    // Loop-Based Filtering Logic: Filter bogies with capacity > 60
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> filteredList = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getCapacity() > 60) {
                filteredList.add(bogie);
            }
        }
        return filteredList;
    }

    // Stream-Based Filtering Logic: Filter bogies with capacity > 60
    public static List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(bogie -> bogie.getCapacity() > 60)
                .collect(Collectors.toList());
    }
}