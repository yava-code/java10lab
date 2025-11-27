package vistula.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * TASK 6
 * Ask the user for the first three digits of a bank account,
 * download the mapping file and print the abbreviated bank number and bank name.
 */
public class Task6BankLookup {
    private static final String SOURCE_URL = "https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first three digits of bank account: ");
        String code = scanner.nextLine().trim();

        if (!code.matches("\\d{3}")) {
            System.out.println("Please enter exactly three digits.");
            return;
        }

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new URL(SOURCE_URL).openStream(), StandardCharsets.UTF_8))) {
            String line;
            String shortNumber = null;
            String bankName = null;

            while ((line = br.readLine()) != null) {
                // Many official text files use ';' as separator. Try to parse; if not, fallback.
                String[] parts = line.split("[;\t]");
                if (parts.length > 0 && parts[0].trim().equals(code)) {
                    shortNumber = parts.length > 2 ? parts[2].trim() : code;
                    bankName = parts.length > 3 ? parts[3].trim() : line.replaceFirst("^\\d{3}\\s*", "").trim();
                    break;
                } else if (line.startsWith(code)) { // fallback if no separators
                    shortNumber = code;
                    bankName = line.substring(code.length()).trim();
                    break;
                }
            }

            if (bankName != null) {
                System.out.println("Abbreviated bank number: " + shortNumber);
                System.out.println("Bank name: " + bankName);
            } else {
                System.out.println("Bank not found for code: " + code);
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}