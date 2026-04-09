import java.util.LinkedList;
import java.util.List;

/**
 * Use Case 4: Maintain Ordered Bogie Consist
 * Description: Models the physical chaining of train bogies using LinkedList
 * for ordered operations and positional insertions.
 */
public class UseCase4TrainConsistMgmt {

    public LinkedList<String> processOrderedConsist() {
        // Create a LinkedList to maintain insertion order [cite: 48, 65]
        LinkedList<String> trainConsist = new LinkedList<>();

        // Add initial bogies: Engine, Sleeper, AC, Cargo, Guard [cite: 66]
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist); // [cite: 77, 78]

        // Insert 'Pantry Car' at position 2 [cite: 67]
        trainConsist.add(2, "Pantry Car");
        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist); // [cite: 79, 80]

        // Remove the first and last bogie [cite: 68]
        trainConsist.removeFirst(); // [cite: 62]
        trainConsist.removeLast();  // [cite: 62]

        System.out.println("After Removing First and Last Bogie:");
        System.out.println(trainConsist); // [cite: 81, 82]

        return trainConsist;
    }

    public static void main(String[] args) {
        System.out.println("--- UC4 Maintain Ordered Bogie Consist ---"); // [cite: 43, 44, 76]
        UseCase4TrainConsistMgmt consistApp = new UseCase4TrainConsistMgmt();
        consistApp.processOrderedConsist();
        System.out.println("UC4 ordered consist operations completed..."); // [cite: 83]
    }
}