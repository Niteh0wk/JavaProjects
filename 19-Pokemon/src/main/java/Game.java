import java.io.IOException;

public class Game {
    private Pokemon player, pc;
    PokemonReader pokemonReader;
    AttacksReader attacksReader;

    public Game() {
        pokemonReader = new PokemonReader();
        attacksReader = new AttacksReader();
    }

    public void setUp() throws IOException {
        pokemonReader.createPokemonsFromCSV();
        attacksReader.createAttacksFromCSV();
    }

    public void choosePokemon() {
        //TODO
    }

    public void startBattle() {
        //TODO
    }
}
