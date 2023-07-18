/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package project;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mockito;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author ryanl
 */
public class CalendarGUITest {



    private calendarGUI calendarGui;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        calendarGui = new calendarGUI();
    }

      @Test
    public void testAddEvent() throws SQLException {
        calendarGUI gui = new calendarGUI(); // Create an instance of calendarGUI

        //Set up mock connection
        Connection connection = Mockito.mock(Connection.class);
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(1); // Assuming the executeUpdate() returns 1 for success

        Date selectedDate = new Date(); // Replace with a specific date
        String eventDescription = "Test Event Description";
        String eventName = "Test Event";
        int moduleCode = 123;

        // Call saveEvent method
        gui.saveEvent(connection, selectedDate, eventDescription, eventName, moduleCode);

        // Verify
        verify(statement).setDate(1, new java.sql.Date(selectedDate.getTime()));
        verify(statement).setString(2, eventDescription);
        verify(statement).setString(3, eventName);
        verify(statement).setInt(4, moduleCode);
        verify(statement).executeUpdate();
    }
    
    @Test
    public void testAddEventBlankFields() throws SQLException {
        calendarGUI gui = new calendarGUI(); // Create an instance of calendarGUI

        //Set up mock connection
        Connection connection = Mockito.mock(Connection.class);
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(1); // Assuming the executeUpdate() returns 1 for success

        Date selectedDate = new Date(); // Replace with a specific date
        String eventDescription = ""; // Empty event description
        String eventName = "Test Event";
        int moduleCode = 123;

        gui.saveEvent(connection, selectedDate, eventDescription, eventName, moduleCode);
        verify(statement, never()).executeUpdate();
    }
    
   @Test
public void testAddEventModuleInt() throws SQLException {
    calendarGUI gui = new calendarGUI(); // Create an instance of calendarGUI

      //Set up mock connection
    Connection connection = Mockito.mock(Connection.class);
    PreparedStatement statement = Mockito.mock(PreparedStatement.class);
    when(connection.prepareStatement(anyString())).thenReturn(statement);
    when(statement.executeUpdate()).thenReturn(1); // Assuming the executeUpdate() returns 1 for success

    Date selectedDate = new Date(); // Replace with a specific date
    String eventDescription = "Test Event Description";
    String eventName = "Test Event";
    String invalidModuleCode = "ABC"; // Invalid module code with non-digit characters

    //Call saveEveeetnt
    assertThrows(NumberFormatException.class, () ->
            gui.saveEvent(connection, selectedDate, eventDescription, eventName, Integer.parseInt(invalidModuleCode))
    );

    //Verify
    verify(statement, never()).executeUpdate();
}
}

