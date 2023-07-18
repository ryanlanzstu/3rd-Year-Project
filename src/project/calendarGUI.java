/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.toedter.calendar.JCalendar;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author ryanl
 */
public class calendarGUI extends javax.swing.JFrame {

    /**
     * Creates new form ModuleGUI
     */
    private JCalendar calendar;
    private JLabel eventLabel;
    private boolean eventAdded;

    public calendarGUI() {
        initComponents();
        calendar = jCalendar1;
        eventHandling();

        jCalendar1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("calendar")) {
                    Date selectedDate = jCalendar1.getDate();
                    findEvents(selectedDate);
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        addBtn = new javax.swing.JButton();
        returnBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Calendar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel1)
                .addContainerGap(215, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addBtn.setBackground(new java.awt.Color(255, 255, 255));
        addBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        addBtn.setText("Add Event");
        addBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        returnBtn.setBackground(new java.awt.Color(255, 255, 255));
        returnBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        returnBtn.setText("Return");
        returnBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(addBtn)
                .addGap(40, 40, 40)
                .addComponent(returnBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addBtn, returnBtn});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(returnBtn))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        mainMenu m = new mainMenu();
        m.setVisible(true);
    }//GEN-LAST:event_returnBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_addBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(calendarGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calendarGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calendarGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calendarGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calendarGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton returnBtn;
    // End of variables declaration//GEN-END:variables

    private void eventHandling() {
        //this sets up event handling for the 'Add' button and the Calendar
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addEventDialog();
            }
        });

        calendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("calendar")) {
                    Date selectedDate = calendar.getDate();
                    findEvents(selectedDate);
                }
            }
        });
    }

    private void addEventDialog() {
        JDialog dialog = new JDialog(this, "Add Event", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Create and add components to the dialog for adding an event
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        JLabel dateLabel = new JLabel("Date:");
        JCalendar dateCalendar = new JCalendar();

        contentPanel.add(dateLabel);
        contentPanel.add(dateCalendar);

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.Y_AXIS));

        JLabel descLabel = new JLabel("Event Description:");
        JTextField descField = new JTextField(15);
        JLabel nameLabel = new JLabel("Event Name:");
        JTextField nameField = new JTextField(15);
        JLabel moduleCodeLabel = new JLabel("Module Code:");
        JTextField moduleCodeField = new JTextField(15);

        fieldsPanel.add(descLabel);
        fieldsPanel.add(descField);
        fieldsPanel.add(nameLabel);
        fieldsPanel.add(nameField);
        fieldsPanel.add(moduleCodeLabel);
        fieldsPanel.add(moduleCodeField);

        contentPanel.add(fieldsPanel);

        JButton saveButton = new JButton("Save");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(saveButton);

        contentPanel.add(buttonPanel);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Retrieve the selected date from the calendar
                Date selectedDate = dateCalendar.getDate();
                // Retrieve the event description from the text field
                String eventDescription = descField.getText();
                // Retrieve the event name from the text field
                String eventName = nameField.getText();
                // Retrieve the module code from the text field
                String moduleCodeText = moduleCodeField.getText();

                // Check if any of the fields are empty
                if (eventDescription.isEmpty() || eventName.isEmpty() || moduleCodeText.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Please don't leave any fields blank.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Stop execution if any field is empty
                }

                // Retrieve the module code as an integer
                int moduleCode;
                try {
                    moduleCode = Integer.parseInt(moduleCodeText);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(dialog, "Module Code must be a digit!.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Stop execution if module code is not a valid integer
                }

                // Connect to MySQL server
                String url = "jdbc:mysql://localhost:3307/project";
                String username = "root";
                String password = "";

                try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    // Save the event to the database
                    saveEvent(connection, selectedDate, eventDescription, eventName, moduleCode);
                    JOptionPane.showMessageDialog(dialog, "Event saved successfully!");
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(dialog, "Failed to save event.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Close the dialog
                dialog.dispose();
            }
        });

        dialog.setContentPane(contentPanel);

        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public void saveEvent(Connection connection, Date selectedDate, String eventDescription, String eventName, int moduleCode) {
        try {
            String sql = "INSERT INTO events (dateOfEvent, descOfEvent, nameOfEvent, moduleCode) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(selectedDate.getTime()));
            statement.setString(2, eventDescription);
            statement.setString(3, eventName);
            statement.setInt(4, moduleCode);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Event saved successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to save event.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isEventAdded() {
        return eventAdded;
    }

    private void findEvents(Date selectedDate) {
        // Connect to MySQL server
        String url = "jdbc:mysql://localhost:3307/project";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Prepare SQL statement to fetch events for the selected date
            String sql = "SELECT descOfEvent FROM events WHERE dateOfEvent = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(selectedDate.getTime()));

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Display the events in a message dialog
            StringBuilder eventText = new StringBuilder();
            while (resultSet.next()) {
                String eventDescription = resultSet.getString("descOfEvent");
                eventText.append(eventDescription).append("\n");
            }

            if (eventText.length() > 0) {
                JOptionPane.showMessageDialog(this, "Events on " + selectedDate + ":\n" + eventText.toString());
            } else {
                JOptionPane.showMessageDialog(this, "No events found on " + selectedDate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
