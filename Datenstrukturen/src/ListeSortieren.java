import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ListeSortieren {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int arrayListLength;
        System.out.println("How many numbers should be sorted?");
        arrayListLength = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for (int x = 0; x < arrayListLength; x++){
            list.add(r.nextInt(101));
        }
        insertionSort(list);

        System.out.println("Sorted: " + list);
    }

    public static void insertionSort(ArrayList<Integer> sorted) {
       for (int i = 1; i < sorted.size(); i++){
           int current = sorted.remove(i);
           int index = i - 1;
           while (index >= 0 && current < sorted.get(index))
               index--;
           sorted.add(index+1, current);
       }
    }
}
