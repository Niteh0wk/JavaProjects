import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        PersonManagementInterface personInterface = new PersonManagementCSV();
        boolean stopProgram = false;
        Scanner sc = new Scanner(System.in);
        int selector;


        System.out.println("Welcome to the Person Management Program");
        do {
            System.out.println("What do you want to do?");
            System.out.println("1. Create Menu");
            System.out.println("2. Delete Menu");
            System.out.println("3. List Menu");
            System.out.println("0. Exit");
            selector = sc.nextInt();


            if (selector == 1) {
                System.out.println("1. Create Person Management");
                System.out.println("2. Create Full Person");
                System.out.println("3. Create Advanced Person");
                System.out.println("4. Create Simple Person");
                selector = sc.nextInt();

                if (selector == 1) {
                    int id;
                    String name;
                    Manager manager;

                    System.out.println("Type in the id:");
                    id = sc.nextInt();
                    System.out.println("Type in the name:");
                    name = sc.next();
                    manager = new Manager(id, name);
                    personInterface.createPersonManagement(manager);
                }

                if (selector == 2) {
                    String firstName;
                    String lastName;
                    String birthday;
                    Gender gender;
                    Address address;
                    int plz;
                    String city;
                    String street;
                    int houseNumber;

                    int id;
                    int managerId;

                    System.out.println("ID:");
                    id = sc.nextInt();
                    System.out.println("Type in first name:");
                    firstName = sc.next();
                    System.out.println("Type in last name:");
                    lastName = sc.next();
                    System.out.println("Type in birthday(e.g. 01.01.1980):");
                    birthday = sc.next();
                    System.out.println("Type in gender(male, female, diverse):");
                    gender = Gender.valueOf(sc.next());
                    System.out.println("Type in your Adress:");
                    System.out.println("PLZ:");
                    plz = sc.nextInt();
                    System.out.println("City:");
                    city = sc.next();
                    System.out.println("Street:");
                    street = sc.next();
                    System.out.println("Housenumber:");
                    houseNumber = sc.nextInt();
                    System.out.println("Type in the ManagementID:");
                    managerId = sc.nextInt();
                    address = new Address(plz, city, street, houseNumber);

                    personInterface.createFullPerson(new FullPerson(id, firstName, lastName, birthday, gender, address),managerId);
                }

                if (selector == 3) {
                    String firstName;
                    String lastName;
                    String birthday;
                    Gender gender;

                    int id;
                    int managerId;

                    System.out.println("ID:");
                    id = sc.nextInt();
                    System.out.println("Type in first name:");
                    firstName = sc.next();
                    System.out.println("Type in last name:");
                    lastName = sc.next();
                    System.out.println("Type in birthday(e.g. 01.01.1980):");
                    birthday = sc.next();
                    System.out.println("Type in gender(male, female, diverse):");
                    gender = Gender.valueOf(sc.next());

                    System.out.println("Type in the ManagementID:");
                    managerId = sc.nextInt();

                    personInterface.createAdvancedPerson(new AdvancedPerson(id, firstName, lastName, birthday, gender),managerId);
                }

                if (selector == 4) {
                    String firstName;
                    String lastName;

                    int id;
                    int managerId;

                    System.out.println("ID:");
                    id = sc.nextInt();
                    System.out.println("Type in first name:");
                    firstName = sc.next();
                    System.out.println("Type in last name:");
                    lastName = sc.next();

                    System.out.println("Type in the ManagementID:");
                    managerId = sc.nextInt();

                    personInterface.createSimplePerson(new SimplePerson(id, firstName, lastName),managerId);
                }
            }

            if (selector == 2) {
                int managerId;
                int personId;

                System.out.println("1. Delete Person Management");
                System.out.println("2. Delete Full Person");
                System.out.println("3. Delete Advanced Person");
                System.out.println("4. Delete Simple Person");
                selector = sc.nextInt();

                if (selector == 1) {
                    System.out.println("Type in the ManagementID:");
                    managerId = sc.nextInt();
                    personInterface.deleteManagement(managerId);
                }

                if (selector == 2) {
                    System.out.println("Type in the PersonID:");
                    personId = sc.nextInt();
                    personInterface.deleteFullPerson(personId);
                }

                if (selector == 3) {
                    System.out.println("Type in the PersonID:");
                    personId = sc.nextInt();
                    personInterface.deleteAdvancedPerson(personId);
                }

                if (selector == 4) {
                    System.out.println("Type in the PersonID:");
                    personId = sc.nextInt();
                    personInterface.deleteSimplePerson(personId);
                }
            }

            if (selector == 3) {
                System.out.println("1. List all Managements");
                System.out.println("2. List all Full Persons");
                System.out.println("3. List all Advanced Persons");
                System.out.println("4. List all Simple Persons");
                selector = sc.nextInt();

                if (selector == 1) {
                    System.out.println(personInterface.getAllManagements());
                }

                if (selector == 2) {
                    System.out.println(personInterface.getAllFullPersons());
                }

                if (selector == 3) {
                    System.out.println(personInterface.getAllAdvancedPersons());
                }

                if (selector == 4) {
                    System.out.println(personInterface.getAllSimplePersons());
                }
            }

            if (selector == 0) {
                stopProgram = true;
            }

        } while (!stopProgram);
    }
}