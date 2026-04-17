/**
 * Use Case 14: Handle Invalid Bogie Capacity (Custom Exception)
 * Description: Prevents creation of passenger bogies with invalid seating capacity using a custom exception.
 */
public class UseCase14TrainConsistMgmt {

    // Custom Exception extending Exception to represent checked exceptions [cite: 66, 67]
    public static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message); [cite: 54]
        }
    }

    // Passenger Bogie model with validation
    public static class PassengerBogie {
        private String type;
        private int capacity;

        // Constructor declares throws to pass exception to caller [cite: 69, 76]
        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            // Validates capacity inside constructor [cite: 33, 74]
            if (capacity <= 0) { [cite: 59, 75]
                // Explicitly raise exception when business rules are violated [cite: 68]
                throw new InvalidCapacityException("Capacity must be greater than zero"); [cite: 87, 99]
            }
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() { return type; }
        public int getCapacity() { return capacity; }
    }

    public static void main(String[] args) {
        System.out.println("UC14 Handle Invalid Bogie Capacity"); [cite: 85]

        try {
            PassengerBogie validBogie = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + validBogie.getType() + " -> " + validBogie.getCapacity()); [cite: 86]

            // This will trigger the custom exception
            PassengerBogie invalidBogie = new PassengerBogie("AC Chair", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage()); [cite: 87]
        }

        System.out.println("UC14 exception handling completed...."); [cite: 88]
    }
}