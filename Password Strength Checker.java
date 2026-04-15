import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        int score = 0;

        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[@#$%^&+=!].*");

        if (password.length() >= 8) score++;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        System.out.println("\n--- Result ---");

        if (score <= 2) {
            System.out.println("Strength: Weak");
        } else if (score <= 4) {
            System.out.println("Strength: Medium");
        } else {
            System.out.println("Strength: Strong");
        }

        System.out.println("\nSuggestions:");

        if (password.length() < 8)
            System.out.println("- Use at least 8 characters");
        if (!hasUpper)
            System.out.println("- Add uppercase letters");
        if (!hasLower)
            System.out.println("- Add lowercase letters");
        if (!hasDigit)
            System.out.println("- Add digits");
        if (!hasSpecial)
            System.out.println("- Add special characters");

        sc.close();
    }
}