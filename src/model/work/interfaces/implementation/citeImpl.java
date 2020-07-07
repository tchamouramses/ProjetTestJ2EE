package model.work.interfaces.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.work.OtherFunction.OtherFonction;
import model.work.entities.cite;
import model.work.interfaces.citiesInterface;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class citeImpl implements citiesInterface{
	private OtherFonction other;
	private Connection con;
	
	public citeImpl() {
		// TODO Auto-generated constructor stub
		other = new OtherFonction();
	}

	@Override
	public boolean add(cite e) {con = other.directConnection();
	try {

		String sql = "INSERT INTO cite(bailleur,nbChambre) VALUES(?,?)";
		PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
		p.setString(1, e.getBailleur());
		p.setInt(2, e.getNbChambre());
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
	public boolean update(cite e) {
		con = other.directConnection();
		try {

			String sql = "UPDATE cite SET bailleur = ?, nbChambre = ? WHERE id = ?";
			PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
			p.setString(1, e.getBailleur());
			p.setInt(2, e.getNbChambre());
			p.setInt(3, e.getId());
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
	public boolean delete(cite e) {
		con = other.directConnection();
		try {

			String sql = "DELETE FROM cite WHERE id = ?";
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
	public cite findById(cite e) {
		e.setBailleur(null);
		con = other.directConnection();
		try {

			String sql = "SELECT * FROM cite WHERE id = ?";
			PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
			p.setInt(1, e.getId());
			ResultSet r = p.executeQuery();
			if(r.next()){
				e.setBailleur(r.getString("bailleur"));
				e.setNbChambre(r.getInt("nbChambre"));
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
	public List<cite> get() {
		List<cite> liste = new ArrayList<cite>();
		con = other.directConnection();
		try {

			String sql = "SELECT * FROM cite";
			PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
			ResultSet r = p.executeQuery();
			while(r.next()){
				cite e = new cite();
				e.setBailleur(r.getString("bailleur"));
				e.setNbChambre(r.getInt("nbChambre"));
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
