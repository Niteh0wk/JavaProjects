import java.awt.image.ImageProducer;
import java.util.Arrays;
import java.util.Random;

public class BingoCard {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] bingoCard = new int[5][5];

        for (int k = 0; k < bingoCard.length; k++){
            bingoCard[k][0] = random.nextInt(1,16);
            bingoCard[k][1] = random.nextInt(16,31);
            bingoCard[k][2] = random.nextInt(31,46);
            bingoCard[k][3] = random.nextInt(46,61);
            bingoCard[k][4] = random.nextInt(61,76);
            bingoCard[2][2] = 0;
        }

        System.out.println("[B][I][N][G][O]");
        for (int y = 0; y < bingoCard.length; y++){
            for (int x = 0; x < bingoCard[y].length; x++){
                System.out.print("[" + bingoCard[y][x] + "]");
            }
            System.out.println();
        }
    }
}
