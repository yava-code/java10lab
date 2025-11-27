package vistula.io;

import java.io.*;
import java.util.Scanner;

public class DataManagement {

    public String readData() {
        System.out.print("Enter first and last name: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void writeDataToFile(String s, String file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(s);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }

    public void readDataFromFile(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}