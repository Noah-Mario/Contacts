import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactCtrl {
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

    /*======================================================================*/
    /*=============================For Gui==================================*/
    public static List<String> DeletesContact(Path filepath, String input) throws IOException {
        List<String> contactList = Files.readAllLines(filepath);
        List<String> newList = new ArrayList<>();

        for (String line : contactList) {
            if (!line.equals(input)) {
                newList.add(line);
                break;
            }
        }
        return newList;
    }

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

    /*======================================================================*/
    /*=============================For Gui==================================*/
    public static String searchContact(Path filepath, String name) throws IOException {
        List<String> contactList = Files.readAllLines(filepath);
        String foundName = "";
        for (String line : contactList) {
            if (line.contains(name)) {
                foundName = name;
                break;
            }
        }
        return foundName;
    }
    /*======================================================================*/
    /*======================================================================*/

    public static List<String> AddContacts(Path filepath) throws IOException {
        List<String> contactList = Files.readAllLines(filepath);
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

                if (line.contains(input)) {

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
                    } else {
                        break;
                    }
                } else if (num == contactList.size()) {

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
        return contactList;
    }

    /*======================================================================*/
    /*=============================For Gui==================================*/
    public static List<String> AddContacts(Path filepath, String fullName, String phoneNumber) throws IOException {
        List<String> contactList = Files.readAllLines(filepath);
        String data;
        if (contactList.isEmpty()) {
            data = fullName + " " + phoneNumber;
            contactList.add(data);
        } else {
            String j = phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
            data = fullName + " " + j;
            contactList.add(data);
        }
        return contactList;
}

    public static void PrintContacts(Path filepath) throws IOException {
        List<String> contactList = Files.readAllLines(filepath);
        for (int i = 0; i < contactList.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactList.get(i));
        }
    }

    /*======================================================================*/
    /*======================================================================*/
    public static List<String> scanContacts(Path filepath) throws IOException {
        return Files.readAllLines(filepath);
    }

}
