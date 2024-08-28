import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PetManager implements ManagementInterface <Pet>{
    public void create(Pet pet){
        String createPetString = "INSERT INTO PET (ID, NAME, PERSONID) values (?,?,?)";
        try (PreparedStatement createPetStmt = DBConnector.getInstance().prepareStatement(createPetString)) {
            createPetStmt.setInt(1, pet.getId());
            createPetStmt.setString(2, pet.getName());
            createPetStmt.setInt(3, pet.getPersonId());

            createPetStmt.executeUpdate();

            System.out.println("Pet created Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void read(int petID) {
        String readHouseholdString = "SELECT NAME FROM PET WHERE ID = ?";
        try (PreparedStatement readPetStmt = DBConnector.getInstance().prepareStatement(readHouseholdString)) {
            readPetStmt.setInt(1, petID);

            try (ResultSet resultSet = readPetStmt.executeQuery()){
                if (resultSet.next()) {
                    String name = resultSet.getString("Name");
                    System.out.println("Name: " + name);
                } else {
                    System.out.println("No entry found with ID: " + petID);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int petID, String values) {
        String updateString = "update PET set NAME = ? where ID = ?";
        try (PreparedStatement updatePet = DBConnector.getInstance().prepareStatement(updateString)) {
            updatePet.setString(2, values);
            updatePet.setInt(1, petID);

            updatePet.executeUpdate();

            System.out.println("Pet updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int petID) {

    }
}
