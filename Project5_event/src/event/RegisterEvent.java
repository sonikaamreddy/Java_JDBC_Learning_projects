package event;

import java.sql.*;
import java.util.Scanner;

public class RegisterEvent {

	public static void main(String[] args) throws Exception{

		String url = "jdbc:mysql://localhost:3306/eventdb";
		String user = "root";
		String password = "sonika@sql";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(url, user, password);

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter your name: ");
		String name = sc.nextLine();

		System.out.print("Enter event name: ");
		String event = sc.nextLine();

		String checkQuery = "SELECT * FROM registrations WHERE name=? AND event_name=?";
		PreparedStatement checkStmt = con.prepareStatement(checkQuery);

		checkStmt.setString(1, name);
		checkStmt.setString(2, event);

		ResultSet rs = checkStmt.executeQuery();

		if (rs.next()) {
			System.out.println("Already registered for this event!");
		} else {
			String insertQuery = "INSERT INTO registrations(name, event_name) VALUES (?, ?)";
			PreparedStatement insertStmt = con.prepareStatement(insertQuery);

			insertStmt.setString(1, name);
			insertStmt.setString(2, event);

			insertStmt.executeUpdate();

			System.out.println("Registration Successful!");

			insertStmt.close();
		}

		rs.close();
		checkStmt.close();
		con.close();
		sc.close();
	}
}