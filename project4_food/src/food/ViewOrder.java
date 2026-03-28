package food;

import java.sql.*;
import java.util.Scanner;

public class ViewOrder {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/food";
        String user = "root";
        String password = "sonika@sql";

        String query = "SELECT * FROM orders WHERE name = ?";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, user, password);

        PreparedStatement pstmt = con.prepareStatement(query);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        pstmt.setString(1, name);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String food = rs.getString("food_item");

            System.out.println("Your Order: " + food);
        } else {
            System.out.println("No order found!");
        }

        rs.close();
        pstmt.close();
        con.close();
        sc.close();
    }
}