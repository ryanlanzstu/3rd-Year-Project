/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package project;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ryanl
 */
public class registerGUITest {

    private static Connection databaseConn;

    public registerGUITest() {

    }

    @BeforeClass
    public static void setUpClass() {
        databaseConn = databaseConnection.openConnection();
    }

    @AfterClass
    public static void tearDownClass() throws SQLException {
        if (databaseConn != null) {
            databaseConn.close();
        }
    }

    /**
     * testing for an account registering with all fields filled in in registerGUI.
     */
    @Test
    public void testRegistration() throws SQLException {
        registerGUI registerGui = new registerGUI();
        String firstname = "Paul";
        String surname = "Allen";
        String email = "paulallen@gmail.com";
        String username = "1234";
        String password = "1234";

        registerGui.userRegister(firstname, surname, email, username, password);

        PreparedStatement st = databaseConn.prepareStatement("SELECT * FROM users WHERE username = ?");
        st.setString(1, username);
        ResultSet resultSet = st.executeQuery();
        assertNotNull(resultSet);
        if (resultSet.next()) {
            assertEquals(firstname, resultSet.getString("firstname"));
            assertEquals(surname, resultSet.getString("surname"));
            assertEquals(email, resultSet.getString("email"));
            assertEquals(username, resultSet.getString("username"));
            assertEquals(password, resultSet.getString("password"));
        }
    }

    /**
     * testing for an account registering with blank fields in registerGUI.
     */
    @Test
    public void testBlankFields() throws SQLException {
        registerGUI registerGui = new registerGUI();
        String firstname = "";
        String surname = "";
        String email = "";
        String username = "";
        String password = "";

        registerGui.userRegister(firstname, surname, email, username, password);

       
    }

    /**
     * testing for an account registering with a username that has already been registered in registerGUI.
     */
     @Test
    public void testUsernameAlreadyInUse() throws SQLException {
        registerGUI registerGui = new registerGUI();
        String firstname = "Michael";
        String surname = "Johnson";
        String email = "michaeljohnson@gmail.com";
        String username = "2345";
        String password = "2345";

        //make a user with the username already in use
        PreparedStatement insertStatement = databaseConn.prepareStatement("INSERT INTO users (firstname, surname, email, username, password) VALUES (?, ?, ?, ?, ?)");
        insertStatement.setString(1, firstname);
        insertStatement.setString(2, surname);
        insertStatement.setString(3, email);
        insertStatement.setString(4, username);
        insertStatement.setString(5, password);
        insertStatement.executeUpdate();
        registerGui.userRegister(firstname, surname, email, username, password);

        // check results
        PreparedStatement selectStatement = databaseConn.prepareStatement("SELECT COUNT(*) FROM users WHERE username = ?");
        selectStatement.setString(1, username);
        ResultSet resultSet = selectStatement.executeQuery();
        assertNotNull(resultSet);
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            assertEquals(1, count);
        }
    }
}
