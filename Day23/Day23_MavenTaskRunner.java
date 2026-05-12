package Day23;

import java.util.*;

class MavenGoal {

    private String goalName;

    public MavenGoal(String goalName) {
        this.goalName = goalName;
    }

    public void executeGoal() {
        System.out.println("Executing Maven Goal: " + goalName);
    }

    @Override
    public String toString() {
        return goalName;
    }
}

public class Day23_MavenTaskRunner {

    public static void main(String[] args) {

        Queue<MavenGoal> lifecycle = new LinkedList<>();

        // Maven lifecycle simulation
        lifecycle.offer(new MavenGoal("clean"));
        lifecycle.offer(new MavenGoal("compile"));
        lifecycle.offer(new MavenGoal("test"));
        lifecycle.offer(new MavenGoal("package"));
        lifecycle.offer(new MavenGoal("install"));

        System.out.println("=== Maven Build Started ===\n");

        while (!lifecycle.isEmpty()) {

            MavenGoal current = lifecycle.poll();

            current.executeGoal();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Build Interrupted");
            }
        }

        System.out.println("\n=== Maven Build Successful ===");
    }
}