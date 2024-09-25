import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    private HashMap<String, String> contacts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Long.parseLong(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public void addContact(String name) {
        if (contacts.containsKey(name)) {
            System.out.println("Contact '" + name + "' already exists.");
            return;
        }

        String phoneNumber;
        boolean isValidPhoneNumber = false;

        while (!isValidPhoneNumber) {
            System.out.print("Enter phone number: ");
            phoneNumber = scanner.nextLine().trim();

            if (isNumeric(phoneNumber)) {
                contacts.put(name, phoneNumber);
                System.out.println("Contact '" + name + "' added successfully.");
                isValidPhoneNumber = true;
            } else {
                System.out.println("Invalid phone number format. Please enter a valid number.");
            }
        }
    }

    public void deleteContact(String name) {
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact '" + name + "' deleted successfully.");
        } else {
            System.out.println("Contact '" + name + "' not found.");
        }
    }

    public void updateContact(String name) {
        if (contacts.containsKey(name)) {
            String newPhoneNumber;
            boolean isValidPhoneNumber = false;

            while (!isValidPhoneNumber) {
                System.out.print("Enter new phone number: ");
                newPhoneNumber = scanner.nextLine().trim();

                if (isNumeric(newPhoneNumber)) {
                    contacts.put(name, newPhoneNumber);
                    System.out.println("Contact '" + name + "' updated successfully.");
                    isValidPhoneNumber = true;
                } else {
                    System.out.println("Invalid phone number format. Please enter a valid number.");
                }
            }
        } else {
            System.out.println("Contact '" + name + "' not found.");
        }
    }

    public void searchContact(String name) {
        if (contacts.isEmpty()) {
            System.out.println("ContactBook is empty. Please add contacts first!");
            return;
        }

        if (contacts.containsKey(name)) {
            System.out.println("Name: " + name);
            System.out.println("Phone Number: " + contacts.get(name));
            System.out.println("-----------------------------");

        } else {
            System.out.println("Contact '" + name + "' not found.");
        }
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("ContactBook is empty. Please add contacts first!");
            return;
        }

        System.out.println("\n--- Contacts in Phonebook ---");
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println("Name: " + entry.getKey());
            System.out.println("Phone Number: " + entry.getValue());
            System.out.println("-----------------------------");
        }
    }

    public void processCommands() {
        System.out.println("\n---------Contact Book---------");
        System.out.println("Commands:");
        System.out.println(" Add     - Add a new contact");
        System.out.println(" Delete  - Delete an existing contact");
        System.out.println(" Update  - Update an existing contact");
        System.out.println(" Search  - Search for a contact");
        System.out.println(" Display - Display all contacts");
        System.out.println(" Exit    - Exit the program");

        String command;

        while (true) {
            System.out.print("\nEnter command: ");
            command = scanner.nextLine().trim();

            switch (command.toLowerCase()) {
                case "add":
                    while (true) {
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine().trim();
                        addContact(name);
                        if (contacts.containsKey(name)) {
                            break;
                        }
                    }
                    break;
                case "delete":
                    while (true) {
                        if (contacts.isEmpty()) {
                            System.out.println("ContactBook is empty. Please add contacts first!");
                            break;
                        }
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine().trim();
                        deleteContact(name);
                        if (!contacts.containsKey(name)) {
                            break;
                        }
                    }
                    break;
                case "update":
                    while (true) {
                        if (contacts.isEmpty()) {
                            System.out.println("ContactBook is empty. Please add contacts first!");
                            break;
                        }
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine().trim();
                        updateContact(name);
                        if (!contacts.containsKey(name)) {
                            break;
                        }
                    }
                    break;
                case "search":
                    while (true) {
                        if (contacts.isEmpty()) {
                            System.out.println("ContactBook is empty.\n Please add contacts first!");
                            break;
                        }
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine().trim();
                        searchContact(name);
                        if (contacts.containsKey(name)) {
                            break;
                        }
                    }
                    break;
                case "display":
                    displayContacts();
                    break;
                case "exit":
                    scanner.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.processCommands();
    }
}
