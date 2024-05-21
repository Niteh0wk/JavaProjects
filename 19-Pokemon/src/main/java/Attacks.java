import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Attacks {
    String filePath = "Attacks.csv";
    List<String> list = new ArrayList();

    public void readWithBuffered() throws IOException{
        BufferedReader reader;
        String help = "";
        try {
            reader = new BufferedReader(new FileReader(filePath));
        }catch (IOException e){
            e.printStackTrace();
            return;
        }

        try {
            help = reader.readLine();
        }catch (IOException e){
            try {
                reader.close();
            }catch (IOException ex){
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }

        try {
            help = reader.readLine();
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        while (help != null){
            String[] args = help.split(";");
            Integer.parseInt(args[7]);

        }
    }

}



/* #;Name;Effect;Type;Kind;Power;Accuracy;PP für später */