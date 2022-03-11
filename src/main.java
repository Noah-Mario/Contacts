import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.lang.String;

public class main {

    public static void searchContact(Path filepath) throws IOException {
        List<String> contactList = Files.readAllLines(filepath);
        Scanner scan = new Scanner(System.in);
        System.out.println("Search for a contact: ");
        String name = scan.nextLine();

        for (String line : contactList) {
            if (line.contains(name)) {
                System.out.println("here's the name and number: " + line);
            }
        }
    }

    public static List<String> DeletesContact(Path filepath) throws IOException {
        List<String> contactList = Files.readAllLines(filepath);
        List<String> newList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("What contact do you want to delete: ");

        String input = scan.nextLine();

        for (String line : contactList) {
            if (line.contains(input)) {
                System.out.println("this contact has been removed");
            } else {
                newList.add(line);
            }
        }
        return newList;
    }


/*    public static void PrintContacts(Path filepath) throws IOException {
        List<String> contactList = Files.readAllLines(filepath);
        for (int i = 0; i < contactList.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactList.get(i));
        }
    }*/

    public static void PrintContacts(Path filepath) throws IOException {
        List<String> contactList = Files.readAllLines(filepath);
        /*========*/
        lineSize = contactList.size();
        contactsArr = new String[lineSize];
        /*=======*/
        for (int i = 0; i < contactList.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactList.get(i));
            contactsArr[i] = contactList.get(i);
        }
    }

    public static List<String> AddContacts(Path filepath) throws IOException {
        List<String> contactList = Files.readAllLines(filepath);

        /*=======*/
        lineSize = contactList.size();
        contactsArr = new String[lineSize];
        /*=======*/

        Scanner scanner = new Scanner(System.in);
        String input;
        String data;

        System.out.println("What is your full name?");
        input = scanner.nextLine();
        data = input;

        if (contactList.isEmpty()) {

            data = input;
            System.out.println("What is your phone number?");
            input = scanner.nextLine();
            data += " " + input;
            contactList.add(data);
        } else {

            int num = 0;

            for (String line : contactList) {

                num++;

                if (line.contains(input) ) {

                    System.out.println("That name is already in your contacts");
                    System.out.println("Do you want to overwrite it? (Y/N)");

                    input = scanner.nextLine();

                    if (input.equalsIgnoreCase("y")) {

                        System.out.println("Change the name to: ");
                        input = scanner.nextLine();
                        data = input;
                        System.out.println("Change the number to: ");
                        input = scanner.nextLine();
                        String i = input;
                        String j = i.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
                        data += " " + j;
                        contactList.remove(line);
                        contactList.add(data);
                        System.out.println(line + " Was replaced in your contacts with: " + data);

                       break;
                    }else{
                        break;
                    }
                }else if (num == contactList.size()){

                    System.out.println("What is your phone number?");
                    input = scanner.nextLine();
                    String i = input;
                    String j = i.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
                    data += " " + j;
                    contactList.add(data);
                    break;
                }
            }
        }
        /*=============*/
        for(int i = 0; i < lineSize; i++) {
            contactsArr[i] = contactList.get(i);
        }
        /*===========*/
        return contactList;
    }

    static int lineSize = 0;
    static String[] contactsArr = new String[lineSize];

    public static void main(String[] args) throws IOException {
        String directory = "ContactList";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (!Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }

        /*========test======*/
/*        Path filePath = Paths.get(directory, filename);
        PrintContacts(filePath);
        Gui gui = new Gui(contactsArr);
        gui.setVisible(true);*/




        /*============*/



        /*



        List<String> contacts = new ArrayList<>();
        Path filepath = Paths.get(directory, filename);

        Scanner scan = new Scanner(System.in);
        String inputs;


        do {
            System.out.println("1. View contacts.\n" +
                    "2. Add a new contact.\n" +
                    "3. Search a contact by name.\n" +
                    "4. Delete an existing contact.\n" +
                    "5. Exit.\n" +
                    "Enter an option (1, 2, 3, 4 or 5):");
            inputs = scan.nextLine();
            switch (inputs) {
                case "1":
                    PrintContacts(filepath);
                    break;
                case "2":
                    contacts = AddContacts(filepath);
                    Files.write(filepath, contacts);
                    break;
                case "3":
                    searchContact(filepath);
                    break;
                case "4":
                    contacts = DeletesContact(filepath);
                    Files.write(filepath, contacts);
                    break;
                case "5":
                    inputs = "-1";
                    break;
                default:
                    System.out.println("Not one of the numbers, Try again");
            }
        } while (!inputs.equals("-1"));*/

    }

}
