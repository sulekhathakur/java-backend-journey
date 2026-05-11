package Day22;

import java.util.*;

class BuildTask {

    private String taskName;

    public BuildTask(String taskName) {
        this.taskName = taskName;
    }

    public void execute() {
        System.out.println("Executing Task: " + taskName);
    }

    @Override
    public String toString() {
        return taskName;
    }
}

public class Day22_BuildFlowManager {

    public static void main(String[] args) {

        Queue<BuildTask> taskQueue = new LinkedList<>();

        // Adding tasks (simulating Maven/Gradle lifecycle)
        taskQueue.offer(new BuildTask("Compile Source Code"));
        taskQueue.offer(new BuildTask("Run Unit Tests"));
        taskQueue.offer(new BuildTask("Resolve Dependencies"));
        taskQueue.offer(new BuildTask("Package Application"));
        taskQueue.offer(new BuildTask("Generate Build Artifact"));

        System.out.println("=== Build Process Started ===\n");

        while (!taskQueue.isEmpty()) {

            BuildTask currentTask = taskQueue.poll();

            currentTask.execute();

            try {
                Thread.sleep(1000); // simulate processing time
            } catch (InterruptedException e) {
                System.out.println("Task Interrupted");
            }
        }

        System.out.println("\n=== Build Process Completed ===");
    }
}