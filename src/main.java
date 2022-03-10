import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void PrintContacts(Path filepath) throws IOException {
        List<String> contactList = Files.readAllLines(filepath);

        for (int i = 0; i < contactList.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactList.get(i));
        }
    }

    public static List<String> AddContacts(Path filepath, List<String> contacts ) throws IOException{
        List<String> lines = Files.readAllLines(filepath);
        List<String> newList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String input;
        String data = "";
        do {

            System.out.println("What is your full name?");
            input = scanner.nextLine();
            data = input;



            for (String line : lines) {
                if (line.contains(data)) {
                    System.out.println("That name is already in your contacts");
//                    newList.add(data);
                    continue;
                }
                    System.out.println("What is your phone number?");
                    input = scanner.nextLine();
                    data += " " + input;
                    newList.add(data);


            }

            System.out.println("Would you like to add another contact?[y/n]");
            input = scanner.nextLine();

        }while(input.equalsIgnoreCase("y"));
                return newList;
    }


    public static void main(String[] args) throws IOException {
        String directory="ContactList";
        String filename="contacts.txt";

        Path dataDirectory= Paths.get(directory);
        Path dataFile=Paths.get(directory,filename);

        if(Files.notExists(dataDirectory)){
            Files.createDirectories(dataDirectory);
        }

        if(!Files.exists(dataFile)){
            Files.createFile(dataFile);
        }






//        System.out.println(data);
//        contacts.add(data);
        List<String> people = new ArrayList<>();


        List<String> contacts = new ArrayList<>();
        Path filepath = Paths.get(directory,filename);
        contacts = AddContacts(filepath, contacts);

        Files.write(filepath,contacts);
        PrintContacts(filepath);

    }
}
