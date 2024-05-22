import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Attacks {
    private String filePath = "Attacks.csv";
    private List<String> name = new ArrayList<>();
    private List<Integer> power = new ArrayList<>();
    private List<String> type = new ArrayList<>();


    public void readWithBuffered() throws IOException {
        BufferedReader reader;
        String help = "";
        try {
            reader = new BufferedReader(new FileReader(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            help = reader.readLine();
        } catch (IOException e) {
            try {
                reader.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }


        while (help != null) {
            String[] args = help.split(";");

            name.add(args[2]);


            type.add(args[4]);


            power.add(Integer.parseInt(args[6]));


            help = reader.readLine();
        }
    }

    public int getAttackPwr(int atPos) {
        return power.get(atPos);
    }

    public String getType1(String type1, int atPos){
        if (type1.matches(type.get(atPos))){
            return type.get(atPos);
        }
        return null;
    }

    public String getType2(String type2, int atPos){
        if (type2.matches(type.get(atPos))){
            return type.get(atPos);
        }
        return null;
    }
}



/* #;Name;Effect;Type;Kind;Power;Accuracy;PP für später */