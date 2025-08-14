import java.util.Scanner;

public class ATMSimulator {

    // Hardcoded PIN and initial balance
    private static final int USER_PIN = 1234;
    private static double balance = 5000.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: PIN Authentication
        System.out.print("Enter your 4-digit PIN: ");
        int inputPin = scanner.nextInt();

        if (inputPin != USER_PIN) {
            System.out.println("Incorrect PIN. Access Denied.");
            return;  // Exit the program
        }

        System.out.println("Login successful!");

        // Step 2: Menu-driven loop
        int choice;
        do {
            System.out.println("\n=== ATM MENU ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }

    // Check balance
    private static void checkBalance() {
        System.out.println("Your current balance is: ₹" + balance);
    }

    // Deposit money
    private static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    // Withdraw money
    private static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid amount. Withdrawal failed.");
        }
    }
}
