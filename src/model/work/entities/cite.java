package model.work.entities;

import java.sql.Date;

public class cite {

	private String bailleur;
	private Date nbChambre;
	private int id;
	
	public cite() {
		// TODO Auto-generated constructor stub
	}

	public String getBailleur() {
		return bailleur;
	}

	public void setBailleur(String bailleur) {
		this.bailleur = bailleur;
	}

	public Date getNbChambre() {
		return nbChambre;
	}

	public void setNbChambre(Date nbChambre) {
		this.nbChambre = nbChambre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
