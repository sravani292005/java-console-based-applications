import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;   // FIXED: initialized

        do {
            System.out.println("\n--- Number System Converter ---");
            System.out.println("1. Decimal to Binary/Octal/Hex");
            System.out.println("2. Binary to Decimal");
            System.out.println("3. Octal to Decimal");
            System.out.println("4. Hex to Decimal");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");

            // Input validation for menu
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.next(); // clear invalid input
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Decimal: ");
                    if (sc.hasNextInt()) {
                        int dec = sc.nextInt();
                        System.out.println("Binary: " + Integer.toBinaryString(dec));
                        System.out.println("Octal: " + Integer.toOctalString(dec));
                        System.out.println("Hex: " + Integer.toHexString(dec));
                    } else {
                        System.out.println("Invalid Decimal!");
                        sc.next();
                    }
                    break;

                case 2:
                    System.out.print("Enter Binary: ");
                    String bin = sc.next();
                    if (bin.matches("[01]+")) {
                        System.out.println("Decimal: " + Integer.parseInt(bin, 2));
                    } else {
                        System.out.println("Invalid Binary!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Octal: ");
                    String oct = sc.next();
                    if (oct.matches("[0-7]+")) {
                        System.out.println("Decimal: " + Integer.parseInt(oct, 8));
                    } else {
                        System.out.println("Invalid Octal!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Hex: ");
                    String hex = sc.next();
                    if (hex.matches("[0-9A-Fa-f]+")) {
                        System.out.println("Decimal: " + Integer.parseInt(hex, 16));
                    } else {
                        System.out.println("Invalid Hex!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}