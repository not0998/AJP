package studentcrud;

import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully!");

            while (true) {

                System.out.println("\n===== Student CRUD Operations =====");
                System.out.println("1. Insert Student");
                System.out.println("2. Display Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();

                        String insertQuery =
                            "INSERT INTO student (id, name, marks) VALUES (?, ?, ?)";

                        PreparedStatement ps1 = con.prepareStatement(insertQuery);

                        ps1.setInt(1, id);
                        ps1.setString(2, name);
                        ps1.setDouble(3, marks);

                        int rows = ps1.executeUpdate();

                        System.out.println(rows + " record inserted.");

                        ps1.close();
                        break;

                    case 2:
                        Statement stmt = con.createStatement();

                        ResultSet rs = stmt.executeQuery(
                            "SELECT * FROM student");

                        System.out.println("\nID\tName\tMarks");

                        while (rs.next()) {
                            System.out.println(
                                rs.getInt("id") + "\t" +
                                rs.getString("name") + "\t" +
                                rs.getDouble("marks"));
                        }

                        rs.close();
                        stmt.close();
                        break;

                    case 3:
                        System.out.print("Enter Student ID to update: ");
                        int uid = sc.nextInt();

                        System.out.print("Enter New Marks: ");
                        double newMarks = sc.nextDouble();

                        PreparedStatement ps2 = con.prepareStatement(
                            "UPDATE student SET marks=? WHERE id=?");

                        ps2.setDouble(1, newMarks);
                        ps2.setInt(2, uid);

                        int update = ps2.executeUpdate();

                        System.out.println(update + " record updated.");

                        ps2.close();
                        break;

                    case 4:
                        System.out.print("Enter Student ID to delete: ");
                        int did = sc.nextInt();

                        PreparedStatement ps3 = con.prepareStatement(
                            "DELETE FROM student WHERE id=?");

                        ps3.setInt(1, did);

                        int delete = ps3.executeUpdate();

                        System.out.println(delete + " record deleted.");

                        ps3.close();
                        break;

                    case 5:
                        con.close();
                        sc.close();

                        System.out.println("Application Closed.");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not Found!");
            System.out.println("Add MySQL Connector/J to Project Libraries.");

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
