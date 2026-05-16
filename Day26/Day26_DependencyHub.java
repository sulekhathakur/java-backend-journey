package Day26;

import java.util.*;

class Dependency {

    private String dependencyName;
    private String version;

    public Dependency(String dependencyName, String version) {
        this.dependencyName = dependencyName;
        this.version = version;
    }

    public void displayDependency() {
        System.out.println("Dependency: " + dependencyName);
        System.out.println("Version: " + version);
        System.out.println("----------------------------");
    }
}

public class Day26_DependencyHub {

    public static void main(String[] args) {

        List<Dependency> dependencies = new ArrayList<>();

        dependencies.add(new Dependency("Spring Boot Starter Web", "3.2.0"));
        dependencies.add(new Dependency("MySQL Connector", "8.0.33"));
        dependencies.add(new Dependency("Lombok", "1.18.30"));

        System.out.println("=== Maven Dependency Manager ===\n");

        for (Dependency dependency : dependencies) {
            dependency.displayDependency();
        }

        System.out.println("Dependencies resolved successfully from Maven Repository.");
    }
}