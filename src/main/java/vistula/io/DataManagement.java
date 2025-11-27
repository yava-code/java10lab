package vistula.io;

import java.io.*;
import java.util.Scanner;

/**
 * TASK 5 - DataManagement class
 * Provides three methods: readData(), writeDataToFile(), readDataFromFile().
 * Uses try-with-resources for automatic closing.
 */
public class DataManagement {

    public String readData() {
        System.out.print("Enter first and last name: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void writeDataToFile(String data, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(data);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }

    public void readDataFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\nContents of " + fileName + ":");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}