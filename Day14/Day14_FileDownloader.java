import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// Runnable implementation
class FileDownloadTask implements Runnable {

    private String fileName;

    public FileDownloadTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " started downloading: " + fileName);

            // Simulate download time
            Thread.sleep(2000);

            System.out.println(Thread.currentThread().getName() + " finished downloading: " + fileName);

        } catch (InterruptedException e) {
            System.out.println("Download interrupted for: " + fileName);
        }
    }
}

public class Day14_FileDownloader {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Enter number of files: ");
            int n = Integer.parseInt(br.readLine());

            Thread[] threads = new Thread[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Enter file name: ");
                String fileName = br.readLine();

                FileDownloadTask task = new FileDownloadTask(fileName);

                threads[i] = new Thread(task);
                threads[i].setPriority(Thread.MIN_PRIORITY + i % 5);
                threads[i].start();
            }

            // Wait for all threads to complete
            for (Thread t : threads) {
                t.join();
            }

            System.out.println("All downloads completed!");

        } catch (IOException e) {
            System.out.println("Input Error");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
}