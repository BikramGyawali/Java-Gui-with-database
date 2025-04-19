 import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

import java.sql.SQLException;
//import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class Register {
    public static void main(String[] args) {
        JFrame f = new JFrame("Frame Example");
        f.setSize(400, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        JLabel l1 = new JLabel("Username:");
        l1.setBounds(90, 70, 100, 30);
        JTextArea t1 = new JTextArea();
        t1.setBounds(170, 74, 100, 20);
        JLabel j2 = new JLabel("Password:");
        j2.setBounds(90, 90, 100, 50);
        JPasswordField t2 = new JPasswordField();
        t2.setBounds(170, 110, 100, 20);
        JButton b1 = new JButton("Register");
        b1.setBounds(110, 150, 100, 30);
        f.add(l1);
        f.add(t1);
        f.add(j2);
        f.add(t2);
        f.add(b1);
        

        b1.addActionListener((ActionEvent e) -> {
           try{
               String user = t1.getText();
          
               
               String pass = new String(t2.getPassword());
               Class.forName("com.mysql.cj.jdbc.Driver");
               try(
                       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javamark","root","")
                       ){
                          System.out.println("Connection successful");
                          Statement st = con.createStatement();
String query = "INSERT INTO register(UserName, pass) VALUES ('" + user + "', '" + pass + "')";
//                    st.execute(query);
st.execute(query);
           
           }
            
           
             } catch (ClassNotFoundException | NumberFormatException | SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }});
 
    }
}