import java.util.Scanner;

class BankAccount {
    private String accountHolderName;
    private long accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountHolderName, long accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;

            System.out.println();
            System.out.println("Amount deposited successfully!");
            System.out.printf("Deposited Amount: Rs. %.2f%n", amount);
            System.out.printf("Current Balance: Rs. %.2f%n", balance);
        } else {
            System.out.println();
            System.out.println("Invalid amount! Deposit must be greater than 0.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println();
            System.out.println("Invalid amount! Withdrawal must be greater than 0.");
        } else if (amount > balance) {
            System.out.println();
            System.out.println("Insufficient balance!");
            System.out.printf("Available Balance: Rs. %.2f%n", balance);
        } else {
            balance = balance - amount;

            System.out.println();
            System.out.println("Withdrawal successful!");
            System.out.printf("Withdrawn Amount: Rs. %.2f%n", amount);
            System.out.printf("Current Balance: Rs. %.2f%n", balance);
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println();
        System.out.printf("Current Balance: Rs. %.2f%n", balance);
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println();
        System.out.println("========== ACCOUNT DETAILS ==========");
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Account Number : " + accountNumber);
        System.out.printf("Balance        : Rs. %.2f%n", balance);
        System.out.println("=====================================");
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BankAccount account = null;
        boolean running = true;

        System.out.println("==============================================");
        System.out.println("       BANK ACCOUNT MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        while (running) {

            System.out.println();
            System.out.println("--------------- MENU ----------------");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");
            System.out.println("-------------------------------------");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println();
                System.out.println("Invalid input! Please enter a number from 1 to 6.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    if (account != null) {
                        System.out.println();
                        System.out.println("Account already exists!");
                        break;
                    }

                    scanner.nextLine();

                    System.out.print("Enter account holder name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter account number: ");

                    if (!scanner.hasNextLong()) {
                        System.out.println("Invalid account number!");
                        scanner.nextLine();
                        break;
                    }

                    long accountNumber = scanner.nextLong();

                    System.out.print("Enter initial deposit: Rs. ");

                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid deposit amount!");
                        scanner.nextLine();
                        break;
                    }

                    double initialDeposit = scanner.nextDouble();

                    if (initialDeposit < 0) {
                        System.out.println();
                        System.out.println("Invalid initial deposit!");
                    } else {
                        account = new BankAccount(
                                name,
                                accountNumber,
                                initialDeposit
                        );

                        System.out.println();
                        System.out.println("Account created successfully!");
                        System.out.println("Welcome, " + name + "!");
                    }

                    break;

                case 2:

                    if (account == null) {
                        System.out.println();
                        System.out.println("Please create an account first.");
                        break;
                    }

                    System.out.print("Enter deposit amount: Rs. ");

                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid amount!");
                        scanner.nextLine();
                        break;
                    }

                    double depositAmount = scanner.nextDouble();

                    account.deposit(depositAmount);

                    break;

                case 3:

                    if (account == null) {
                        System.out.println();
                        System.out.println("Please create an account first.");
                        break;
                    }

                    System.out.print("Enter withdrawal amount: Rs. ");

                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid amount!");
                        scanner.nextLine();
                        break;
                    }

                    double withdrawAmount = scanner.nextDouble();

                    account.withdraw(withdrawAmount);

                    break;

                case 4:

                    if (account == null) {
                        System.out.println();
                        System.out.println("Please create an account first.");
                        break;
                    }

                    account.checkBalance();

                    break;

                case 5:

                    if (account == null) {
                        System.out.println();
                        System.out.println("Please create an account first.");
                        break;
                    }

                    account.displayAccountDetails();

                    break;

                case 6:

                    System.out.println();
                    System.out.println(
                            "Thank you for using Bank Account Management System!"
                    );

                    running = false;

                    break;

                default:

                    System.out.println();
                    System.out.println(
                            "Invalid choice! Please select 1 to 6."
                    );
            }
        }

        scanner.close();
    }
}