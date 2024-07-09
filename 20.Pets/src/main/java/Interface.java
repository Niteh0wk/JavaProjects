import java.util.List;

public interface Interface {
    void createHousehold(Household household);
    void createPerson(Person person);
    void createPet(Pet pet, int personId);

    Household readHousehold(int householdId);
    Person readPerson(int personId);
    Pet readPet(int petId);

    void updateHousehold(int householdId, Household values);
    void updatePerson(int personId, Person values);
    void updatePet(int petId, Pet values);

    void deleteHousehold(int householdId);
    void deletePerson(int personId);
    void deletePet(int petId);

    List<Household> getAllHouseholds();
}