package Gym;

import java.sql.*;
import java.util.Scanner;

public class LoginMember {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/gym";
        String user = "root";
        String password = "sonika@sql";

        String query = "SELECT * FROM members WHERE name = ?";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, user, password);

        PreparedStatement pstmt = con.prepareStatement(query);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        pstmt.setString(1, name);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String plan = rs.getString("plan");

            System.out.println("Login Successful!");
            System.out.println("Your Plan: " + plan);
        } else {
            System.out.println("Member not found!");
        }

        rs.close();
        pstmt.close();
        con.close();
        sc.close();
    }
}