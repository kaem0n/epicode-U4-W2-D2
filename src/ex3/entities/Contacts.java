package ex3.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Contacts {
    private final Map<String, String> contactList = new HashMap<>();

    public void addContact(String name, String phoneNumber) {
        contactList.put(name, phoneNumber);
        System.out.println("New contact created - " + name + ": " + contactList.get(name));
    }

    public void deleteContact(String name) {
        if (contactList.containsKey(name)) {
            System.out.println("Contact removed - " + name + ": " + contactList.get(name));
            contactList.remove(name);
        } else System.out.println("Contact not found.");
    }

    public void searchContactByName(String name) {
        System.out.println();
        if (contactList.containsKey(name)) System.out.println("Contact found - " + name + ": " + contactList.get(name));
        else System.out.println("Contact not found.");
    }

    public void searchContactByPhoneNum(String phoneNumber) {
        String result = "";
        System.out.println();
        for (String name : contactList.keySet()) {
            if (phoneNumber.equals(contactList.get(name))) result = "Contact found - " + name + ": " + contactList.get(name);
        }
        System.out.println(!result.isBlank() ? result : "Contact not found.");
    }

    public void browseContacts() {
        System.out.println();
        System.out.println("List of contacts:");
        for (String name : contactList.keySet()) System.out.println(name + ": " + contactList.get(name));
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
