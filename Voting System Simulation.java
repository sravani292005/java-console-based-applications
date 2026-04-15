import java.util.*;

class Voter {
    String id;
    boolean hasVoted;

    Voter(String id) {
        this.id = id;
        this.hasVoted = false;
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);

    // Store voters
    static HashMap<String, Voter> voters = new HashMap<>();

    // Candidates
    static int votesA = 0;
    static int votesB = 0;

    public static void main(String[] args) {
        int choice = 0;

        do {
            System.out.println("\n--- Voting System ---");
            System.out.println("1. Register Voter");
            System.out.println("2. Cast Vote");
            System.out.println("3. Show Results");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input!");
                sc.next();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    registerVoter();
                    break;

                case 2:
                    castVote();
                    break;

                case 3:
                    showResults();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }

    // 🔹 Register Voter
    static void registerVoter() {
        System.out.print("Enter Voter ID: ");
        String id = sc.nextLine();

        if (voters.containsKey(id)) {
            System.out.println("Voter already registered!");
        } else {
            voters.put(id, new Voter(id));
            System.out.println("Voter registered successfully!");
        }
    }

    // 🔹 Cast Vote
    static void castVote() {
        System.out.print("Enter Voter ID: ");
        String id = sc.nextLine();

        if (!voters.containsKey(id)) {
            System.out.println("Voter not registered!");
            return;
        }

        Voter v = voters.get(id);

        if (v.hasVoted) {
            System.out.println("You have already voted!");
            return;
        }

        System.out.println("Vote for: 1. Candidate A  2. Candidate B");
        int vote = sc.nextInt();
        sc.nextLine();

        if (vote == 1) {
            votesA++;
        } else if (vote == 2) {
            votesB++;
        } else {
            System.out.println("Invalid choice!");
            return;
        }

        v.hasVoted = true;
        System.out.println("Vote cast successfully!");
    }

    // 🔹 Show Results
    static void showResults() {
        System.out.println("\n--- Results ---");
        System.out.println("Candidate A: " + votesA);
        System.out.println("Candidate B: " + votesB);
    }
}