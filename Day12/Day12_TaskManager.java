package Day12;

// Enum with behavior
enum Priority {
    LOW, MEDIUM, HIGH;

    public void displayPriority() {
        switch (this) {
            case LOW:
                System.out.println("Low Priority Task");
                break;
            case MEDIUM:
                System.out.println("Medium Priority Task");
                break;
            case HIGH:
                System.out.println("High Priority Task");
                break;
        }
    }
}

// Functional Interface
@FunctionalInterface
interface TaskAction {
    void execute(String taskName);
}

class Task {
    private String name;
    private Priority priority;

    public Task(String name, Priority priority) {
        this.name = name;
        this.priority = priority;
    }

    public void performTask(TaskAction action) {
        priority.displayPriority();
        action.execute(name);
    }
}

public class Day12_TaskManager {
    public static void main(String[] args) {

        Task t1 = new Task("Complete DSA Practice", Priority.HIGH);
        Task t2 = new Task("Revise Java Concepts", Priority.MEDIUM);

        // Lambda (functional interface)
        TaskAction action = (taskName) -> {
            System.out.println("Executing Task: " + taskName);
        };

        t1.performTask(action);
        System.out.println();

        t2.performTask(action);
    }
}