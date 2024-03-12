package ex3;

import ex3.entities.Contacts;

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

        Contacts.handleContacts(myContacts);
    }
}