import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HouseholdManagementCSV implements HouseholdManagementInterface {
    private static final String HOUSEHOLDS_CSV = "households.csv";
    private static final String PERSONS_CSV = "persons.csv";
    private static final String PETS_CSV = "pets.csv";

    public void createHousehold(Household household) {
        List<String[]> data = readCSV(HOUSEHOLDS_CSV);
        data.add(new String[]{String.valueOf(household.getId()), household.getName()});
        writeCSV(HOUSEHOLDS_CSV, data);
    }

    public void createPerson(Person person, int householdId) {
        List<String[]> data = readCSV(PERSONS_CSV);
        data.add(new String[]{String.valueOf(person.getId()), person.getName(), String.valueOf(householdId)});
        writeCSV(PERSONS_CSV, data);
    }

    public void createPet(Pet pet, int personId) {
        List<String[]> data = readCSV(PETS_CSV);
        data.add(new String[]{String.valueOf(pet.getId()), pet.getName(), String.valueOf(personId)});
        writeCSV(PETS_CSV, data);
    }

    /*----*/

    public Household readHousehold(int householdId) {
        List<String[]> data = readCSV(HOUSEHOLDS_CSV);
        for (String[] row : data) {
            if (Integer.parseInt(row[0]) == householdId) {
                return new Household(Integer.parseInt(row[0]), row[1]);
            }
        }
        return null;
    }

    public Person readPerson(int personId) {
        List<String[]> data = readCSV(PERSONS_CSV);
        for (String[] row : data) {
            if (Integer.parseInt(row[0]) == personId) {
                return new Person(Integer.parseInt(row[0]), row[1], Integer.parseInt(row[2]));
            }
        }
        return null;
    }

    public Pet readPet(int petId) {
        List<String[]> data = readCSV(PETS_CSV);
        for (String[] row : data) {
            if (Integer.parseInt(row[0]) == petId) {
                return new Pet(Integer.parseInt(row[0]), row[1], Integer.parseInt(row[2]));
            }
        }
        return null;
    }

    /*----*/

    public void updateHousehold(int householdId, Household values) {
        List<String[]> data = readCSV(HOUSEHOLDS_CSV);
        for (String[] row : data) {
            if (Integer.parseInt(row[0]) == householdId) {
                row[1] = values.getName();
                break;
            }
        }
        writeCSV(HOUSEHOLDS_CSV, data);
    }

    public void updatePerson(int personId, Person values) {
        List<String[]> data = readCSV(PERSONS_CSV);
        for (String[] row : data) {
            if (Integer.parseInt(row[0]) == personId) {
                row[1] = values.getName();
                row[2] = String.valueOf(values.getHouseholdId());
                break;
            }
        }
        writeCSV(PERSONS_CSV, data);
    }

    public void updatePet(int petId, Pet values) {
        List<String[]> data = readCSV(PETS_CSV);
        for (String[] row : data) {
            if (Integer.parseInt(row[0]) == petId) {
                row[1] = values.getName();
                row[2] = String.valueOf(values.getPersonId());
                break;
            }
        }
        writeCSV(PETS_CSV, data);
    }

    /*----*/

    public void deleteHousehold(int householdId) {
        List<String[]> data = readCSV(HOUSEHOLDS_CSV);
        data.removeIf(row -> Integer.parseInt(row[0]) == householdId);
        writeCSV(HOUSEHOLDS_CSV, data);
    }

    public void deletePerson(int personId) {
        List<String[]> data = readCSV(PERSONS_CSV);
        data.removeIf(row -> Integer.parseInt(row[0]) == personId);
        writeCSV(PERSONS_CSV, data);
    }

    public void deletePet(int petId) {
        List<String[]> data = readCSV(PETS_CSV);
        data.removeIf(row -> Integer.parseInt(row[0]) == petId);
        writeCSV(PETS_CSV, data);
    }

    /*----*/

    public List<Household> getAllHouseholds() {
        List<String[]> data = readCSV(HOUSEHOLDS_CSV);
        List<Household> households = new ArrayList<>();
        for (String[] row : data) {
            households.add(new Household(Integer.parseInt(row[0]), row[1]));
        }
        return households;
    }

    /*----*/

    private List<String[]> readCSV(String filepath) {
        try {
            return CSVUtils.readCSV(filepath);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void writeCSV(String filepath, List<String[]> data) {
        try {
            CSVUtils.writeCSV(filepath, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
