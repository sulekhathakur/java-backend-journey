package Day9;

interface Notification {
    void send(String message);
}

// Email implementation
class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Email Sent: " + message);
    }
}

// SMS implementation
class SMSNotification implements Notification {
    public void send(String message) {
        System.out.println("SMS Sent: " + message);
    }
}

public class Day09_NotificationSystem {

    // Inner class
    static class Logger {
        void log(String msg) {
            System.out.println("[LOG]: " + msg);
        }
    }

    public static void main(String[] args) {

        Notification email = new EmailNotification();
        Notification sms = new SMSNotification();

        email.send("Welcome via Email");
        sms.send("Welcome via SMS");

        // Anonymous inner class
        Notification push = new Notification() {
            public void send(String message) {
                System.out.println("Push Notification: " + message);
            }
        };

        push.send("Welcome via Push");

        // Using inner class
        Logger logger = new Logger();
        logger.log("All notifications sent successfully");
    }
}