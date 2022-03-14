import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.String;

public class main {

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
                    ContactCtrl.PrintContacts(filepath);
                    break;
                case "2":
                    contacts = ContactCtrl.AddContacts(filepath);
                    Files.write(filepath, contacts);
                    break;
                case "3":
                    ContactCtrl.searchContact(filepath);
                    break;
                case "4":
                    contacts = ContactCtrl.DeletesContact(filepath);
                    Files.write(filepath, contacts);
                    break;
                case "5":
                    inputs = "-1";
                    break;
                default:
                    System.out.println("Not one of the numbers, Try again");
            }
        } while (!inputs.equals("-1"));

    }

}
