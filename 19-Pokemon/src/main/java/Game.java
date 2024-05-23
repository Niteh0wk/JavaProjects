import java.io.IOException;
import java.util.Random;

public class Game {
    private Pokemon player;
    private Pokemon computer;
    PokemonReader pokemonReader;
    AttacksReader attacksReader;
    Random r = new Random();


    public Game() {
        pokemonReader = new PokemonReader();
        attacksReader = new AttacksReader();
    }

    public void setUp() throws IOException {
        pokemonReader.createPokemonsFromCSV();
        attacksReader.createAttacksFromCSV();
    }

    public void choosePokemonWithName(String name) {
        player = pokemonReader.getPokemonWithName(name);
        computer = pokemonReader.getPokemonWithId(r.nextInt(151));
    }

    public void choosePokemonWithId(int id) {
        player = pokemonReader.getPokemonWithId(id);
        computer = pokemonReader.getPokemonWithId(r.nextInt(151));
    }

    public void startBattle() {

    }
}


/* 151 Pokemon, 217 Attacks */