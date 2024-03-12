package ex3.entities;

import java.util.HashMap;
import java.util.Map;

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
        System.out.println(!result.isEmpty() ? result : "Contact not found.");
    }

    public void browseContacts() {
        System.out.println();
        System.out.println("List of contacts:");
        for (String name : contactList.keySet()) System.out.println(name + ": " + contactList.get(name));
    }
}
