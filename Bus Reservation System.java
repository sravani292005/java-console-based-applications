import java.util.*;

class Bus {
    int busId;
    boolean[] seats;

    Bus(int busId, int totalSeats) {
        this.busId = busId;
        seats = new boolean[totalSeats];
    }

    void displaySeats() {
        System.out.println("Bus " + busId + " Seat Status:");
        for (int i = 0; i < seats.length; i++) {
            System.out.println("Seat " + i + ": " + (seats[i] ? "Booked" : "Available"));
        }
    }

    void bookSeat(int seatNo) {
        if (seatNo >= 0 && seatNo < seats.length) {
            if (!seats[seatNo]) {
                seats[seatNo] = true;
                System.out.println("Seat booked successfully!");
            } else {
                System.out.println("Seat already booked!");
            }
        } else {
            System.out.println("Invalid seat number!");
        }
    }

    void cancelSeat(int seatNo) {
        if (seatNo >= 0 && seatNo < seats.length) {
            if (seats[seatNo]) {
                seats[seatNo] = false;
                System.out.println("Reservation cancelled!");
            } else {
                System.out.println("Seat already empty!");
            }
        } else {
            System.out.println("Invalid seat number!");
        }
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Bus> buses = new ArrayList<>();

    public static void main(String[] args) {
        buses.add(new Bus(1, 5));
        buses.add(new Bus(2, 5));

        int choice = 0;

        do {
            System.out.println("\n--- Bus Reservation System ---");
            System.out.println("1. Book Seat");
            System.out.println("2. Cancel Seat");
            System.out.println("3. Display Seats");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input!");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            System.out.print("Enter Bus ID: ");
            int busId = sc.nextInt();

            Bus selectedBus = null;
            for (Bus b : buses) {
                if (b.busId == busId) {
                    selectedBus = b;
                    break;
                }
            }

            if (selectedBus == null) {
                System.out.println("Invalid Bus ID!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Seat Number: ");
                    selectedBus.bookSeat(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter Seat Number: ");
                    selectedBus.cancelSeat(sc.nextInt());
                    break;

                case 3:
                    selectedBus.displaySeats();
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
}