package vistula.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * TASK 1
 * Modify the basic IO example to avoid a third try block.
 * Close the stream in a finally clause attached to the try that reads the file.
 * Uses byte streams (FileInputStream).
 */
public class Task1ShowFileFinally {
    public static void main(String[] args) {
        String fileName = args.length > 0 ? args[0] : "test123.txt";

        FileInputStream fis;
        try {
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return;
        }

        int b;
        try {
            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }
}