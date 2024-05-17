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
        System.out.println("5. Remove a specific person");
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
        address.setCity(sc.nextLine());

        System.out.print("Street:");
        address.setStreet(sc.nextLine());

        System.out.print("House Number:");
        address.setHouseNumber(sc.nextInt());
        PMLinz.createFullPerson(firstName, lastName, birthday, gender, address.getPlz(), address.getCity(), address.getStreet(), address.getHouseNumber());
        System.out.println("|Person Created|");
    }

    public void createAdvanced() {
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

    public void getPerson(){
        System.out.print("First Name:");
        firstName = sc.next();

        System.out.print("Last Name:");
        lastName = sc.next();

        PMLinz.getPerson();
    }

    public void removePerson() {
        System.out.println("Who do you want to remove?");
        System.out.print("First Name:");
        firstName = sc.next();
        System.out.print("Last Name:");
        lastName = sc.next();

        PMLinz.removePerson(firstName, lastName);
        System.out.println("|Person Removed|");
    }
}
