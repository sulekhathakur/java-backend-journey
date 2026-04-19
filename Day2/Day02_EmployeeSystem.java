package Day2;
import java.util.Scanner;

class Employee {
    String name;
    int id;
    double salary;

    // Constructor
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("\nEmployee Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }

    // Method to calculate bonus (overloading)
    double calculateBonus() {
        return salary * 0.10; // default 10%
    }

    double calculateBonus(double percentage) {
        return salary * percentage;
    }
}

public class Day02_EmployeeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(name, id, salary);

        emp.displayDetails();

        System.out.println("\nBonus (Default 10%): " + emp.calculateBonus());
        System.out.println("Bonus (20%): " + emp.calculateBonus(0.20));

        sc.close();
    }
}