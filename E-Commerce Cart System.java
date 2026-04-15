import java.util.*;

class Product {
    String name;
    int price;

    Product(String n, int p) {
        name = n;
        price = p;
    }
}

public class Main {
    static ArrayList<Product> cart = new ArrayList<>();

    public static void main(String[] args) {
        cart.add(new Product("Laptop", 50000));
        cart.add(new Product("Mouse", 500));

        int total = 0;
        for (Product p : cart) {
            total += p.price;
        }

        if (total > 10000) total *= 0.9; // discount

        System.out.println("Total: " + total);
    }
}