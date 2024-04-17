import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BingoCard {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] bingoCard = new int[5][5];
        ArrayList<Integer> checker = new ArrayList<>();
        int min = 1;
        int max = 16;

        for (int k = 0; k < bingoCard.length; k++){
            for (int l = 0; l < bingoCard.length; l++){
                do {
                    bingoCard[l][k] = random.nextInt(min, max);
                }while (checker.contains(bingoCard[l][k]));
                checker.add(bingoCard[l][k]);
            }
            min += 15;
            max += 15;
        }
        bingoCard[2][2] = 0;

        System.out.println("[B][I][N][G][O]");
        for (int y = 0; y < bingoCard.length; y++){
            for (int x = 0; x < bingoCard[y].length; x++){
                System.out.print("[" + bingoCard[y][x] + "]");
            }
            System.out.println();
        }
    }
}
