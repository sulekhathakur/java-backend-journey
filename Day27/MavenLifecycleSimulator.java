package Day27;

import java.util.*;

class BuildPhase {

    private String phaseName;

    public BuildPhase(String phaseName) {
        this.phaseName = phaseName;
    }

    public boolean executePhase() {

        long startTime = System.currentTimeMillis();

        System.out.println("\n=================================");
        System.out.println("Executing Phase: " + phaseName);

        try {

            Thread.sleep(1000);

            // Simulate failure during TEST phase
            if (phaseName.equalsIgnoreCase("Test")) {

                Random random = new Random();
                int result = random.nextInt(2);

                if (result == 0) {
                    throw new RuntimeException("Unit Tests Failed!");
                }
            }

            long endTime = System.currentTimeMillis();

            System.out.println("[SUCCESS] " + phaseName +
                    " completed in " + (endTime - startTime) + " ms");

            return true;

        } catch (Exception e) {

            long endTime = System.currentTimeMillis();

            System.out.println("[FAILED] " + phaseName +
                    " failed in " + (endTime - startTime) + " ms");

            System.out.println("Reason: " + e.getMessage());

            return false;
        }
    }
}

public class MavenLifecycleSimulator {

    public static void main(String[] args) {

        List<BuildPhase> lifecycle = new ArrayList<>();

        lifecycle.add(new BuildPhase("Validate"));
        lifecycle.add(new BuildPhase("Compile"));
        lifecycle.add(new BuildPhase("Test"));
        lifecycle.add(new BuildPhase("Package"));
        lifecycle.add(new BuildPhase("Verify"));
        lifecycle.add(new BuildPhase("Install"));
        lifecycle.add(new BuildPhase("Deploy"));

        System.out.println("=================================");
        System.out.println(" MAVEN BUILD LIFECYCLE STARTED ");
        System.out.println("=================================");

        boolean buildSuccess = true;

        for (BuildPhase phase : lifecycle) {

            boolean result = phase.executePhase();

            if (!result) {
                buildSuccess = false;

                System.out.println("\nBuild Stopped Due To Failure.");
                break;
            }
        }

        System.out.println("\n=================================");

        if (buildSuccess) {
            System.out.println("BUILD SUCCESSFUL");
        } else {
            System.out.println("BUILD FAILED");
        }

        System.out.println("=================================");
    }
}
