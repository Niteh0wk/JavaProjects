import java.util.Scanner;

public class Notendurchschnitt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arraySize;
        int grades;
        double sum = 0;

        System.out.println("How many grades do you want to enter?");
        arraySize = sc.nextInt();
        int[] gradeArray = new int[arraySize];
        for (int x = 0; x < gradeArray.length; x++){
            do {
                System.out.println("Type in your grade(1-5):");
                grades = sc.nextInt();
            }while (grades < 0 || grades > 5);
            gradeArray[x] = grades;
            sum += gradeArray[x];
        }
        double average = sum/arraySize;
        System.out.println("Your average is " + average);
    }
}