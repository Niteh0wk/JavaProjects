public class Main {
    public static void main(String[] args) {
        PersonManager PMLinz = new PersonManager();

        PMLinz.createFullPerson("Philipp", "Gerstl", "24.02.2003", Gender.male, 4131, "Kirchberg ob der Donau", "Seibersdorf", 10);
        PMLinz.createFullPerson("Ramona", "Gerstl", "07.12.1985", Gender.female, 4131, "Kirchberg ob der Donau", "Seibersdorf", 10);
        PMLinz.createSimplePerson("Albert", "Rubrecht");

        PMLinz.getPerson(1);
        PMLinz.getPerson(2);
        PMLinz.removePerson(2);
        PMLinz.getPerson(2);

        PMLinz.personList();


        PersonManager PMWels = new PersonManager();

        PMWels.createSimplePerson("Franz", "Schindl");



    }
}