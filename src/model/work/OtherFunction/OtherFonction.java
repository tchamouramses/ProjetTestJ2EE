package model.work.OtherFunction;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.work.entities.Reservation;
import model.work.entities.chambre;
import model.work.entities.cite;
import model.work.entities.client;
import model.work.interfaces.implementation.chambreImpl;
import model.work.interfaces.implementation.citeImpl;
import model.work.interfaces.implementation.clientImpl;
import model.work.interfaces.implementation.reservationImpl;

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
		clientImpl client = new clientImpl();
		client cl = new client();
		cl.setDate(new Date(System.currentTimeMillis()));
		cl.setLieu("dschang");
		cl.setNoms(" handsome boy");
		cl.setId(4);
		System.out.println(client.get());
		
		
		
		citeImpl ci = new citeImpl();
		cite cite = new cite();
		cite.setBailleur("admiro pro");
		cite.setNbChambre(100);
		cite.setId(4);
		System.out.println(ci.get());
		
		
		chambreImpl chambre = new chambreImpl();
		chambre c = new chambre();
		c.setId_cite(2);
		c.setNature("modernisation");
		c.setPrix(12000);
		c.setId(2);
		System.out.println(chambre.get());
		
		reservationImpl res = new reservationImpl();
		Reservation r = new Reservation();
		r.setAvance(1000);
		r.setDate(new Date(System.currentTimeMillis()));
		r.setId_chambre(2);
		r.setId_client(2);
		r.setId(2);
		System.out.println(res.get());
		
		
	}
}
