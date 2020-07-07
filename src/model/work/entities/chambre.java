package model.work.entities;

import java.sql.Date;

public class chambre {
	private String nature;
	private double prix;
	private int id;
	private float surface;
	
	public chambre() {
		// TODO Auto-generated constructor stub
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
	
	

}
