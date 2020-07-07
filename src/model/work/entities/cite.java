package model.work.entities;


public class cite {

	private String bailleur;
	private int nbChambre;
	private int id;
	
	
	public cite(int id) {
		super();
		this.id = id;
	}

	public cite() {
		// TODO Auto-generated constructor stub
	}

	public String getBailleur() {
		return bailleur;
	}

	public void setBailleur(String bailleur) {
		this.bailleur = bailleur;
	}

	public int getNbChambre() {
		return nbChambre;
	}

	public void setNbChambre(int nbChambre) {
		this.nbChambre = nbChambre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
