package de.Lian;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PalindromeCalculator {

    private final String filePath;

    public PalindromeCalculator(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Berechnet die Summe der Dezimalwerte aller Palindrome aus dem Array.
     *
     * @return Summe der Dezimalwerte aller Palindrome
     */
    public long calculatePalindromeSum() {
        long sum = 0;
        int count = 0;

        for (String binary : readBinaryStrings()) {
            // Prüfe, ob die binäre String ein Palindrom ist
            if (!isPalindrome(binary)) continue;

            // Konvertiere das binäre Palindrom in Dezimal und addiere zur Summe
            long decimalValue = binaryToDecimal(binary);
            sum += decimalValue;

            count++;
        }

        System.out.println("Insgesamt gefundene Palindrome: " + count);
        return sum;
    }

    /**
     * Liest die binären Strings aus der Datei in ein Array ein.
     *
     * @return Array mit allen binären Strings
     * @throws IOException Wenn ein I/O-Fehler auftritt
     */
    public String[] readBinaryStrings() {
        List<String> binaryStrings = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Überspringe leere Zeilen
                if (line.trim().isEmpty()) continue;

                String cleanLine = line.trim()
                        .replace("\"", "")  // Entferne die Anführungszeichen
                        .replace(",", "");  // Entferne das Komma
                binaryStrings.add(cleanLine);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Konvertiere die Liste in ein Array
        return binaryStrings.toArray(new String[0]);
    }


    /**
     * Prüft, ob eine String ein Palindrom ist.
     *
     * @param str Der zu prüfende String
     * @return true, wenn der String ein Palindrom ist, sonst false
     */
    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }


    /**
     * Konvertiert eine binäre String in die passende dezimal zahl.
     *
     * @param binary Den zu konvertierende binäre String
     * @return Der Dezimalwert des binären Strings
     */
    public long binaryToDecimal(String binary) {
        long decimal = 0;
        int length = binary.length();

        for (int i = 0; i < length; i++) {

            if (binary.charAt(i) != '1') continue;

            decimal += Math.pow(2, length - 1 - i);  //berechnet 2^(length-1-i) und addiere
        }
        return decimal;
    }
}

