import java.util.Scanner;

public class AboutYourself {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name;
        int age;
        String gender;
        String birthday;
        int averageGrade;
        boolean married;
        String line = "-";

        System.out.println("What is your name?");
        name = sc.next();
        System.out.println("How old are you?");
        age = sc.nextInt();
        System.out.println("What is your gender?(male,female,diverse)");
        gender = sc.next();
        System.out.println("When is your birthday?(e.g.:01.01.2000)");
        birthday = sc.next();
        System.out.println("What is your average Grade in school?(1-5)");
        averageGrade = sc.nextInt();
        System.out.println("Are you married?(true/false)");
        married = sc.nextBoolean();

        System.out.println(line.repeat(25));
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Birthday: " + birthday);
        System.out.println("Average Grade: " + averageGrade);
        System.out.println("Married: " + married);
    }
}
