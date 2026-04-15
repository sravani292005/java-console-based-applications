import java.util.*;

class Account {
    int accNo;
    String name;
    double balance;
    ArrayList<String> history;

    Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
        this.history = new ArrayList<>();
        history.add("Account created with balance: " + balance);
    }

    void deposit(double amount) {
        balance += amount;
        history.add("Deposited: " + amount);
        System.out.println("Deposit successful!");
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance! Withdrawal failed.");
            return;
        }
        balance -= amount;
        history.add("Withdrawn: " + amount);
        System.out.println("Withdrawal successful!");
    }

    void display() {
        System.out.println("Account No: " + accNo);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }

    void showHistory() {
        System.out.println("Transaction History:");
        for (String h : history) {
            System.out.println("- " + h);
        }
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Bank System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Account");
            System.out.println("5. Transfer Money");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");

            int choice = getInt("Enter choice: ");

            switch (choice) {
                case 1: createAccount(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: viewAccount(); break;
                case 5: transfer(); break;
                case 6: showHistory(); break;
                case 7: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    static int getInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Enter number.");
            }
        }
    }

    static double getDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Enter amount.");
            }
        }
    }

    static Account findAccount(int accNo) {
        for (Account a : accounts) {
            if (a.accNo == accNo) return a;
        }
        return null;
    }

    static void createAccount() {
        int accNo = getInt("Enter Account Number: ");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        double balance = getDouble("Enter Initial Balance: ");

        accounts.add(new Account(accNo, name, balance));
        System.out.println("Account created successfully!");
    }

    static void deposit() {
        int accNo = getInt("Enter Account Number: ");
        Account acc = findAccount(accNo);

        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        double amt = getDouble("Enter amount to deposit: ");
        acc.deposit(amt);
    }

    static void withdraw() {
        int accNo = getInt("Enter Account Number: ");
        Account acc = findAccount(accNo);

        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        double amt = getDouble("Enter amount to withdraw: ");
        acc.withdraw(amt);
    }

    static void viewAccount() {
        int accNo = getInt("Enter Account Number: ");
        Account acc = findAccount(accNo);

        if (acc != null) {
            acc.display();
        } else {
            System.out.println("Account not found!");
        }
    }

    static void transfer() {
        int from = getInt("From Account: ");
        int to = getInt("To Account: ");

        Account acc1 = findAccount(from);
        Account acc2 = findAccount(to);

        if (acc1 == null || acc2 == null) {
            System.out.println("Invalid account!");
            return;
        }

        double amt = getDouble("Enter amount: ");

        if (amt > acc1.balance) {
            System.out.println("Insufficient balance!");
            return;
        }

        acc1.balance -= amt;
        acc2.balance += amt;

        acc1.history.add("Transferred " + amt + " to Acc " + to);
        acc2.history.add("Received " + amt + " from Acc " + from);

        System.out.println("Transfer successful!");
    }

    static void showHistory() {
        int accNo = getInt("Enter Account Number: ");
        Account acc = findAccount(accNo);

        if (acc != null) {
            acc.showHistory();
        } else {
            System.out.println("Account not found!");
        }
    }
}