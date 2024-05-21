import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Attacks atk = new Attacks();

        try {
            atk.readWithBuffered();
        }catch (IOException e){
            e.getCause();
        }

    }
}
