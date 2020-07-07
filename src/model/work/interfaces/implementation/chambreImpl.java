package model.work.interfaces.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.work.OtherFunction.OtherFonction;
import model.work.entities.chambre;
import model.work.interfaces.chambreInterface;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class chambreImpl implements chambreInterface{
	private OtherFonction other;
	private Connection con;

	public chambreImpl() {
		// TODO Auto-generated constructor stub
		other = new OtherFonction();
	}
	
	@Override
	public boolean add(chambre e) {con = other.directConnection();
	try {

		String sql = "INSERT INTO chambre(nature,prix,surface, id_cite) VALUES(?,?,?,?)";
		PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
		p.setString(1, e.getNature());
		p.setDouble(2, e.getPrix());
		p.setFloat(3, e.getSurface());
		p.setInt(4, e.getId_cite());
		
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
	public boolean update(chambre e) {
		con = other.directConnection();
		try {

			String sql = "UPDATE chambre SET nature = ?, prix = ?, surface = ?, id_cite = ? WHERE id = ?";
			PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
			p.setString(1, e.getNature());
			p.setDouble(2, e.getPrix());
			p.setFloat(3, e.getSurface());
			p.setInt(4, e.getId_cite());
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
	public boolean delete(chambre e) {
		con = other.directConnection();
		try {

			String sql = "DELETE FROM chambre WHERE id = ?";
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
	public chambre findById(chambre e) {
		e.setNature(null);
		con = other.directConnection();
		try {

			String sql = "SELECT * FROM chambre WHERE id = ?";
			PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
			p.setInt(1, e.getId());
			ResultSet r = p.executeQuery();
			if(r.next()){
				e.setNature(r.getString("nature"));
				e.setPrix(r.getDouble("prix"));
				e.setSurface(r.getFloat("surface"));
				e.setId_cite(r.getInt("id_cite"));
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
	public List<chambre> get() {
		List<chambre> liste = new ArrayList<chambre>();
		con = other.directConnection();
		try {

			String sql = "SELECT * FROM chambre";
			PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
			ResultSet r = p.executeQuery();
			while(r.next()){
				chambre e = new chambre();
				e.setNature(r.getString("nature"));
				e.setPrix(r.getDouble("prix"));
				e.setSurface(r.getFloat("surface"));
				e.setId_cite(r.getInt("id_cite"));
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
