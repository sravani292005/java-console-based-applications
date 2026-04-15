import java.util.*;

class Room {
    int roomNo;
    String type;
    boolean isBooked;
    String customerName;

    Room(int roomNo, String type) {
        this.roomNo = roomNo;
        this.type = type;
        this.isBooked = false;
    }
}

public class Main {
    static ArrayList<Room> rooms = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        rooms.add(new Room(1, "AC"));
        rooms.add(new Room(2, "Non-AC"));

        int ch;
        do {
            System.out.println("\n1.Book 2.Cancel 3.Available 4.Exit");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Room No: ");
                    int r = sc.nextInt();
                    sc.nextLine();
                    for (Room room : rooms) {
                        if (room.roomNo == r && !room.isBooked) {
                            System.out.print("Enter Name: ");
                            room.customerName = sc.nextLine();
                            room.isBooked = true;
                            System.out.println("Booked!");
                            return;
                        }
                    }
                    System.out.println("Already booked!");
                    break;

                case 2:
                    System.out.print("Enter Room No: ");
                    r = sc.nextInt();
                    for (Room room : rooms) {
                        if (room.roomNo == r && room.isBooked) {
                            room.isBooked = false;
                            System.out.println("Cancelled!");
                        }
                    }
                    break;

                case 3:
                    for (Room room : rooms) {
                        if (!room.isBooked)
                            System.out.println("Room " + room.roomNo + " (" + room.type + ")");
                    }
                    break;
            }
        } while (ch != 4);
    }
}