package de.Lian;


public class Main {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\User\\Desktop\\destop\\Coding\\Code25\\FraunhoferTestAufgabe\\src\\main\\resources\\data\\numbers1.txt";

        PalindromeCalculator palindromeCalculator = new PalindromeCalculator(filePath);
        System.out.println("Die lösung ist: " + palindromeCalculator.calculatePalindromeSum());

    }
}