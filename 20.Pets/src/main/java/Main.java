public class Main {
    public static void main(String[] args) {
        HouseholdManagementInterface Interface = new HouseholdManagementCSV();

        Interface.createHousehold(new Household(1, "Fam Gerstl"));

        Interface.createPerson(new Person(1, "Philipp", 1), 1);
        Interface.createPerson(new Person(2, "Robert", 1), 1);
        Interface.createPerson(new Person(3, "Ramona", 1), 1);

        Interface.createPet(new Pet(1, "Tassilo",1 ), 1);
        Interface.createPet(new Pet(2, "Striazl",2 ), 2);
        Interface.createPet(new Pet(3, "Snape", 3), 3);

        System.out.println(Interface.getAllHouseholds());
    }
}
