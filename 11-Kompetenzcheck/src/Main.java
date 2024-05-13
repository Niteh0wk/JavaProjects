public class Main {
    public static void main(String[] args) {
        Personenverwaltung PVLinz = new Personenverwaltung();

        PVLinz.createFullPerson("Philipp", "Gerstl", "24.02.2003", Person.Gender.male, 4131, "Kirchberg ob der Donau", "Seibersdorf", 10);
        PVLinz.createFullPerson("Selina", "Gerstl", "02.12.2005", Person.Gender.female, 4131, "Kirchberg ob der Donau", "Seibersdorf", 10);
        PVLinz.createSimplePerson("Geralt", "Riva");

        System.out.println(PVLinz.getPersons());

        Personenverwaltung PVCodersbay = new Personenverwaltung();

        PVCodersbay.createAdvancedPerson("George", "Washington", "01.01.1999", Person.Gender.male);
        PVCodersbay.createSimplePerson("Barack", "Obama");

        System.out.println(PVCodersbay.getPersons());
    }
}