/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package project;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.*;

/**
 *
 * @author ryanl
 */
public class databaseConnectionTest {

    public databaseConnectionTest() {
    }
    
    private Connection mockConnection;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mockConnection = mock(Connection.class);
        // Set up the mock behavior here if needed
    }
    
    @After
    public void tearDown() throws SQLException {
        if (mockConnection != null && !mockConnection.isClosed()) {
            mockConnection.close();
        }
    }

    /**
     * tests mysql database connects in databaseConnection.
     */
    @Test
    public void testConnectDB() {
        Connection connection = databaseConnection.openConnection();
        assertNotNull("Connection should not be null", connection);
    }

    /**
     * test mysql database connection closes as well in databaseConnection.
     */
    @Test
    public void testCloseConnection() throws SQLException {
        databaseConnection.closeConnection(mockConnection);
        verify(mockConnection, times(1)).close();
    }

}
