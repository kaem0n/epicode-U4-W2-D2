package ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        loop: while (true) {
            try {
                System.out.println();
                System.out.println("INSERT LENGTH VALUE:");
                int length = Integer.parseInt(sc.nextLine());
                if (length > 0) {
                System.out.println("You typed: " + length);
                    ArrayList<Integer> numbers = createArrayOfInt(length);
                    doubledArrayOfInt(numbers);
                    System.out.println();
                    while (true) {
                        System.out.println("CHOOSE AN OPTION:");
                        System.out.println("1. Print numbers with even indexes");
                        System.out.println("2. Print numbers with odd indexes");
                        System.out.println("0. Exit");
                        String input = sc.nextLine();
                        switch (input) {
                            case "0" -> {
                                break loop;
                            }
                            case "1" -> printEvenOddIndex(numbers, true);
                            case "2" -> printEvenOddIndex(numbers, false);
                            default -> System.err.println("Invalid input. Try again.");
                        }
                    }
                } else {
                    System.err.println("Error: min value allowed = 1");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Error: not a number. Try again.");
                ex.printStackTrace();
            }
        }

        sc.close();
    }

    public static ArrayList<Integer> createArrayOfInt(int length) {
        ArrayList<Integer> result = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < length; i++) {
            result.add(rnd.nextInt(0, 101));
        }
        Collections.sort(result);
        System.out.println();
        System.out.println("New array of numbers:");
        System.out.println(result);
        return result;
    }

    public static void doubledArrayOfInt(ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<>(arr);
        for (int i = 0; i < arr.size(); i++) {
            result.add(arr.reversed().get(i));
        }
        System.out.println();
        System.out.println("Duplicated array of numbers:");
        System.out.println(result);
    }

    public static void printEvenOddIndex(ArrayList<Integer> arr, boolean bool) {
        ArrayList<Integer> evenIndex = new ArrayList<>();
        ArrayList<Integer> oddIndex = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (i % 2 == 0) evenIndex.add(arr.get(i));
            else oddIndex.add(arr.get(i));
        }
        if (bool) {
            System.out.println();
            System.out.println("Numbers with even indexes:");
            System.out.println(evenIndex);
        } else {
            System.out.println();
            System.out.println("Numbers with odd indexes:");
            System.out.println(oddIndex);
        }
    }
}