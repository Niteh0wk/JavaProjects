import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UI {
    PersonManager PMLinz = new PersonManager();

    public void menu() {
        System.out.println("Person Manager Linz");
        System.out.println("What do you want to do?");
        System.out.println("1. Create a simple Person");
        System.out.println("2. Create a advanced Person");
        System.out.println("3. Create a full person");
        System.out.println("4. List all Persons");
        System.out.println("5. Get specific Person");
        System.out.println("6. Remove Person");
        System.out.println("Type X to exit");
    }

    Scanner sc = new Scanner(System.in);
    String firstName;
    String lastName;
    String birthday;
    Address address;
    Gender gender;
    String genderChooser;
    boolean genderCONTINUE = false;

    public void createFull() {

        System.out.print("First Name:");
        firstName = sc.next();

        System.out.print("Last Name:");
        lastName = sc.next();

        System.out.print("Birthday:");
        birthday = sc.next();

        System.out.print("Gender(M,F,D):");
        genderChooser = sc.next().toUpperCase();
        try {
            gender = Gender.valueOf(genderChooser);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Gender: " + genderChooser);
        }

        address = new Address();

        System.out.print("Postal Code:");
        address.setPlz(sc.nextInt());
        sc.nextLine();

        System.out.print("City:");
        try {
            address.setCity(sc.nextLine());
        }catch (InvalidPersonName e){
            System.out.println(e.getMessage());
        }

        System.out.print("Street:");
        try {
            address.setStreet(sc.nextLine());
        }catch (InvalidPersonName e){
            System.out.println(e.getMessage());
        }


        System.out.print("House Number:");
        address.setHouseNumber(sc.nextInt());
        PMLinz.createFullPerson(firstName, lastName, birthday, gender, address.getPlz(), address.getCity(), address.getStreet(), address.getHouseNumber());
        System.out.println("|Person Created|");
    }

    public void createAdvanced() {
        int checker = 0;
        System.out.print("First Name:");
        firstName = sc.next();

        System.out.print("Last Name:");
        lastName = sc.next();

        System.out.print("Birthday:");
        birthday = sc.next();

        System.out.print("Gender(M,F,D):");

        genderChooser = sc.next().toUpperCase();
        try {
            gender = Gender.valueOf(genderChooser);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Gender: " + genderChooser);

        }

        PMLinz.createAdvancedPerson(firstName, lastName, birthday, gender);
        System.out.println("|Person Created|");
    }

    public void createSimple() {
        System.out.print("First Name:");
        firstName = sc.next();

        System.out.print("Last Name:");
        lastName = sc.next();

        PMLinz.createSimplePerson(firstName, lastName);
        System.out.println("|Person Created|");
    }

    public void listPersons() {
        PMLinz.listPersons();
    }

    public void getPerson() {
        System.out.print("First Name:");
        lastName = sc.next();

        try {
            Person p = PMLinz.findPerson(lastName);
            System.out.println(p);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removePerson() {
        System.out.println("Who do you want to remove?");
        System.out.print("First Name:");
        firstName = sc.next();
        System.out.print("Last Name:");
        lastName = sc.next();

        try {
            PMLinz.removePerson(firstName, lastName);
            System.out.println("|Person Removed|");
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

    }
}
