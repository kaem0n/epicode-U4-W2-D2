package ex3;

import ex3.entities.Contacts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        Contacts myContacts = new Contacts();
        myContacts.addContact("Goku", "345 6789101");
        myContacts.addContact("Vegeta", "345 6789102");
        myContacts.addContact("Piccolo", "345 6789103");
        myContacts.addContact("Crilin", "345 6789104");
        myContacts.addContact("Bulma", "345 6789106");
        myContacts.addContact("Freezer", "345 6789107");
        myContacts.addContact("Whis", "345 6789108");
        myContacts.addContact("Lord Beerus", "345 6789109");
        myContacts.addContact("Re Kaio", "345 6789110");
        myContacts.addContact("Popo", "345 6789111");

        handleContacts(myContacts);
    }

    public static void handleContacts(Contacts contacts) {
        loop: while (true) {
            System.out.println();
            Scanner sc = new Scanner(System.in);
            System.out.println("CHOOSE AN OPTION: ");
            System.out.println("1. Add a new contact");
            System.out.println("2. Delete a contact");
            System.out.println("3. Browse your contacts");
            System.out.println("4. Search a contact (by name)");
            System.out.println("5. Search a contact (by phone number)");
            System.out.println("0. Exit");
            String input = sc.nextLine();
            switch (input) {
                case "0" -> {
                    sc.close();
                    break loop;
                }
                case "1" -> {
                    System.out.println();
                    System.out.println("INSERT A NAME:");
                    String name = sc.nextLine();
                    System.out.println("INSERT A PHONE NUMBER:");
                    String phoneNum = sc.nextLine();
                    System.out.println();
                    contacts.addContact(name, phoneNum);
                }
                case "2" -> {
                    System.out.println();
                    System.out.println("INSERT A NAME:");
                    String name = sc.nextLine();
                    System.out.println();
                    contacts.deleteContact(name);
                }
                case "3" -> contacts.browseContacts();
                case "4" -> {
                    System.out.println();
                    System.out.println("INSERT A NAME:");
                    String name = sc.nextLine();
                    contacts.searchContactByName(name);
                }
                case "5" -> {
                    System.out.println();
                    System.out.println("INSERT A PHONE NUMBER: ");
                    String phoneNum = sc.nextLine();
                    contacts.searchContactByPhoneNum(phoneNum);
                }
                default -> System.err.println("Invalid input. Try again.");
            }
        }
    }
}