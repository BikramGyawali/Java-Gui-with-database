import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {

    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            try (
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "")) {

                System.out.println("Database connected");

                Statement st = con.createStatement();

                // Corrected SQL queries
                String[] queries = {
                        "INSERT INTO employee VALUES (1, 'RAM', 3000, 'HR')",
                        "INSERT INTO employee VALUES (2, 'HARI', 4000, 'SALES')",
                        "INSERT INTO employee VALUES (3, 'BIKRAM', 50000, 'SALES')",
                        "INSERT INTO employee VALUES (4, 'Gita', 47000, 'IT')",
                        "INSERT INTO employee VALUES (5, 'Sita', 48000, 'Sales')"
                };

                // Proper loop
                for (String query : queries) {
                    try {
                        st.executeUpdate(query);
                        System.out.println("Inserted: " + query);
                    } catch (SQLException e) {
                        System.out.println("Error inserting: " + query);
                    }
                }

                ResultSet rs = st.executeQuery("SELECT * FROM employee WHERE department='sales'");
                System.out.println("Employe of department sales");
                while (rs.next()) {
                    System.out.println("Eid : " + rs.getInt("eid") + ",Name : " + rs.getString("ename") + ",Salary: "
                            + rs.getInt("salary") +
                            ",Department  " + rs.getString("department"));
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
