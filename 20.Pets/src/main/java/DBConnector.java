import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private String dbName = "pets";
    private String username = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/" + dbName;
    private static DBConnector connector = null;
    private Connection connection;

    public DBConnector() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Database Connection couldn't be established!", e);
        }
        connector = this;
    }

    public static Connection getInstance() throws SQLException {
        if (connector == null) {
            connector = new DBConnector();
        } else if (connector.connection.isClosed()){
            connector = new DBConnector();
        }
        return connector.connection;
    }
}
