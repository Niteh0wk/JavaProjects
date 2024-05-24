import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class AttacksReader {
    private final String filePath;
    HashMap<Integer, Attack> attacks;

    public AttacksReader(){
        filePath = "Attacks.csv";
        attacks = new HashMap<>();
    }


    public void createAttacksFromCSV() throws IOException {
        BufferedReader reader;
        String currentLine = "";
        try {
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine(); // skip first line
            currentLine = reader.readLine();
            while (currentLine != null){
                String[] args = currentLine.split(";");
                int id = Integer.parseInt(args[0]);
                String name = args[1];
                String effect = args[2];
                int power = Integer.parseInt(args[5]);

                Attack currentAttack = new Attack(id, name, effect, power);
                attacks.put(id, currentAttack);
                currentLine = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Attack getAttack(int random){
        return attacks.get(random);
    }


}