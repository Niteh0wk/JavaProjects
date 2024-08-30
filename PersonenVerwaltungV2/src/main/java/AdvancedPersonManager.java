import com.mysql.cj.jdbc.result.UpdatableResultSet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdvancedPersonManager implements PersonInterface <AdvancedPerson>{

    public void createPerson(AdvancedPerson advancedPerson, int managerID) {
        String createAdvancedString = "insert into advancedperson (first_name, last_name, birthday, gender, id, managerid) values (?,?,?,?,?,?)";
        try (PreparedStatement createAdvancedStmt = DBConnector.getInstance().prepareStatement(createAdvancedString)) {
            createAdvancedStmt.setString(1, advancedPerson.getFirstName());
            createAdvancedStmt.setString(2, advancedPerson.getLastName());
            createAdvancedStmt.setString(3, advancedPerson.getBirthday());
            createAdvancedStmt.setString(4, advancedPerson.getGender().toString());
            createAdvancedStmt.setInt(5, advancedPerson.getId());
            createAdvancedStmt.setInt(6, managerID);

            createAdvancedStmt.executeUpdate();

            System.out.println("Advanced Person created!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void read(int personID) {
        String readAdvancedString = "select first_name, last_name from advancedperson where id = ?";
        try (PreparedStatement readAdvancedStmt = DBConnector.getInstance().prepareStatement(readAdvancedString)) {
            readAdvancedStmt.setInt(1, personID);

            try (ResultSet resultSet = readAdvancedStmt.executeQuery()) {
                if (resultSet.next()) {
                    String first_name = resultSet.getString("first_name");
                    String last_name = resultSet.getString("last_name");

                    System.out.println("Advanced Name: " + first_name + " " + last_name);
                } else {
                    System.out.println("No entry found with ID: " + personID);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //TODO -> Find out how/what to update exactly in the database

    public void updatePerson(int personID, String values) {

    }

    public void deletePerson(int personID) {
        String deleteAdvancedString = "delete from Advancedperson where id = ?";
        try (PreparedStatement deleteAdvanced = DBConnector.getInstance().prepareStatement(deleteAdvancedString)) {
            deleteAdvanced.setInt(1, personID);

            int rowsAffected = deleteAdvanced.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Deleted " + rowsAffected + " row(s) from the database.");
            } else {
                System.out.println("No rows found with the specified ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<AdvancedPerson> getAllPersons() {
        List<AdvancedPerson> advancedPeople = new ArrayList<>();
        String selectAdvancedPersons = "select first_name, last_name from advancedperson";

        try (PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(selectAdvancedPersons)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String birthday = resultSet.getString("birthday");
                Gender gender = Gender.valueOf(resultSet.getString("gender"));
                int id = resultSet.getInt("id");
                int managerid = resultSet.getInt("managerid");

                AdvancedPerson advancedPerson = new AdvancedPerson(id, first_name,last_name,birthday,gender);
                advancedPeople.add(advancedPerson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return advancedPeople;
    }
}
