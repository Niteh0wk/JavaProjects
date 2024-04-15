import java.util.Scanner;

public class Notendurchschnitt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arraySize;
        int grades;
        int average = 0;

        System.out.println("How many grades do you want to enter?");
        arraySize = sc.nextInt();
        int[] gradeArray = new int[arraySize];
        for (int x = 0; x < gradeArray.length; x++){
            System.out.println("Type in your grade(1-5):");
            grades = sc.nextInt();
            gradeArray[x] = grades;
            average += gradeArray[x];
        }
        average = average/arraySize;
        System.out.println("Your average is " + average);
    }
}