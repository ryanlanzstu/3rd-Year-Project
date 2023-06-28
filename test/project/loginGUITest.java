/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package project;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ryanl
 */
public class loginGUITest {
    
    public loginGUITest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }


    
    @Test
    public void testCorrectLogin() {
        loginGUI loginGui = new loginGUI();
        String username = "1234";
        String password = "1234";
        loginGui.userLogin(username, password);            
    }

    /**
     * Test login with invalid username.
     */
    @Test
    public void testWrongUsername() {
        loginGUI loginGui = new loginGUI();
        String username = "asdasd";
        String password = "1234";
        loginGui.userLogin(username, password);
    }
    
    @Test
    public void testWrongUsernameAndPassword() {
        loginGUI loginGui = new loginGUI();
        String username = "asdasd";
        String password = "asdasd";
        loginGui.userLogin(username, password);
    }

    
}
