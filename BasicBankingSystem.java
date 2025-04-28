import java.util.Scanner;

class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    public BankAccount(String name, String accNumber) {
        this.accountHolderName = name;
        this.accountNumber = accNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposited: $" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
        } else if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount.");
        } else {
            balance -= amount;
            System.out.println("✅ Withdrawn: $" + amount);
        }
    }

    public void displayBalance() {
        System.out.println("💰 Current Balance: $" + balance);
    }

    public void displayAccountInfo() {
        System.out.println("\n📄 Account Information:");
        System.out.println("Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        displayBalance();
    }
}

public class BasicBankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🏦 Welcome to the Basic Banking System");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter account number: ");
        String accNumber = sc.nextLine();

        BankAccount account = new BankAccount(name, accNumber);

        int choice;
        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Account Info");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.displayAccountInfo();
                    break;
                case 2:
                    account.displayBalance();
                    break;
                case 3:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 5:
                    System.out.println("👋 Thank you for using the Banking System!");
                    break;
                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}