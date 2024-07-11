public class Main {
    public static void main(String[] args) {
        PersonManager PMLinz = new PersonManager();

        PMLinz.createFullPerson("Philipp", "Gerstl", "24.02.2003", Gender.male, 4131, "Kirchberg ob der Donau", "Seibersdorf", 10);
        PMLinz.createFullPerson("Ramona", "Gerstl", "07.12.1985", Gender.female, 4131, "Kirchberg ob der Donau", "Seibersdorf", 10);
        PMLinz.createAdvancedPerson("Robert", "Öttl","13.03.1974",Gender.male);
        PMLinz.createSimplePerson("Albert", "Rubrecht");


        PMLinz.personList();


        System.out.println("\n");


        PersonManager PMWels = new PersonManager();

        PMWels.createSimplePerson("Franz", "Schindl");
        PMWels.createAdvancedPerson("Alex","Musterman","01.01.2000",Gender.male);
        PMWels.createFullPerson("Max","Musterman","24.12.2005",Gender.male,4040,"Linz","Harucker Straße",12);

        PMWels.personList();
    }
}