import java.util.Random;
import java.util.Scanner;

public class GameOfLife {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int generations;
        int mapSize;

        boolean cellState;

        System.out.println("How big do you want the grid to be?");
        mapSize = sc.nextInt();
        int[][] map = new int[mapSize][mapSize];
        System.out.println("How many generations do you want?");
        generations = sc.nextInt();

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map.length; x++) {
                map[y][x] = r.nextInt(2);
            }
        }
        int S = mapSize;
        print(map, S);

        System.out.println();

        for (int k = 0; k < generations; k++){
            map = nextGeneration(map, S);
        }
    }

    static int[][] nextGeneration(int[][] map, int S) {

        int[][] future = new int[S][S];

        for (int l = 0; l < S; l++) {
            for (int m = 0; m < S; m++) {
                int aliveNeighbours = -map[l][m];
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if ((l + i >= 0 && l + i < S) && (m + j >= 0 && m + j < S)) {
                            aliveNeighbours += map[l + i][m + j];
                        }
                    }
                }
                if (map[l][m] == 1 && aliveNeighbours == 2 || aliveNeighbours == 3){
                    future[l][m] = 1;
                }else{
                    future[l][m] = 0;
                }
            }
        }

        System.out.println("Next Generation");

        print(map, S);

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return future;
    }
    public static void print(int[][] map, int S){
        for (int i = 0; i < S; i++) {
            for (int j = 0; j < S; j++) {
                if (map[i][j] == 0) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[#]");
                }
            }
            System.out.println();
        }
    }
}