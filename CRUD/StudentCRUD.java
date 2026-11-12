
import java.sql.*;
import java.util.*;

public class StudentCRUD {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb", "root", "root");

            while (true) {
                System.out.println("\n1.Insert  2.Display  3.Update  4.Delete  5.Exit");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();

                if (ch == 1) {
                    // INSERT
                    System.out.print("Enter ID, Name, Marks: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    double marks = sc.nextDouble();

                    PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO student VALUES(?,?,?)");

                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setDouble(3, marks);
                    ps.executeUpdate();

                    System.out.println("Student Inserted!");
                }

                else if (ch == 2) {
                    // SELECT
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM student");

                    while (rs.next())
                        System.out.println(rs.getInt(1) + " " +
                            rs.getString(2) + " " + rs.getDouble(3));

                    rs.close();
                    st.close();
                }

                else if (ch == 3) {
                    // UPDATE
                    System.out.print("Enter ID and New Marks: ");
                    int id = sc.nextInt();
                    double marks = sc.nextDouble();

                    PreparedStatement ps = con.prepareStatement(
                        "UPDATE student SET marks=? WHERE id=?");

                    ps.setDouble(1, marks);
                    ps.setInt(2, id);
                    ps.executeUpdate();

                    System.out.println("Student Updated!");
                }

                else if (ch == 4) {
                    // DELETE
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM student WHERE id=?");

                    ps.setInt(1, id);
                    ps.executeUpdate();

                    System.out.println("Student Deleted!");
                }

                else if (ch == 5) {
                    con.close();
                    sc.close();
                    System.out.println("Application Closed!");
                    break;
                }

                else
                    System.out.println("Invalid Choice!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


