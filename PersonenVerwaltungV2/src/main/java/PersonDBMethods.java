import java.sql.*;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class PersonDBMethods implements PersonManagerInterface {

    public void insertPersonIntoDB(Person person) {
        StringBuilder insertPerson = new StringBuilder("INSERT INTO PERSON (FIRST_NAME, LAST_NAME, ID, MANAGERID");
        StringBuilder values = new StringBuilder("VALUES (?, ?, ?, ?");
        List<Object> parameters = new ArrayList<>();

        parameters.add(person.getFirstName());
        parameters.add(person.getLastName());
        parameters.add(person.getId());
        parameters.add(person.getManagerid());

        if (person.getBirthday() != null) {
            try {
                insertPerson.append(", BIRTHDAY");
                values.append(", ?");
                parameters.add(person.getBirthday());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format for birthday: " + person.getBirthday());
                return;
            }
        }

        if (person.getAddress_id() != 0) {
            insertPerson.append(", ADDRESSID");
            values.append(", ?");
            parameters.add(person.getAddress_id());
        }

        if (person.getGender() != null) {
            insertPerson.append(", GENDER");
            values.append(", ?");
            parameters.add(person.getGender().toString());
        }

        insertPerson.append(") ");
        values.append(")");
        String sql = insertPerson.append(values).toString();

        /*System.out.println("Executing SQL: " + sql);*/

        try (PreparedStatement ps = DBConnector.getInstance().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < parameters.size(); i++) {
                ps.setObject(i + 1, parameters.get(i));
            }

            ps.executeUpdate();
            System.out.println("Person created successfully");
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    public Person readPerson(int person_id) {
        Person person;
        try (PreparedStatement ps = DBConnector.getInstance().prepareStatement("SELECT * FROM PERSON WHERE ID = ?")) {
            ps.setInt(1, person_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                String genderString = rs.getString("GENDER");
                Gender gender = null;
                if (genderString != null) {
                    gender = Gender.valueOf(rs.getString("GENDER"));
                }

                String birthday = rs.getString("BIRTHDAY");
                int address_id = rs.getInt("ADDRESSID");
                int id = rs.getInt("ID");
                int manager_id = rs.getInt("MANAGERID");
                person = new Person(firstName, lastName, birthday, gender, address_id, id, manager_id);
            } else {
                System.err.println("No Person found with the given ID");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return person;
    }

    public void updatePerson(Person person) {
        try (PreparedStatement ps = DBConnector.getInstance().prepareStatement("UPDATE PERSON SET first_name = ?, LAST_NAME = ?, GENDER = ?, BIRTHDAY = ?, ADDRESSID = ? WHERE ID = ?")) {
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            if (person.getGender() != null) {
                ps.setObject(3, person.getGender().toString());
            } else {
                ps.setNull(3, Types.VARCHAR);
            }
            ps.setObject(4, person.getBirthday());
            if (person.getAddress_id() == 0) {
                ps.setNull(5, Types.INTEGER);
            } else {
                ps.setInt(5, person.getAddress_id());
            }

            ps.setInt(6, person.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Fehler bei der Datenbankabfrage");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Person deletePerson(int person_id) {
        Person deletedPerson = readPerson(person_id);
        try (PreparedStatement ps = DBConnector.getInstance().prepareStatement("DELETE FROM PERSON WHERE ID = ?")) {
            ps.setInt(1, person_id);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Fehler beim Löschen des Datenbankeintrages");
            System.out.println(e.getMessage());
        }
        return deletedPerson;
    }
}