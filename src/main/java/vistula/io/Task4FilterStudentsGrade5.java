package vistula.io;

import java.io.*;

public class Task4FilterStudentsGrade5 {
    public static void main(String[] args) {
        String inFile = args.length > 0 ? args[0] : "studentsEN.txt";
        String outFile = args.length > 1 ? args[1] : "students_grade5.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                boolean ok = false;
                for (String p : parts) {
                    String x = p.trim();
                    if (x.equals("5") || x.equals("5.0")) {
                        ok = true;
                        break;
                    }
                }
                if (ok) {
                    bw.write(line);
                    bw.newLine();
                }
            }
            System.out.println("Filtered to: " + outFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inFile);
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}