public class Main {
    public static void main(String[] args) {
        Personenverwaltung li = new Personenverwaltung();

        li.addPerson(new Person("Philipp", "Gerstl", "24.02.2003", Person.Gender.male, 4131, "Kirchberg ob der Donau", "Seibersdorf", 10));
        li.addPerson(new Person("Selina", "Gerstl", "02.12.2005", Person.Gender.female, 4131, "Kirchberg ob der Donau", "Seibersdorf", 10));

        System.out.println(li.getPersons());
    }
}