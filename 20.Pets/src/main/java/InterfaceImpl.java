import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InterfaceImpl implements Interface {
    private static final String HOUSEHOLDS_CSV = "households.csv";
    private static final String PERSONS_CSV = "persons.csv";
    private static final String PETS_CSV = "pets.csv";

    public void createHousehold(Household household) {
        
    }

    public void createPerson(Person person) {

    }

    public void createPet(Pet pet, int personId) {

    }

    public Household readHousehold(int householdId) {

    }

    public Person readPerson(int personId) {

    }

    public Pet readPet(int petId) {

    }

    public void updateHousehold(int householdId, Household values) {

    }

    public void updatePerson(int personId, Person values) {

    }

    public void updatePet(int petId, Pet values) {

    }

    public void deleteHousehold(int householdId) {

    }

    public void deletePerson(int personId) {

    }

    public void deletePet(int petId) {

    }

    public List<Household> getAllHouseholds() {

    }
}
