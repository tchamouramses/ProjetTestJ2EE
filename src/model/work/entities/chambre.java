package model.work.entities;

import java.sql.Date;

public class chambre {
	private String nature;
	private double prix;
	private int id;
	private int id_cite;
	private float surface;
	
	public chambre() {
		// TODO Auto-generated constructor stub
	}

	public chambre(int id) {
		super();
		this.id = id;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSurface() {
		return surface;
	}

	public void setSurface(float surface) {
		this.surface = surface;
	}

	public int getId_cite() {
		return id_cite;
	}

	public void setId_cite(int id_cite) {
		this.id_cite = id_cite;
	}
	
	

}
