import java.util.*;

// Base Class
abstract class Employee {
    int id;
    String name;
    double baseSalary;

    Employee(int id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    abstract double calculateGrossSalary();

    double calculateTax(double gross) {
        if (gross <= 30000) return gross * 0.10;
        else if (gross <= 60000) return gross * 0.20;
        else return gross * 0.30;
    }

    void generateSlip() {
        double gross = calculateGrossSalary();
        double tax = calculateTax(gross);
        double net = gross - tax;

        System.out.println("\n--- Salary Slip ---");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Gross Salary: " + gross);
        System.out.println("Tax Deduction: " + tax);
        System.out.println("Net Salary: " + net);
        System.out.println("----------------------");
    }
}

// Manager Class
class Manager extends Employee {
    Manager(int id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }

    double calculateGrossSalary() {
        double hra = baseSalary * 0.20;
        double bonus = baseSalary * 0.15;
        return baseSalary + hra + bonus;
    }
}

// Developer Class
class Developer extends Employee {
    Developer(int id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }

    double calculateGrossSalary() {
        double hra = baseSalary * 0.15;
        double allowance = baseSalary * 0.10;
        return baseSalary + hra + allowance;
    }
}

// Main Class
public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Payroll System ---");
            System.out.println("1. Add Manager");
            System.out.println("2. Add Developer");
            System.out.println("3. Generate Salary Slip");
            System.out.println("4. Exit");

            int choice = getInt("Enter choice: ");

            switch (choice) {
                case 1: addManager(); break;
                case 2: addDeveloper(); break;
                case 3: generateSlip(); break;
                case 4: System.out.println("Exiting..."); return;
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

    static double getDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Enter salary.");
            }
        }
    }

    static Employee findEmployee(int id) {
        for (Employee e : employees) {
            if (e.id == id) return e;
        }
        return null;
    }

    static void addManager() {
        int id = getInt("Enter ID: ");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        double salary = getDouble("Enter Base Salary: ");

        employees.add(new Manager(id, name, salary));
        System.out.println("Manager added!");
    }

    static void addDeveloper() {
        int id = getInt("Enter ID: ");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        double salary = getDouble("Enter Base Salary: ");

        employees.add(new Developer(id, name, salary));
        System.out.println("Developer added!");
    }

    static void generateSlip() {
        int id = getInt("Enter Employee ID: ");
        Employee e = findEmployee(id);

        if (e != null) {
            e.generateSlip();
        } else {
            System.out.println("Employee not found!");
        }
    }
}