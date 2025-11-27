package vistula.io;

import java.io.*;

/**
 * TASK 4
 * Read studentsEN.txt and write only students with grade 5 to a separate file.
 * Uses Character-Based Streams (FileReader, FileWriter) and automatic closing.
 */
public class Task4FilterStudentsGrade5 {
    private static boolean hasGradeFive(String line) {
        if (line == null) return false;
        String[] tokens = line.trim().split("[;,\t\s]+");
        for (String t : tokens) {
            if ("5".equals(t) || "5.0".equals(t)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String input = args.length > 0 ? args[0] : "studentsEN.txt";
        String output = args.length > 1 ? args[1] : "students_grade5.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(input));
             BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (hasGradeFive(line)) {
                    bw.write(line);
                    bw.newLine();
                }
            }
            System.out.println("Filtered grade 5 students to: " + output);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + input);
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}