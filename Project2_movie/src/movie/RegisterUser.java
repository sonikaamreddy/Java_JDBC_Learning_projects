package movie;

import java.sql.*;
import java.util.Scanner;

public class RegisterUser {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/movie";
        String user = "root";
        String password = "sonika@sql";

        String query = "INSERT INTO users(username, password) VALUES (?, ?)";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, user, password);

        PreparedStatement pstmt = con.prepareStatement(query);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String uname = sc.nextLine();

        System.out.print("Enter password: ");
        String pws = sc.nextLine();

        pstmt.setString(1, uname);
        pstmt.setString(2, pws);

        pstmt.executeUpdate();

        System.out.println("Account Created Successfully!");

        pstmt.close();
        con.close();
        sc.close();
    }
}