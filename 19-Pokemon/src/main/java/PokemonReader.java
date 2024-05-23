import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class PokemonReader {
    private final String filePath;
    HashMap<Integer, Pokemon> pokemons;

    public PokemonReader() {
        filePath = "Pokemon.csv";
        pokemons = new HashMap<>();
    }

    public void createPokemonsFromCSV() throws IOException {
        BufferedReader reader;
        String currentLine = "";
        try {
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine(); //skip first line
            currentLine = reader.readLine();
            while (currentLine != null) {
                String[] args = currentLine.split(";");
                int id = Integer.parseInt(args[0]);
                String name = args[1];
                int healthPoints = Integer.parseInt(args[5]);
                int atk = Integer.parseInt(args[6]);
                int def = Integer.parseInt(args[7]);
                int speed = Integer.parseInt(args[10]);

                Pokemon currentPokemon = new Pokemon(id, name, healthPoints, atk, def, speed);
                pokemons.put(id, currentPokemon);
                currentLine = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Pokemon getPokemonWithName(String name){
        for (Pokemon pokemon : pokemons.values()){
            if (pokemon.getName().equalsIgnoreCase(name)){
                return pokemon;
            }
        }
        return null;
    }

    public Pokemon getPokemonWithId(int id){
        return pokemons.get(id);
    }
}
