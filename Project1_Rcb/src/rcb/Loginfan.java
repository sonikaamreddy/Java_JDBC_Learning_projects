package rcb;

import java.sql.*;
import java.util.Scanner;

public class Loginfan {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/rcb";
        String user = "root";
        String password = "sonika@sql";

        String query = "SELECT * FROM fans WHERE name = ? AND favorite_player = ?";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, user, password);

        PreparedStatement pstmt = con.prepareStatement(query);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your favorite player: ");
        String player = sc.nextLine();

        pstmt.setString(1, name);
        pstmt.setString(2, player);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            System.out.println("Welcome RCB Fan!");
        } else {
            System.out.println("Fan not found!");
        }

        rs.close();
        pstmt.close();
        con.close();
        sc.close();
    }
}