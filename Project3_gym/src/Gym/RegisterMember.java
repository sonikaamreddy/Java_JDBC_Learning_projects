package Gym;

import java.sql.*;
import java.util.Scanner;

public class RegisterMember {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/gym";
        String user = "root";
        String password = "sonika@sql";

        String query = "INSERT INTO members(name, plan) VALUES (?, ?)";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, user, password);

        PreparedStatement pstmt = con.prepareStatement(query);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your gym plan (Basic/Premium): ");
        String plan = sc.nextLine();

        pstmt.setString(1, name);
        pstmt.setString(2, plan);

        pstmt.executeUpdate();

        System.out.println("Membership Registered!");

        pstmt.close();
        con.close();
        sc.close();
    }
}