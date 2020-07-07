package model.work.interfaces.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.work.OtherFunction.OtherFonction;
import model.work.entities.Reservation;
import model.work.interfaces.ReservationInterface;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class reservationImpl implements ReservationInterface {
	private OtherFonction other;
	private Connection con;

	public reservationImpl() {
		// TODO Auto-generated constructor stub
		other = new OtherFonction();
	}

	@Override
	public boolean add(Reservation e) {
		con = other.directConnection();
		try {

			String sql = "INSERT INTO Reservation(id_client,date,id_chambre,avance) VALUES(?,?,?,?)";
			PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
			p.setInt(1, e.getId_client());
			p.setDate(2, e.getDate());
			p.setInt(3, e.getId_chambre());
			p.setDouble(4, e.getAvance());

			p.execute();
			p.close();
			con.close();
			return true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean update(Reservation e) {
		con = other.directConnection();
		try {

			String sql = "UPDATE Reservation SET id_client = ?, date = ?, id_chambre = ?, avance = ? WHERE id = ?";
			PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
			p.setInt(1, e.getId_client());
			p.setDate(2, e.getDate());
			p.setInt(3, e.getId_chambre());
			p.setDouble(4, e.getAvance());
			p.setInt(5, e.getId());
			p.executeUpdate();
			p.close();
			con.close();
			return true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Reservation e) {
		con = other.directConnection();
		try {

			String sql = "DELETE FROM Reservation WHERE id = ?";
			PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
			p.setInt(1, e.getId());
			p.executeUpdate();
			p.close();
			con.close();
			return true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public Reservation findById(Reservation e) {
		e.setDate(null);
		con = other.directConnection();
		try {

			String sql = "SELECT * FROM Reservation WHERE id = ?";
			PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
			p.setInt(1, e.getId());
			ResultSet r = p.executeQuery();
			if (r.next()) {
				e.setDate(r.getDate("date"));
				e.setAvance(r.getDouble("avance"));
				e.setId_chambre(r.getInt("id_chambre"));
				e.setId_client(r.getInt("id_client"));
			}

			r.close();
			p.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public List<Reservation> get() {
		List<Reservation> liste = new ArrayList<Reservation>();
		con = other.directConnection();
		try {

			String sql = "SELECT * FROM Reservation";
			PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
			ResultSet r = p.executeQuery();
			while (r.next()) {
				Reservation e = new Reservation();
				e.setDate(r.getDate("date"));
				e.setAvance(r.getDouble("avance"));
				e.setId_chambre(r.getInt("id_chambre"));
				e.setId_client(r.getInt("id_client"));
				e.setId(r.getInt("id"));
				liste.add(e);
			}

			r.close();
			p.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return liste;
	}

}
