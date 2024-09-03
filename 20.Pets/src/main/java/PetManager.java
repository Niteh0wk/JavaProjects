import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
                    System.out.println("Pet Name: " + name);
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
            updatePet.setString(1, values);
            updatePet.setInt(2, petID);

            updatePet.executeUpdate();

            System.out.println("Pet updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int petID) {
        String deleteString = "delete from PET where id = ?";
        try (PreparedStatement deletePet = DBConnector.getInstance().prepareStatement(deleteString)) {
            deletePet.setInt(1, petID);

            int rowsAffected = deletePet.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Deleted " + rowsAffected + " row(s) from the database.");
            } else {
                System.out.println("No rows found with the specified ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
