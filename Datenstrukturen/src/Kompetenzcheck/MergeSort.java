package Kompetenzcheck;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("How many number do you want to be sorted?");
        int listLength = sc.nextInt();

        int[] list = new int[listLength];

        for (int x = 0; x < listLength; x++){
                list[x] = (r.nextInt(1,101));
        }
        System.out.println(Arrays.toString(list));

        mergeSort(list, listLength);

        System.out.println(Arrays.toString(list));
    }

    public static void mergeSort(int[] a, int n){
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++){
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++){
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n-mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right){
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left && j < right){
            if (l[i] <= r[j]){
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left){
            a[k++] = l[i++];
        }
        while (j < right){
            a[k++] = r[j++];
        }

    }
}
