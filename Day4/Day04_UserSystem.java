package Day4;

import java.util.Scanner;

class User {
    String fullName;
    String username;
    static int userCount;

    // Static block
    static {
        userCount = 0;
        System.out.println("User System Initialized...");
    }

    // Constructor
    User(String fullName) {
        this.fullName = fullName;
        this.username = generateUsername(fullName);
        userCount++;
    }

    // Static method
    static int getUserCount() {
        return userCount;
    }

    // Generate username using StringBuilder
    String generateUsername(String name) {
        StringBuilder sb = new StringBuilder();

        String[] parts = name.toLowerCase().split(" ");

        for (String part : parts) {   // enhanced for loop
            sb.append(part.charAt(0));
        }

        sb.append("_").append(userCount + 1);

        return sb.toString();
    }

    // Validate username
    boolean validateUsername() {
        if (username.length() < 5) return false;
        if (!username.contains("_")) return false;
        return true;
    }

    void display() {
        System.out.println("Name: " + fullName);
        System.out.println("Username: " + username);
        System.out.println("Valid: " + validateUsername());
    }
}

public class Day04_UserSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of users: ");
        int n = sc.nextInt();
        sc.nextLine();

        User[] users = new User[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter full name: ");
            String name = sc.nextLine();

            users[i] = new User(name);
        }

        System.out.println("\n--- User Details ---");

        for (User u : users) {   // enhanced for loop
            u.display();
            System.out.println();
        }

        System.out.println("Total Users Created: " + User.getUserCount());

        sc.close();
    }
}