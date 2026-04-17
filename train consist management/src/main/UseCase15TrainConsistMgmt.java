package main;

/**
 * Use Case 15: Safe Cargo Assignment Using try-catch-finally
 * * This class safely assigns cargo to goods bogies
 * while handling unsafe combinations using structured
 * exception handling blocks.
 */
public class UseCase15TrainConsistMgmt {

    // CUSTOM RUNTIME EXCEPTION
    public static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie model
    public static class GoodsBogie {
        public String shape;
        public String cargo;
        public boolean validationCompleted = false; // Flag to easily test finally block execution

        public GoodsBogie(String shape) {
            this.shape = shape;
        }

        // Assign cargo with safety validation
        public void assignCargo(String cargo) {
            try {
                // Rule: Rectangular bogie cannot carry petroleum
                if ("Rectangular".equalsIgnoreCase(this.shape) && "Petroleum".equalsIgnoreCase(cargo)) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }

                // If safe, assign the cargo
                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + this.cargo);

            } catch (CargoSafetyException e) {
                // Catch the exception and print the error message without crashing
                System.out.println("Error: " + e.getMessage());
            } finally {
                // Finally block executes completion logging whether successful or not
                this.validationCompleted = true;
                System.out.println("Cargo validation completed for " + this.shape + " bogie");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("UC15 - Safe Cargo Assignment");
        System.out.println("=========================================");
        System.out.println();

        // 1. Safe Assignment
        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        cylindrical.assignCargo("Petroleum");

        System.out.println();

        // 2. Unsafe Assignment Handled
        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        rectangular.assignCargo("Petroleum");

        System.out.println();
        System.out.println("UC15 runtime handling completed...");
    }
}