import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATM {
    private Map<String, Account> accounts;
    private String currentUser;

    public ATM() {
        accounts = new HashMap<>();
        // Populate dummy accounts
        accounts.put("123456", new Account("123456", "1234", 1000));
        accounts.put("789012", new Account("789012", "5678", 2000));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");
        System.out.print("Enter your user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter your PIN: ");
        String pin = scanner.nextLine();

        if (authenticateUser(userId, pin)) {
            System.out.println("Login successful!");
            currentUser = userId;
            showMenu(scanner);
        } else {
            System.out.println("Invalid user ID or PIN. Exiting...");
        }
    }

    private boolean authenticateUser(String userId, String pin) {
        return accounts.containsKey(userId) && accounts.get(userId).getPin().equals(pin);
    }

    private void showMenu(Scanner scanner) {
        boolean quit = false;

        while (!quit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. View Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewTransactionHistory();
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    transfer(scanner);
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewTransactionHistory() {
        System.out.println("\nTransaction History:");
        accounts.get(currentUser).showTransactionHistory();
    }

    private void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        accounts.get(currentUser).withdraw(amount);
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        accounts.get(currentUser).deposit(amount);
    }

    private void transfer(Scanner scanner) {
        System.out.print("Enter recipient's user ID: ");
        String recipientId = scanner.nextLine();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        accounts.get(currentUser).transfer(recipientId, amount, accounts);
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}

class Account {
    private String userId;
    private String pin;
    private double balance;
    private StringBuilder transactionHistory;

    public Account(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new StringBuilder();
    }

    public String getPin() {
        return pin;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
            transactionHistory.append("Withdrawal of $").append(amount).append("\n");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
        transactionHistory.append("Deposit of $").append(amount).append("\n");
    }

    public void transfer(String recipientId, double amount, Map<String, Account> accounts) {
        if (accounts.containsKey(recipientId)) {
            if (amount > balance) {
                System.out.println("Insufficient funds.");
            } else {
                balance -= amount;
                accounts.get(recipientId).deposit(amount);
                System.out.println("Transfer successful. Current balance: " + balance);
                transactionHistory.append("Transfer of $").append(amount).append(" to user ID: ").append(recipientId).append("\n");
            }
        } else {
            System.out.println("Recipient user ID not found.");
        }
    }

    public void showTransactionHistory() {
        System.out.println(transactionHistory.toString());
    }
}
