package dataAccess.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import currencyConvert.dataAccess.*;

public class CurrencyRatesDBConnectionTest {
    private CurrencyRatesDBConnection dbConnection;

    @BeforeEach
    public void setUp() {
        dbConnection = new CurrencyRatesDBConnection();
        dbConnection.connect();
    }

    @AfterEach
    public void tearDown() {
        dbConnection.disconnect();
    }

    @Test
    public void testConnection() {
        Connection connection = dbConnection.getConnection();
        assertNotNull(connection, "Connection should not be null");
        try {
            assertTrue(connection.isValid(1), "Connection should be valid");
        } catch (Exception e) {
            fail("An exception occurred while checking connection validity: " + e.getMessage());
        }
    }

    @Test
    public void testExecuteQuery() {
        String query = "SELECT * FROM currency";
        ResultSet resultSet = dbConnection.executeQuery(query);
        assertNotNull(resultSet, "Result set should not be null");

        try {
            int rowCount = 0;
            while (resultSet.next()) {
                rowCount++;
            }

            assertTrue(rowCount > 0, "Result set should contain rows");
        } catch (Exception e) {
            fail("An exception occurred while iterating over the result set: " + e.getMessage());
        }
    }
}

