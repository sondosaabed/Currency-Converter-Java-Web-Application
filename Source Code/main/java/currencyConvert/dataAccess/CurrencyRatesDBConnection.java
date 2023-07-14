/**
 * 
 */
package currencyConvert.dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author SS
 *
 */
public class CurrencyRatesDBConnection {

    private static String dbURL = "";
    private static final String dbUsername = "root";
    private static final String dbPassword = "0000";
    private static final String URL = "127.0.0.1";
    private static final String port = "3306";
    private static final String dbName = "currencyConverter";
    
    private Connection connection;

    /*
     * Constructor and load the driver 
     */
    public CurrencyRatesDBConnection() {
    }
    /*
     * Connect to database
     */
    public void connect() {
        try {
            dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
            // Establish the database connection
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            System.out.println("Connected to the currencies rates database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
     * Disconnect From Data base
     */
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from the currencies rates database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @param query
     * @return result set 
     */
    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /*
     * Return the Connection
     */
    public Connection getConnection() {
        return connection;
    }
}