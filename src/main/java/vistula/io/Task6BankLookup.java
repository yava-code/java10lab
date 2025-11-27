package vistula.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task6BankLookup {
    private static final String LINK = "https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first three digits of bank account: ");
        String code = sc.nextLine().trim();
        if (code.length() != 3) {
            System.out.println("Please enter exactly three digits.");
            return;
        }

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new URL(LINK).openStream(), StandardCharsets.UTF_8))) {
            String line;
            String shortNo = null;
            String name = null;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith(code)) continue;
                String[] parts = line.split(";");
                if (parts.length > 0 && parts[0].trim().equals(code)) {
                    if (parts.length > 2) shortNo = parts[2].trim();
                    if (parts.length > 3) name = parts[3].trim();
                    break;
                }
            }
            if (name != null) {
                System.out.println("Abbreviated bank number: " + (shortNo != null ? shortNo : code));
                System.out.println("Bank name: " + name);
            } else {
                System.out.println("Bank not found for code: " + code);
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}