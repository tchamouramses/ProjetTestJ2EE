package model.work.interfaces.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.work.OtherFunction.OtherFonction;
import model.work.entities.client;
import model.work.interfaces.clientInterface;

public class clientImpl implements clientInterface {

	private OtherFonction other;
	private Connection con;

	public clientImpl() {
		// TODO Auto-generated constructor stub
		other = new OtherFonction();
	}

	@Override
	public boolean add(client e) {
		con = other.directConnection();
		try {

			String sql = "INSERT INTO client(nom,date,lieu) VALUES(?,?,?)";
			PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
			p.setString(1, e.getNoms());
			p.setDate(2, e.getDate());
			p.setString(3, e.getLieu());
			
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
		return false;
	}

	@Override
	public boolean update(client e) {
		con = other.directConnection();
		try {

			String sql = "UPDATE client SET nom = ?, date = ?, lieu = ? WHERE id = ?";
			PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
			p.setString(1, e.getNoms());
			p.setDate(2, e.getDate());
			p.setString(3, e.getLieu());
			p.setInt(4, e.getId());
			
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
	public boolean delete(client e) {
		con = other.directConnection();
		try {

			String sql = "DELETE FROM client WHERE id = ?";
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
	public client findById(client e) {
		e.setDate(null);
		con = other.directConnection();
		try {

			String sql = "SELECT * FROM client WHERE id = ?";
			PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
			p.setInt(1, e.getId());
			ResultSet r = p.executeQuery();
			if(r.next()){
				e.setDate(r.getDate("date"));
				e.setLieu(r.getString("lieu"));
				e.setNoms(r.getString("nom"));
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
	public List<client> get() {
		List<client> liste = new ArrayList<client>();
		con = other.directConnection();
		try {

			String sql = "SELECT * FROM client";
			PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
			ResultSet r = p.executeQuery();
			while(r.next()){
				client e = new client();
				e.setDate(r.getDate("date"));
				e.setLieu(r.getString("lieu"));
				e.setNoms(r.getString("nom"));
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
