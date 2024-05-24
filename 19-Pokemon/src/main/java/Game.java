import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Pokemon player;
    private Pokemon computer;
    PokemonReader pokemonReader;
    AttacksReader attacksReader;
    Random r = new Random();
    Battle battle = new Battle();


    public Game() {
        pokemonReader = new PokemonReader();
        attacksReader = new AttacksReader();
    }

    public void setUp() throws IOException {
        pokemonReader.createPokemonsFromCSV();
        attacksReader.createAttacksFromCSV();
    }

    public void choosePokemonWithName(String name) {
        player = pokemonReader.getPokemonWithName(name).clone();
        computer = pokemonReader.getPokemonWithId(r.nextInt(151)).clone();
        player.setAttack1(attacksReader.getAttack(r.nextInt(217)));
        player.setAttack2(attacksReader.getAttack(r.nextInt(217)));
        computer.setAttack1(attacksReader.getAttack(r.nextInt(217)));
        computer.setAttack2(attacksReader.getAttack(r.nextInt(217)));
    }

    public void choosePokemonWithId(int id) {
        player = pokemonReader.getPokemonWithId(id).clone();
        computer = pokemonReader.getPokemonWithId(r.nextInt(151)).clone();
        player.setAttack1(attacksReader.getAttack(r.nextInt(217)));
        player.setAttack2(attacksReader.getAttack(r.nextInt(217)));
        computer.setAttack1(attacksReader.getAttack(r.nextInt(217)));
        computer.setAttack2(attacksReader.getAttack(r.nextInt(217)));
    }

    public void startBattle(Scanner sc) {
        System.out.println("Player chose: " + player);
        System.out.println("Computer chose: " + computer);
        double damage;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedDamage;
        int chosenAttack;
        do {
            if ((player.getSpeed() > computer.getSpeed()) && (player.getHealthPoints() > 0.00 && computer.getHealthPoints() > 0.00)){
                System.out.println("Choose your Attack:");
                System.out.println("1. " + player.getAttack1());
                System.out.println("2. " + player.getAttack2());
                chosenAttack = sc.nextInt();
                if (chosenAttack == 1){
                    computer.setHealthPoints(battle.playerAttack(player.getAttack1().getPower(), player.getAtk(), player.getDef(), player.getAttack1().getName(), computer.getName(), computer.getHealthPoints()));
                }else if (chosenAttack == 2){
                    computer.setHealthPoints(battle.playerAttack(player.getAttack2().getPower(), player.getAtk(), player.getDef(), player.getAttack1().getName(), computer.getName(), computer.getHealthPoints()));
                }
                chosenAttack = r.nextInt(1,3);
                if (chosenAttack == 1){
                    player.setHealthPoints(battle.computerAttack(computer.getAttack1().getPower(), computer.getAtk(), computer.getDef(), computer.getAttack1().getName(), computer.getName(), player.getHealthPoints()));
                }else if (chosenAttack == 2){
                    player.setHealthPoints(battle.computerAttack(computer.getAttack2().getPower(), computer.getAtk(), computer.getDef(), computer.getAttack2().getName(), computer.getName(), player.getHealthPoints()));
                }
            }else if ((computer.getSpeed() > player.getSpeed()) && (player.getHealthPoints() > 0.00 && computer.getHealthPoints() > 0.00)){
                chosenAttack = r.nextInt(1,3);
                if (chosenAttack == 1){
                    player.setHealthPoints(battle.computerAttack(computer.getAttack1().getPower(), computer.getAtk(), computer.getDef(), computer.getAttack1().getName(), computer.getName(), player.getHealthPoints()));
                }else if (chosenAttack == 2){
                    player.setHealthPoints(battle.computerAttack(computer.getAttack2().getPower(), computer.getAtk(), computer.getDef(), computer.getAttack2().getName(), computer.getName(), player.getHealthPoints()));
                }
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
        }while (player.getHealthPoints() > 0 && computer.getHealthPoints() > 0);





    }
}


/* 151 Pokemon, 217 Attacks */