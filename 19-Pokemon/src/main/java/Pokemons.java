import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pokemons {
    private String filePath = "Pokemon.csv";
    private List<String> name = new ArrayList<>();
    private List<Integer> atk = new ArrayList<>();
    private List<Integer> def = new ArrayList<>();
    private List<Integer> speed = new ArrayList<>();
    private List<String> type1 = new ArrayList<>();
    private List<String> type2 = new ArrayList<>();
    private List<Integer> healthPoints = new ArrayList<>();
    HashMap<String, Integer> pokemons = new HashMap<>();

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
            atk.add(Integer.parseInt(args[9]));
            def.add(Integer.parseInt(args[10]));
            speed.add(Integer.parseInt(args[11]));
            type1.add(args[3]);
            type2.add(args[4]);
            healthPoints.add(Integer.parseInt(args[6]));
            help = reader.readLine();
        }

        for (int i = 0; i < name.size(); i++) {
            pokemons.put(name.get(i), i);
        }
    }

    public String getName(int index) {
        int currentIndex = 0;
        for (String key : pokemons.keySet()) {
            if (currentIndex == index) {
                return key;
            }
            currentIndex++;
        }
        return null;
    }

    public Integer getIndex(String name) {
        return pokemons.get(name);
    }

    public Integer getAtk(int atPos) {
        return atk.get(atPos);
    }

    public Integer getDef(int atPos) {
        return def.get(atPos);
    }

    public Integer getSpeed(int atPos) {
        return speed.get(atPos);
    }

    public String getType1(int atPos){
        return type1.get(atPos);
    }

    public String getType2(int atPos){
        return type2.get(atPos);
    }

    public Integer getHealthPoints(int atPos) {
        return healthPoints.get(atPos);
    }
}


/* #;Name;Type 1;Type 2;Total;HP;Attack;Defense;Sp. Atk;Sp. Def;Speed für später */
