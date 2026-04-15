import java.io.*;
import java.util.*;

public class Main {
    static final String FILE_NAME = "contacts.txt";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n--- Contact Management System ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");

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
                    addContact(sc);
                    break;
                case 2:
                    deleteContact(sc);
                    break;
                case 3:
                    searchContact(sc);
                    break;
                case 4:
                    displayContacts();
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

    // 🔹 Add Contact
    static void addContact(Scanner sc) throws Exception {
        FileWriter fw = new FileWriter(FILE_NAME, true);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        fw.write(name + "," + phone + "\n");
        fw.close();

        System.out.println("Contact added successfully!");
    }

    // 🔹 Display Contacts
    static void displayContacts() throws Exception {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No contacts found!");
            return;
        }

        Scanner fileReader = new Scanner(file);
        System.out.println("\n--- Contact List ---");

        while (fileReader.hasNextLine()) {
            System.out.println(fileReader.nextLine());
        }

        fileReader.close();
    }

    // 🔹 Search Contact
    static void searchContact(Scanner sc) throws Exception {
        System.out.print("Enter name to search: ");
        String search = sc.nextLine().toLowerCase();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No contacts found!");
            return;
        }

        Scanner fileReader = new Scanner(file);
        boolean found = false;

        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            if (line.toLowerCase().contains(search)) {
                System.out.println("Found: " + line);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found!");
        }

        fileReader.close();
    }

    // 🔹 Delete Contact
    static void deleteContact(Scanner sc) throws Exception {
        System.out.print("Enter name to delete: ");
        String name = sc.nextLine().toLowerCase();

        File inputFile = new File(FILE_NAME);

        if (!inputFile.exists()) {
            System.out.println("No contacts found!");
            return;
        }

        File tempFile = new File("temp.txt");

        Scanner fileReader = new Scanner(inputFile);
        FileWriter fw = new FileWriter(tempFile);

        boolean deleted = false;

        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();

            if (!line.toLowerCase().contains(name)) {
                fw.write(line + "\n");
            } else {
                deleted = true;
            }
        }

        fileReader.close();
        fw.close();

        inputFile.delete();
        tempFile.renameTo(inputFile);

        if (deleted)
            System.out.println("Contact deleted successfully!");
        else
            System.out.println("Contact not found!");
    }
}