import java.util.*;

class Student {
    int id;
    String name;
    ArrayList<Integer> marks;

    Student(int id, String name, ArrayList<Integer> marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    double getAverage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (double) sum / marks.size();
    }

    String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 50) return "C";
        else return "Fail";
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Average: " + getAverage());
        System.out.println("Grade: " + getGrade());
        System.out.println("----------------------");
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            int choice = getIntInput("Enter choice: ");

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayAll(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6: 
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static int getIntInput(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a number.");
            }
        }
    }

    static void addStudent() {
        int id = getIntInput("Enter ID: ");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        int subjects = getIntInput("Enter number of subjects: ");
        ArrayList<Integer> marks = new ArrayList<>();

        for (int i = 0; i < subjects; i++) {
            int m = getIntInput("Enter mark " + (i + 1) + ": ");
            marks.add(m);
        }

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    static void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (Student s : students) {
            s.display();
        }
    }

    static Student findById(int id) {
        for (Student s : students) {
            if (s.id == id) return s;
        }
        return null;
    }

    static void searchStudent() {
        int id = getIntInput("Enter ID to search: ");
        Student s = findById(id);

        if (s != null) {
            s.display();
        } else {
            System.out.println("Student not found.");
        }
    }

    static void updateStudent() {
        int id = getIntInput("Enter ID to update: ");
        Student s = findById(id);

        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new name: ");
        s.name = sc.nextLine();

        int subjects = getIntInput("Enter number of subjects: ");
        s.marks.clear();

        for (int i = 0; i < subjects; i++) {
            int m = getIntInput("Enter new mark " + (i + 1) + ": ");
            s.marks.add(m);
        }

        System.out.println("Student updated successfully!");
    }

    static void deleteStudent() {
        int id = getIntInput("Enter ID to delete: ");
        Student s = findById(id);

        if (s != null) {
            students.remove(s);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
}