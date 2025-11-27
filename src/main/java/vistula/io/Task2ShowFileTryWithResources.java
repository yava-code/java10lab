package vistula.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * TASK 2
 * Use try-with-resources (JDK7+) so close() is not called explicitly.
 * Uses byte streams (FileInputStream).
 */
public class Task2ShowFileTryWithResources {
    public static void main(String[] args) {
        String fileName = args.length > 0 ? args[0] : "test123.txt";

        try (FileInputStream fis = new FileInputStream(fileName)) {
            int b;
            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}