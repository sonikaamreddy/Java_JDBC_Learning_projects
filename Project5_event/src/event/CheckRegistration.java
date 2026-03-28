package event;

import java.sql.*;
import java.util.Scanner;

public class CheckRegistration {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/eventdb";
        String user = "root";
        String password = "sonika@sql";

        String query = "SELECT * FROM registrations WHERE name=?";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, user, password);

        PreparedStatement pstmt = con.prepareStatement(query);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        pstmt.setString(1, name);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String event = rs.getString("event_name");
            System.out.println("Registered Event: " + event);
        } else {
            System.out.println("No registration found!");
        }

        rs.close();
        pstmt.close();
        con.close();
        sc.close();
    }
}