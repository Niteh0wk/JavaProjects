import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Pokemon player;
    private Pokemon computer;
    PokemonReader pokemonReader;
    AttacksReader attackReader;
    Random r = new Random();
    Battle battle = new Battle();

    public Game() {
        pokemonReader = new PokemonReader();
        attackReader = new AttacksReader();
    }

    public void setUp() throws IOException {
        pokemonReader.createPokemonFromCSV();
        attackReader.createAttackFromCSV();
    }

    public void choosePokemonWithName(String name) {
        player = pokemonReader.getPokemonWithName(name).clone();
        computer = pokemonReader.getPokemonWithId(r.nextInt(151)).clone();
        player.setAttack1(attackReader.getAttack(r.nextInt(217)));
        player.setAttack2(attackReader.getAttack(r.nextInt(217)));
        computer.setAttack1(attackReader.getAttack(r.nextInt(217)));
        computer.setAttack2(attackReader.getAttack(r.nextInt(217)));
    }

    public void choosePokemonWithId(int id) {
        player = pokemonReader.getPokemonWithId(id).clone();
        computer = pokemonReader.getPokemonWithId(r.nextInt(151)).clone();
        player.setAttack1(attackReader.getAttack(r.nextInt(217)));
        player.setAttack2(attackReader.getAttack(r.nextInt(217)));
        computer.setAttack1(attackReader.getAttack(r.nextInt(217)));
        computer.setAttack2(attackReader.getAttack(r.nextInt(217)));
    }

    public void startBattle(Scanner sc) {
        System.out.println("Player chose: " + player);
        System.out.println("Computer chose: " + computer);
        do {
            if ((player.getSpeed() > computer.getSpeed()) && (player.getHealthPoints() > 0.00 && computer.getHealthPoints() > 0.00)){
                player(sc);
                computer();
            }else if ((computer.getSpeed() > player.getSpeed()) && (player.getHealthPoints() > 0.00 && computer.getHealthPoints() > 0.00)){
                computer();
                player(sc);
            }
        }while (player.getHealthPoints() > 0 && computer.getHealthPoints() > 0);
    }

    private void player(Scanner sc){
        int chosenAttack;
        System.out.println("Choose your Attack:");
        System.out.println("1. " + player.getAttack1());
        System.out.println("2. " + player.getAttack2());
        chosenAttack = sc.nextInt();
        if (chosenAttack == 1){
            computer.setHealthPoints(battle.playerAttack(player.getAttack1().getPower(), player.getAtk(), player.getDef(), player.getAttack1().getName(), computer.getName(), computer.getHealthPoints()));
        }else if (chosenAttack == 2){
            computer.setHealthPoints(battle.playerAttack(player.getAttack2().getPower(), player.getAtk(), player.getDef(), player.getAttack1().getName(), computer.getName(), computer.getHealthPoints()));
        }
    }

    private void computer(){
        int chosenAttack;
        if (computer.getHealthPoints() > 0.00){
            chosenAttack = r.nextInt(1,3);
            if (chosenAttack == 1){
                player.setHealthPoints(battle.computerAttack(computer.getAttack1().getPower(), computer.getAtk(), computer.getDef(), computer.getAttack1().getName(), computer.getName(), player.getHealthPoints()));
            }else if (chosenAttack == 2){
                player.setHealthPoints(battle.computerAttack(computer.getAttack2().getPower(), computer.getAtk(), computer.getDef(), computer.getAttack2().getName(), computer.getName(), player.getHealthPoints()));
            }
        }
    }
}


/* 151 Pokemon, 217 Attacks */