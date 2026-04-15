import java.util.*;

class Ticket {
    int ticketId;
    String name;

    Ticket(int ticketId, String name) {
        this.ticketId = ticketId;
        this.name = name;
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int totalSeats = 5;
    static int availableSeats = totalSeats;
    static int ticketCounter = 1;

    static HashMap<Integer, Ticket> bookings = new HashMap<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Railway Reservation System ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Available Seats");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    cancelTicket();
                    break;
                case 3:
                    viewSeats();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }

    // Book Ticket
    static void bookTicket() {
        if (availableSeats == 0) {
            System.out.println("No seats available!");
            return;
        }

        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();

        int ticketId = ticketCounter++;
        bookings.put(ticketId, new Ticket(ticketId, name));

        availableSeats--;

        System.out.println("Ticket booked successfully!");
        System.out.println("Your Ticket ID: " + ticketId);
    }

    // Cancel Ticket
    static void cancelTicket() {
        System.out.print("Enter Ticket ID: ");
        int id = sc.nextInt();

        if (bookings.containsKey(id)) {
            bookings.remove(id);
            availableSeats++;
            System.out.println("Ticket cancelled successfully!");
        } else {
            System.out.println("Invalid Ticket ID!");
        }
    }

    // View Seats
    static void viewSeats() {
        System.out.println("Available Seats: " + availableSeats + "/" + totalSeats);
    }
}