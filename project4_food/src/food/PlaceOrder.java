package food;

import java.sql.*;
import java.util.Scanner;

public class PlaceOrder {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/food";
        String user = "root";
        String password = "sonika@sql";

        String query = "INSERT INTO orders(name, food_item) VALUES (?, ?)";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, user, password);

        PreparedStatement pstmt = con.prepareStatement(query);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter food item: ");
        String food = sc.nextLine();

        pstmt.setString(1, name);
        pstmt.setString(2, food);

        pstmt.executeUpdate();

        System.out.println("Order Placed Successfully!");

        pstmt.close();
        con.close();
        sc.close();
    }
}