import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InsertionBubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int arrayLength;
        System.out.println("How many numbers should be sorted?");
        arrayLength = sc.nextInt();
        int[] arr = new int[arrayLength];

        for (int x = 0; x < arr.length; x++) {
            arr[x] = r.nextInt(101);
        }
        int bubbleOrInsertion;
        do {
            System.out.println("Bubble or Insertion Sort?(1 or 2)");
            bubbleOrInsertion = sc.nextInt();
        }while (bubbleOrInsertion <= 0 || bubbleOrInsertion >= 3);


        System.out.println("Unsorted: " + Arrays.toString(arr));
        if (bubbleOrInsertion == 1){
            insertionSort(arr);
        }else if (bubbleOrInsertion == 2){
            bubbleSort(arr, arrayLength);
        }

        System.out.println("Sorted: " + Arrays.toString(arr));
    }

    static void insertionSort(int[] sorted) {
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
    static void bubbleSort(int A[ ], int n ) {
        int temp;
        for(int k = 0; k< n-1; k++) {

            for(int i = 0; i < n-k-1; i++) {
                if(A[ i ] > A[ i+1] ) {
                    temp = A[ i ];
                    A[ i ] = A[ i+1 ];
                    A[ i + 1] = temp;
                }
            }
        }
    }

}

