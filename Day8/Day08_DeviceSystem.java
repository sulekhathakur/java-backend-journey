package Day8;

abstract class Device {
    protected String name;

    Device(String name) {
        this.name = name;
    }

    // abstract method
    abstract void turnOn();

    // final method (cannot override)
    final void deviceInfo() {
        System.out.println("Device: " + name);
    }

    // override Object class method
    @Override
    public String toString() {
        return "Device Name: " + name;
    }
}

class Light extends Device {
    Light(String name) {
        super(name);
    }

    @Override
    void turnOn() {
        System.out.println(name + " Light is ON");
    }
}

class Fan extends Device {
    Fan(String name) {
        super(name);
    }

    @Override
    void turnOn() {
        System.out.println(name + " Fan is ON");
    }
}

class AC extends Device {
    AC(String name) {
        super(name);
    }

    @Override
    void turnOn() {
        System.out.println(name + " AC is ON");
    }
}

public class Day08_DeviceSystem {
    public static void main(String[] args) {

        // Upcasting (parent reference, child object)
        Device d1 = new Light("Bedroom");
        Device d2 = new Fan("Living Room");
        Device d3 = new AC("Office");

        Device[] devices = {d1, d2, d3};

        for (Device d : devices) {
            d.deviceInfo();
            d.turnOn(); // dynamic method dispatch
            System.out.println(d.toString());
            System.out.println();
        }

        // Downcasting example
        if (d1 instanceof Light) {
            Light l = (Light) d1;
            System.out.println("Downcasting successful: " + l.name);
        }
    }
}