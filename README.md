# Phone Book Application

This is a simple Java-based Phone Book application that allows users to manage their contacts. The application supports adding, deleting, updating, searching, and displaying contacts. It uses a `HashMap` to store contact names and their associated phone numbers.

## Features

- **Add Contact:** Add a new contact to the phone book.
- **Delete Contact:** Delete an existing contact from the phone book.
- **Update Contact:** Update the phone number of an existing contact.
- **Search Contact:** Search for a contact by name.
- **Display All Contacts:** Display all the contacts in the phone book.
- **Exit:** Exit the program.

## How to Use

1. **Add Contact**: 
    - Type `add` when prompted for a command.
    - Enter the contact's name.
    - Enter a valid phone number (only numeric input is accepted).

2. **Delete Contact**: 
    - Type `delete` when prompted for a command.
    - Enter the contact's name to delete it from the phone book.

3. **Update Contact**: 
    - Type `update` when prompted for a command.
    - Enter the contact's name.
    - Enter the new phone number (only numeric input is accepted).

4. **Search Contact**: 
    - Type `search` when prompted for a command.
    - Enter the contact's name to search for it.

5. **Display All Contacts**: 
    - Type `display` to show all the saved contacts in the phone book.

6. **Exit**: 
    - Type `exit` to close the application.

## Setup and Execution

1. Clone the repository or download the code files.
2. Compile the Java program using the following command:
    ```bash
    javac PhoneBook.java
    ```
3. Run the compiled program using:
    ```bash
    java PhoneBook
    ```

## Example Commands

- Add a contact:
  ```bash
  add
