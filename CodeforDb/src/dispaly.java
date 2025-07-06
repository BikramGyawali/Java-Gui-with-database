import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dispaly {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root",
                            "");) {
                System.out.println("Connection successful ");

                Statement st = con.createStatement();
                String query = "Select * from student";
                ResultSet r = st.executeQuery(query);
                System.out.println("Data fetched successfully");

                while (r.next()) {
                    System.out.println("roll :" + r.getInt("roll"));
                    System.out.println("Name :" + r.getString("name"));
                    System.out.println("Address :" + r.getString("address"));
                    System.out.println("Program :" + r.getString("program"));
                    System.out.println("-----------------------------");
                }

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}