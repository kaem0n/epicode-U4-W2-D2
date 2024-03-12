package ex1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("CHOOSE AN OPTION:");
        System.out.println("1. Run program");
        System.out.println("0. Exit");
        String input = sc.nextLine();
        switch (input) {
            case "1" -> {
                try {
                    System.out.println();
                    System.out.println("HOW MANY WORDS DO YOU WANT TO INSERT?");
                    int n = Integer.parseInt(sc.nextLine());
                    if (n > 0) {
                        Set<String> words = new HashSet<>();
                        List<String> dupes = new ArrayList<>();
                        for (int i = 0; i < n; i++) {
                            System.out.println();
                            System.out.println("INSERT A WORD:");
                            String word = sc.nextLine();
                            System.out.println("You typed: " + word);
                            if (words.contains(word)) dupes.add(word);
                            else words.add(word);
                        }
                        System.out.println();
                        System.out.println("Number of word duplicates: " + dupes.size());
                        System.out.println(dupes);
                        System.out.println();
                        System.out.println("Number of unique words: " + words.size());
                        System.out.println(words);
                        sc.close();
                    } else {
                        System.err.println("Error: min value allowed = 1");
                        main(args);
                    }
                } catch (NumberFormatException ex) {
                    System.err.println("Error: not a number. Try again.");
                    main(args);
                }
            }
            case "0" -> sc.close();
            default -> {
                System.err.println("Invalid input. Try again.");
                main(args);
            }
        }
    }
}