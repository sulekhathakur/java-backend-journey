package Day13;

import java.util.*;

// Custom Exception
class InvalidFileException extends Exception {
    public InvalidFileException(String message) {
        super(message);
    }
}

// Functional Interface
@FunctionalInterface
interface FileOperation {
    String process(String fileName);
}

public class Day13_FileProcessor {

    // Method using throws
    public static void validateFile(String fileName) throws InvalidFileException {
        if (!fileName.endsWith(".txt")) {
            throw new InvalidFileException("Invalid file format! Only .txt allowed");
        }
    }

    public static void main(String[] args) {

        List<String> files = Arrays.asList("data.txt", "image.png", "notes.txt");

        // Lambda expression with return
        FileOperation operation = (file) -> {
            return "Processing file: " + file.toUpperCase();
        };

        for (String file : files) {
            try {
                validateFile(file);
                System.out.println(operation.process(file));
            } 
            catch (InvalidFileException e) {
                System.out.println("Custom Exception: " + e.getMessage());
            } 
            catch (Exception e) {
                System.out.println("General Exception occurred");
            }
        }
    }
}