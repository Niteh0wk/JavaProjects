import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int arrayLenght;
        System.out.println("How many numbers should be sorted?");
        arrayLenght = sc.nextInt();
        int[] arr = new int[arrayLenght];

        for (int x = 0; x < arr.length; x++){
            arr[x] = r.nextInt(101);
        }

        System.out.println("Unsorted: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));
    }
        static void insertionSort(int[] sorted)
        {
            int n = sorted.length;
            for (int i = 1; i < n; ++i) {
                int key = sorted[i];
                int j = i - 1;

                while (j >= 0 && sorted[j] > key) {
                    sorted[j + 1] = sorted[j];
                    j = j - 1;
                }
                sorted[j + 1] = key;
            }
        }


}

