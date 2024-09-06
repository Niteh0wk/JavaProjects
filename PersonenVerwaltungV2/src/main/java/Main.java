import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 10;

        PersonDBMethods personDBMethods = new PersonDBMethods();
        AddressDBMethods addressDBMethods = new AddressDBMethods();
        ManagementDBMethods managementDBMethods = new ManagementDBMethods();

        managementDBMethods.createManagement(new Management(1, "PMLINZ"));
        addressDBMethods.insertAddressIntoDB(new Address(1,4131,"Kirchberg ob der Donau", "Seibersdorf", 10));
        personDBMethods.insertPersonIntoDB(new Person("Philipp", "Gerstl", 1,1));
        personDBMethods.insertPersonIntoDB(new Person("Selina", "Gerstl", "2005-12-02", Gender.female,2,1));
        personDBMethods.insertPersonIntoDB(new Person("Leonie", "Gerstl", "2005-12-02", Gender.female,1,3,1));

        while (input != 0) {
            System.out.println("Press: 1 to update| 2 to read| 3 to delete| 0 to exit");
            input = sc.nextInt();
            if (input == 1) {
                managementDBMethods.updateManager(1,"PMRohrbach");
                addressDBMethods.updateAddress(new Address(1,4131,"Kirchberg ob der Donau", "Seibersdorf", 11));
                personDBMethods.updatePerson(new Person("Martin", "Gerstl", 1,1));
                personDBMethods.updatePerson(new Person("Ramona", "Gerstl", "1985-12-07", Gender.female,2,1));
                personDBMethods.updatePerson(new Person("Robert", "Öttl", "1974-03-13", Gender.male,1,3,1));
            } else if (input == 2) {
                managementDBMethods.readManager(1);
                System.out.println(addressDBMethods.readAddress(1).toString());
                System.out.println(personDBMethods.readPerson(1));
                System.out.println(personDBMethods.readPerson(2));
                System.out.println(personDBMethods.readPerson(3));
            } else if (input == 3) {
                managementDBMethods.deleteManager(1);
                addressDBMethods.deleteAddress(1);
            }
        }
    }
}
