import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private String dbName = "db_name";
    private String username = "db_name_user";
    private String password = "pw_db_name_user";
    private String url = "jdbc:mysql://localhost:3306/";
    private static DBConnector connector = null;
    private Connection connection;

    private DBConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Driver "com.mysql.cj.jdbc.Driver" laden
            connection = DriverManager.getConnection(url, username, password); // Verbindung mit der Datenbank herstellen und in Variable connection speichern
        } catch (Exception e) {
            e.printStackTrace();
        }
        connector = this;
    }

    public static Connection getInstance() throws SQLException {
        if (connector == null) {
            connector = new DBConnector();
        } else if (connector.connection.isClosed()) {
            connector = new DBConnector();
        }
        return connector.connection;
    }
}

