import javax.swing.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
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
            for (int x = 0; x < map[y].length; x++) {
                map[y][x] = r.nextInt(2);
            }
        }

        for (int yy = 0; yy < map.length; yy++) {
            for (int xx = 0; xx < map[yy].length; xx++) {
                if (map[yy][xx] == 0) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[#]");
                }
            }
            System.out.println();
        }
        System.out.println();
        int M = mapSize;
        int N = mapSize;
        for (int k = 0; k < generations; k++){
            nextGeneration(map, M, N);
        }
    }

    static void nextGeneration(int map[][], int M, int N) {

        int[][] future = new int[M][N];

        for (int l = 0; l < M; l++) {
            for (int m = 0; m < N; m++) {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if ((l + i >= 0 && l + i < M) && (m + j >= 0 && m + j < N)) {
                            aliveNeighbours += map[l + i][m + j];
                        }
                    }
                }
                aliveNeighbours -= map[l][m];

                if ((map[l][m] == 1) && (aliveNeighbours < 2))
                    future[l][m] = 0;
                else if ((map[l][m] == 1) && (aliveNeighbours > 3))
                    future[l][m] = 0;
                else if ((map[l][m] == 0) && (aliveNeighbours == 3))
                    future[l][m] = 1;
                else
                    future[l][m] = map[l][m];
            }
        }

        System.out.println("Next Generation");

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (future[i][j] == 0) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[#]");
                }
            }
            System.out.println();
        }
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}