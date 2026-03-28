package movie;

import java.sql.*;
import java.util.*;

public class LoginUser {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/movie";
        String user = "root";
        String password = "sonika@sql";

        String query = "SELECT * FROM users WHERE username=? AND password=?";

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

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            System.out.println("Welcome to Movie Booking!");
        } else {
            System.out.println("Invalid Login!");
        }

        rs.close();
        pstmt.close();
        con.close();
        sc.close();
    }
}