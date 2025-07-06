import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.*;

public class Student {
    public static void main(String[] args) {
        // Create the main frame
        JFrame f = new JFrame("Student Registration");
        f.setSize(500, 400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Roll No
        JLabel rollLabel = new JLabel("Roll No:");
        rollLabel.setBounds(100, 50, 100, 25);
        JTextField rollField = new JTextField();
        rollField.setBounds(200, 50, 150, 25);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(100, 90, 100, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(200, 90, 150, 25);

        // Address
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(100, 130, 100, 25);
        JTextField addressField = new JTextField();
        addressField.setBounds(200, 130, 150, 25);

        // Program
        JLabel programLabel = new JLabel("Program:");
        programLabel.setBounds(100, 170, 100, 25);
        JTextField programField = new JTextField();
        programField.setBounds(200, 170, 150, 25);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(180, 230, 100, 30);

        // Add components to the frame
        f.add(rollLabel);
        f.add(rollField);
        f.add(nameLabel);
        f.add(nameField);
        f.add(addressLabel);
        f.add(addressField);
        f.add(programLabel);
        f.add(programField);
        f.add(submitButton);

        // Show the frame
        f.setVisible(true);

        // handiling the action

        submitButton.addActionListener((ActionEvent e) -> {
            try {

                int roll = Integer.parseInt(rollField.getText());
                String name = nameField.getText();
                String address = addressField.getText();
                String program = programField.getText();
                Class.forName("com.mysql.cj.jdbc.Driver");
                try (
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root",
                                "");) {

                    System.out.println("Connection successful ");
                    Statement st = con.createStatement();
                    String query = "Insert into student(roll,name,address,program) values('" + roll + "','" + name
                            + "','" + address + "','" + program + "')";
                    st.executeUpdate(query);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("Error:" + ex.getMessage());
            }
        });
    }
}
