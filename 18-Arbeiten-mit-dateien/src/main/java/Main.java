import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
     Person p1 = new Person();

     try {
         p1.createPerson("Philipp", "Gerstl","24.02.2003");
     }catch (IOException e){
         e.getCause();
     }

     try {
         p1.readWithScanner();
     }catch (FileNotFoundException e){
         e.getCause();
     }

        try {
            p1.createPerson("Ramona", "Gerstl","07.12.1985");
        }catch (IOException e){
            e.getCause();
        }

     try {
         p1.readWithFiles();
     }catch (IOException e){
         e.getCause();
     }

    }
}
