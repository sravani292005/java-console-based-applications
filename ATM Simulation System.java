import java.util.*;

public class Main {
    static int balance = 10000;
    static int pin = 1234;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int attempts = 3;
        while (attempts-- > 0) {
            System.out.print("Enter PIN: ");
            int p = sc.nextInt();

            if (p == pin) {
                int ch;
                do {
                    System.out.println("1.Withdraw 2.Deposit 3.Balance 4.Exit");
                    ch = sc.nextInt();

                    if (ch == 1) {
                        int amt = sc.nextInt();
                        if (amt <= 5000 && amt <= balance) {
                            balance -= amt;
                        }
                    } else if (ch == 2) {
                        balance += sc.nextInt();
                    } else if (ch == 3) {
                        System.out.println(balance);
                    }
                } while (ch != 4);
                return;
            }
        }
        System.out.println("Card Blocked!");
    }
}