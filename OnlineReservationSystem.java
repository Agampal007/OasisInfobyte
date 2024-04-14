import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineReservationSystem {
    private static final Map<String, String> userCredentials = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeUsers();

        // Login Form
        String username = promptUsername();
        String password = promptPassword();
        if (isValidUser(username, password)) {
            System.out.println("Login successful!");
            // Reservation System
            makeReservation();
            // Cancellation Form
            cancelReservation();
        } else {
            System.out.println("Invalid username or password. Exiting...");
        }
    }

    private static void initializeUsers() {
        // Initialize user credentials (this could be retrieved from a database)
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    private static String promptUsername() {
        System.out.print("Enter username: ");
        return scanner.nextLine();
    }

    private static String promptPassword() {
        System.out.print("Enter password: ");
        return scanner.nextLine();
    }

    private static boolean isValidUser(String username, String password) {
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }

    private static void makeReservation() {
        System.out.println("\nReservation System");
        // Input fields
        System.out.print("Enter your basic details: ");
        String basicDetails = scanner.nextLine();
        System.out.print("Enter train number: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        // Similar for other fields like train name, class type, date of journey, from, to, etc.

        // Insert button
        System.out.println("Reservation successful!");
    }

    private static void cancelReservation() {
        System.out.println("\nCancellation Form");
        // Input field
        System.out.print("Enter PNR number to cancel reservation: ");
        String pnrNumber = scanner.nextLine();

        // Display information related to PNR number
        System.out.println("Displaying reservation information for PNR: " + pnrNumber);
        // Logic to fetch reservation details based on PNR from the database would go here

        // Confirmation
        System.out.print("Confirm cancellation (Press 'OK' to cancel): ");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("OK")) {
            System.out.println("Cancellation successful!");
        } else {
            System.out.println("Cancellation aborted.");
        }
    }
}
