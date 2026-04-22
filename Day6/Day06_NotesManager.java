package Day6;

import java.util.Scanner;

// Parent class
class BaseEntity {
    BaseEntity() {
        System.out.println("BaseEntity Constructor Called");
    }
}

// Child class using encapsulation
class Note extends BaseEntity {
    private String title;
    private String content;

    // Default constructor
    Note() {
        this("Untitled", "No Content");
    }

    // Parameterized constructor
    Note(String title, String content) {
        super(); // calling parent constructor
        this.title = title;
        this.content = content;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Display
    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
    }
}

public class Day06_NotesManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Note[] notes = new Note[10];
        int count = 0;

        int choice;

        do {
            System.out.println("\n--- Secure Notes Manager ---");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Content: ");
                    String content = sc.nextLine();

                    notes[count] = new Note(title, content);
                    count++;
                    break;

                case 2:
                    for (int i = 0; i < count; i++) {
                        notes[i].display();
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        // Anonymous object example
        new Note("Quick Note", "Created using anonymous object").display();

        sc.close();
    }
}