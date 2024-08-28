import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonManager implements ManagementInterface <Person>{
    public void create(Person person){
        String createPersonString = "INSERT INTO PERSON (ID, NAME, HOUSEHOLDID) values (?,?,?)";
        try (PreparedStatement createPersonStmt = DBConnector.getInstance().prepareStatement(createPersonString)) {
            createPersonStmt.setInt(1, person.getId());
            createPersonStmt.setString(2, person.getName());
            createPersonStmt.setInt(3, person.getHouseholdId());

            createPersonStmt.executeUpdate();

            System.out.println("Person created Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void read(int personID) {
        String readHouseholdString = "SELECT NAME FROM PERSON WHERE ID = ?";
        try (PreparedStatement readPersonStmt = DBConnector.getInstance().prepareStatement(readHouseholdString)) {
            readPersonStmt.setInt(1, personID);

            try (ResultSet resultSet = readPersonStmt.executeQuery()){
                if (resultSet.next()) {
                    String name = resultSet.getString("Name");
                    System.out.println("Name: " + name);
                } else {
                    System.out.println("No entry found with ID: " + personID);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int personID, String values) {
        String updateString = "update PERSON set NAME = ? where ID = ?";
        try (PreparedStatement updatePerson = DBConnector.getInstance().prepareStatement(updateString)) {
            updatePerson.setString(2, values);
            updatePerson.setInt(1, personID);

            updatePerson.executeUpdate();

            System.out.println("Person updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int personID) {

    }
}
