package model.work.OtherFunction;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class OtherFonction {
	public OtherFonction() {
		// TODO Auto-generated constructor stub
	}

	public Connection directConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/work?zeroDateTimeBehavior=convertToNull",
							"root", "");
			System.out.println("connexion effectuer");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		System.out.println(System.getProperties().toString());
	}
}
