import java.util.*;

// Product class
class Product {
    int id;
    String name;
    int quantity;
    double price;

    Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println(id + " | " + name + " | Qty: " + quantity + " | Price: " + price);
    }
}

// Main Inventory System
public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Product> inventory = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. Remove Product");
            System.out.println("4. Display Inventory");
            System.out.println("5. Total Inventory Value");
            System.out.println("6. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1: addProduct(); break;
                case 2: updateStock(); break;
                case 3: removeProduct(); break;
                case 4: displayInventory(); break;
                case 5: totalValue(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    // Add Product
    static void addProduct() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        inventory.add(new Product(id, name, qty, price));
        System.out.println("Product added!");
    }

    // Update Stock
    static void updateStock() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (Product p : inventory) {
            if (p.id == id) {
                System.out.print("Enter New Quantity: ");
                p.quantity = sc.nextInt();
                System.out.println("Stock updated!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    // Remove Product
    static void removeProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Iterator<Product> it = inventory.iterator();
        while (it.hasNext()) {
            Product p = it.next();
            if (p.id == id) {
                it.remove();
                System.out.println("Product removed!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    // Display Inventory + Low Stock Alert
    static void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }

        for (Product p : inventory) {
            p.display();

            if (p.quantity < 5) {
                System.out.println("⚠ Low Stock Alert for " + p.name);
            }
        }
    }

    // Total Inventory Value
    static void totalValue() {
        double total = 0;

        for (Product p : inventory) {
            total += p.quantity * p.price;
        }

        System.out.println("Total Inventory Value: " + total);
    }
}