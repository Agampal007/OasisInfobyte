import java.util.Scanner;

public class OnlineExaminationSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static String username;
    private static String password;
    private static boolean loggedIn = false;

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to Online Examination System");

            if (!loggedIn) {
                login();
            } else {
                System.out.println("1. Update Profile and Password");
                System.out.println("2. Start Exam");
                System.out.println("3. Logout");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        updateProfile();
                        break;
                    case 2:
                        startExam();
                        break;
                    case 3:
                        logout();
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        }
    }

    private static void login() {
        System.out.println("Login:");

        System.out.print("Enter username: ");
        username = scanner.next();

        System.out.print("Enter password: ");
        password = scanner.next();

        // Simulate authentication
        if (authenticate(username, password)) {
            loggedIn = true;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password! Please try again.");
        }
    }

    private static boolean authenticate(String username, String password) {
        // Dummy authentication logic, replace with your own authentication mechanism
        return username.equals("admin") && password.equals("admin123");
    }

    private static void updateProfile() {
        System.out.println("Update Profile and Password:");
        // Add logic to update profile and password
    }

    private static void startExam() {
        System.out.println("Starting Exam...");
        // Add logic for MCQs, timer, and auto submit
    }

    private static void logout() {
        loggedIn = false;
        System.out.println("Logged out successfully.");
    }
}
