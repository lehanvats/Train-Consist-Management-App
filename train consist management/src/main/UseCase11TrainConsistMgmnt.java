package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MAIN CLASS
 * UseCase11TrainConsistMgmnt
 * Use Case 11: Validate Train ID and Cargo Code
 *
 * Description:
 * This class validates input formats using Regular Expressions.
 */
public class UseCase11TrainConsistMgmnt {

    // Define Regex Patterns
    private static final String TRAIN_ID_REGEX = "^TRN-\\d{4}$";
    private static final String CARGO_CODE_REGEX = "^PET-[A-Z]{2}$";

    // Compile patterns
    private static final Pattern TRAIN_ID_PATTERN = Pattern.compile(TRAIN_ID_REGEX);
    private static final Pattern CARGO_CODE_PATTERN = Pattern.compile(CARGO_CODE_REGEX);

    /**
     * Validates if the Train ID matches the required TRN-1234 format.
     */
    public static boolean validateTrainId(String trainId) {
        if (trainId == null || trainId.trim().isEmpty()) {
            return false;
        }
        Matcher matcher = TRAIN_ID_PATTERN.matcher(trainId);
        return matcher.matches();
    }

    /**
     * Validates if the Cargo Code matches the required PET-AB format.
     */
    public static boolean validateCargoCode(String cargoCode) {
        if (cargoCode == null || cargoCode.trim().isEmpty()) {
            return false;
        }
        Matcher matcher = CARGO_CODE_PATTERN.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("==========================================");
        System.out.println();

        // Accept input
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // Display validation result
        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + validateTrainId(trainId));
        System.out.println("Cargo Code Valid: " + validateCargoCode(cargoCode));
        System.out.println("\nUC11 validation completed...");

        scanner.close();
    }
}