package rcb;

import java.sql.*;
import java.util.Scanner;

public class RegisterFan {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/rcb";
        String user = "root";
        String password = "sonika@sql";

        String query = "INSERT INTO fans(name, favorite_player) VALUES (?, ?)";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, user, password);

        PreparedStatement pstmt = con.prepareStatement(query);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your favorite RCB player: ");
        String player = sc.nextLine();

        pstmt.setString(1, name);
        pstmt.setString(2, player);

        pstmt.executeUpdate();

        System.out.println("RCB Fan Registered Successfully!");

        pstmt.close();
        con.close();
        sc.close();
    }
}