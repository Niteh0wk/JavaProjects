import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Person {
    public void createPerson(String firstName, String lastName, String birthday) throws IOException {
        FileWriter writer = new FileWriter("personen.csv");
        char[] content = (firstName + ", " + lastName + ", " + birthday).toCharArray();
        writer.write(content);
        writer.close();
    }

    public void readWithScanner() throws FileNotFoundException {
        File personen = new File("personen.csv");
        Scanner fileScanner = new Scanner(personen);
        while (fileScanner.hasNextLine()){
            System.out.println(fileScanner.nextLine());
        }
        fileScanner.close();
    }

    public void readWithFiles() throws IOException {
        List<String> content = Files.readAllLines(Paths.get("personen.csv"));
        for (String line : content){
            System.out.println(line);
        }
    }
}
