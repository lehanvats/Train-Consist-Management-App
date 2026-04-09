package main;

import java.util.ArrayList;
import java.util.List;

/**
 * MAIN CLASS - UseCase1TrainConsistMgmt
 * * Use Case 1: Initialize Train and Display Consist Summary
 * * Description:
 * This class represents the entry point of the Train Consist Management Application.
 * At this stage, the application:
 * - Creates an empty train consist
 * - Uses a dynamic List to store bogies
 * - Displays initial bogie count
 * - Prints the current state of the train
 */
public class UseCase1TrainConsistMgmt {

    public static void main(String[] args) {
        // Display welcome banner
        System.out.println("=== Train Consist Management App ===");

        // Create a dynamic list to store train bogies
        List<String> trainConsist = new ArrayList<>();

        // Display initial consist information
        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count: " + trainConsist.size());
        System.out.println("Current Train Consist: " + trainConsist);
        System.out.println("System ready for operations...");
    }
}