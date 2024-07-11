import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonManagementCSV implements PersonManagementInterface {
    private static final String MANAGEMENTS_CSV = "managements.csv";
    private static final String FULLPERSONS_CSV = "fullPersons.csv";
    private static final String ADVANCEDPERSONS_CSV = "advancedPersons.csv";
    private static final String SIMPLEPERSONS_CSV = "simplePersons.csv";

    public void createPersonManagement(Manager manager) {
        List<String[]> data = readCSV(MANAGEMENTS_CSV);
        data.add(new String[]{String.valueOf(manager.getId()), manager.getName()});
        writeCSV(MANAGEMENTS_CSV, data);
    }

    public void createFullPerson(FullPerson fullPerson, int managerId) {
        List<String[]> data = readCSV(FULLPERSONS_CSV);
        data.add(new String[]{String.valueOf(fullPerson.getId()), fullPerson.getFirstName(), fullPerson.getLastName(), fullPerson.getBirthday(), fullPerson.getGender().toString(), fullPerson.getAddress().toString(), String.valueOf(managerId)});
        writeCSV(FULLPERSONS_CSV, data);
    }

    public void createAdvancedPerson(AdvancedPerson advancedPerson, int managerId) {
        List<String[]> data = readCSV(ADVANCEDPERSONS_CSV);
        data.add(new String[]{String.valueOf(advancedPerson.getId()), advancedPerson.getFirstName(), advancedPerson.getLastName(), advancedPerson.getBirthday(), advancedPerson.getGender().toString(), String.valueOf(managerId)});
        writeCSV(ADVANCEDPERSONS_CSV, data);
    }

    public void createSimplePerson(SimplePerson simplePerson, int managerId) {
        List<String[]> data = readCSV(SIMPLEPERSONS_CSV);
        data.add(new String[]{String.valueOf(simplePerson.getId()), simplePerson.getFirstName(), simplePerson.getLastName(), String.valueOf(managerId)});
        writeCSV(SIMPLEPERSONS_CSV, data);
    }

    /*----*/

    public Manager readManagement(int managerId) {
        List<String[]> data = readCSV(MANAGEMENTS_CSV);
        for (String[] row : data) {
            if (Integer.parseInt(row[0]) == managerId) {
                return new Manager(Integer.parseInt(row[0]), row[1]);
            }
        }
        return null;
    }

    public FullPerson readFullPerson(int personId) {
        List<String[]> data = readCSV(FULLPERSONS_CSV);
        for (String[] row : data) {
            if (Integer.parseInt(row[0]) == personId) {
                return new FullPerson(Integer.parseInt(row[0]), row[1], row[2], row[3], Gender.valueOf(row[4]), new Address(Integer.parseInt(row[5]), row[6], row[7], Integer.parseInt(row[8])));
            }
        }
        return null;
    }

    public AdvancedPerson readAdvancedPerson(int personId) {
        List<String[]> data = readCSV(ADVANCEDPERSONS_CSV);
        for (String[] row : data) {
            if (Integer.parseInt(row[0]) == personId) {
                return new AdvancedPerson(Integer.parseInt(row[0]), row[1], row[2], row[3], Gender.valueOf(row[4]));
            }
        }
        return null;
    }

    public SimplePerson readSimplePerson(int personId) {
        List<String[]> data = readCSV(SIMPLEPERSONS_CSV);
        for (String[] row : data) {
            if (Integer.parseInt(row[0]) == personId) {
                return new SimplePerson(Integer.parseInt(row[0]), row[1], row[2]);
            }
        }
        return null;
    }

    /*----*/

    public void deleteManagement(int managerId) {
        List<String[]> data = readCSV(MANAGEMENTS_CSV);
        data.removeIf(row -> Integer.parseInt(row[0]) == managerId);
        writeCSV(MANAGEMENTS_CSV, data);
    }

    public void deleteFullPerson(int personId) {
        List<String[]> data = readCSV(FULLPERSONS_CSV);
        data.removeIf(row -> Integer.parseInt(row[0]) == personId);
        writeCSV(FULLPERSONS_CSV, data);
    }

    public void deleteAdvancedPerson(int personId) {
        List<String[]> data = readCSV(ADVANCEDPERSONS_CSV);
        data.removeIf(row -> Integer.parseInt(row[0]) == personId);
        writeCSV(ADVANCEDPERSONS_CSV, data);
    }

    public void deleteSimplePerson(int personId) {
        List<String[]> data = readCSV(SIMPLEPERSONS_CSV);
        data.removeIf(row -> Integer.parseInt(row[0]) == personId);
        writeCSV(SIMPLEPERSONS_CSV, data);
    }

    /*----*/

    public List<Manager> getAllManagements() {
        List<String[]> data = readCSV(MANAGEMENTS_CSV);
        List<Manager> managers = new ArrayList<>();
        for (String[] row : data) {
            managers.add(new Manager(Integer.parseInt(row[0]), row[1]));
        }
        return managers;
    }

    public List<FullPerson> getAllFullPersons() {
        List<String[]> data = readCSV(FULLPERSONS_CSV);
        List<FullPerson> fullPersons = new ArrayList<>();
        for (String[] row : data) {
            fullPersons.add(new FullPerson(Integer.parseInt(row[0]), row[1], row[2], row[3], Gender.valueOf(row[4]), new Address(Integer.parseInt(row[5]), row[6], row[7], Integer.parseInt(row[8]))));
        }
        return  fullPersons;
    }

    public List<AdvancedPerson> getAllAdvancedPersons() {
        List<String[]> data = readCSV(ADVANCEDPERSONS_CSV);
        List<AdvancedPerson> advancedPersons = new ArrayList<>();
        for (String[] row : data) {
            advancedPersons.add(new AdvancedPerson(Integer.parseInt(row[0]), row[1], row[2], row[3], Gender.valueOf(row[4])));
        }
        return advancedPersons;
    }

    public List<SimplePerson> getAllSimplePersons() {
        List<String[]> data = readCSV(SIMPLEPERSONS_CSV);
        List<SimplePerson> simplePersons = new ArrayList<>();
        for (String[] row : data) {
            simplePersons.add(new SimplePerson(Integer.parseInt(row[0]), row[1], row[2]));
        }
        return simplePersons;
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
