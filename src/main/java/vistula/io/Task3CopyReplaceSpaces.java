package vistula.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * TASK 3
 * Copy a text file, replacing spaces with dashes, using byte streams.
 * Files are closed automatically via try-with-resources.
 */
public class Task3CopyReplaceSpaces {
    public static void main(String[] args) {
        String src = args.length > 0 ? args[0] : "test123.txt";
        String dst = args.length > 1 ? args[1] : "test123_copy.txt";

        try (FileInputStream in = new FileInputStream(src);
             FileOutputStream out = new FileOutputStream(dst)) {
            int b;
            while ((b = in.read()) != -1) {
                if (b == ' ') b = '-';
                out.write(b);
            }
            System.out.println("Copied to: " + dst);
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}