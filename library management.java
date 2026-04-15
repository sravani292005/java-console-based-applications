import java.util.*;

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Status: " + (isIssued ? "Issued" : "Available"));
        System.out.println("----------------------");
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Library System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Available Books");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");

            int choice = getInt("Enter choice: ");

            switch (choice) {
                case 1: addBook(); break;
                case 2: issueBook(); break;
                case 3: returnBook(); break;
                case 4: displayAvailable(); break;
                case 5: searchBook(); break;
                case 6: System.out.println("Exiting..."); return;
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

    static Book findBook(int id) {
        for (Book b : books) {
            if (b.id == id) return b;
        }
        return null;
    }

    static void addBook() {
        int id = getInt("Enter Book ID: ");
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    static void issueBook() {
        int id = getInt("Enter Book ID to issue: ");
        Book b = findBook(id);

        if (b == null) {
            System.out.println("Book not found!");
            return;
        }

        if (b.isIssued) {
            System.out.println("Book already issued!");
        } else {
            b.isIssued = true;
            System.out.println("Book issued successfully!");
        }
    }

    static void returnBook() {
        int id = getInt("Enter Book ID to return: ");
        Book b = findBook(id);

        if (b == null) {
            System.out.println("Book not found!");
            return;
        }

        if (!b.isIssued) {
            System.out.println("Book was not issued!");
        } else {
            b.isIssued = false;
            System.out.println("Book returned successfully!");
        }
    }

    static void displayAvailable() {
        boolean found = false;

        for (Book b : books) {
            if (!b.isIssued) {
                b.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available books.");
        }
    }

    static void searchBook() {
        System.out.print("Enter title or author to search: ");
        String keyword = sc.nextLine().toLowerCase();

        boolean found = false;

        for (Book b : books) {
            if (b.title.toLowerCase().contains(keyword) ||
                b.author.toLowerCase().contains(keyword)) {
                b.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching books found.");
        }
    }
}