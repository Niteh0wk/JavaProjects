import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HouseholdManager implements ManagementInterface <Household>{
    public void create(Household household){
        String createHouseholdString = "INSERT INTO HOUSEHOLD (ID,NAME) values (?,?)";
        try(PreparedStatement createHouseholdStmt = DBConnector.getInstance().prepareStatement(createHouseholdString)) {
            createHouseholdStmt.setInt(1, household.getId());
            createHouseholdStmt.setString(2, household.getName());

            createHouseholdStmt.executeUpdate();

            System.out.println("Household created Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void read(int managerID) {
        String readHouseholdString = "SELECT NAME FROM HOUSEHOLD WHERE ID = ?";
        try (PreparedStatement readHouseholdStmt = DBConnector.getInstance().prepareStatement(readHouseholdString)) {
            readHouseholdStmt.setInt(1, managerID);

            try (ResultSet resultSet = readHouseholdStmt.executeQuery()){
                if (resultSet.next()) {
                    String name = resultSet.getString("Name");
                    System.out.println("Household Name: " + name);
                } else {
                    System.out.println("No entry found with ID: " + managerID);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int householdID, String values) {
        String updateString = "update HOUSEHOLD set NAME = ? where ID = ?";
        try (PreparedStatement updateHousehold = DBConnector.getInstance().prepareStatement(updateString)) {
            updateHousehold.setString(1, values);
            updateHousehold.setInt(2, householdID);

            updateHousehold.executeUpdate();

            System.out.println("Household updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int householdID) {
        String deleteString = "delete from HOUSEHOLD where id = ?";
        try (PreparedStatement deleteHousehold = DBConnector.getInstance().prepareStatement(deleteString)) {
            deleteHousehold.setInt(1, householdID);

            int rowsAffected = deleteHousehold.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Deleted " + rowsAffected + " row(s) from the database.");
            } else {
                System.out.println("No rows found with the specified ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //TODO -> when getting all houshold make it so it prints out all people with their pets that live in this household
    // make 4 methods the first methods executes the other three to print out all households,people and pets
    // use select statements and the different id's to make it happen

    public List<Household> getAllHouseholds() {
        List<Household> households = new ArrayList<>();
        String selectHouseholds = "Select ID, Name from Household";

        try (PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(selectHouseholds);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int householdid = resultSet.getInt("id");
                String name = resultSet.getString("name");

                Household household = new Household(householdid, name);
                households.add(household);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return households;
    }
}
