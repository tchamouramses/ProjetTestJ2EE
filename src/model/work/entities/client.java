package model.work.entities;

import java.sql.Date;

public class client {
	private String noms;
	private Date date;
	private int id;
	private String lieu;

	public client() {
		// TODO Auto-generated constructor stub
	}
	
	

	public client(int id) {
		super();
		this.id = id;
	}



	public String getNoms() {
		return noms;
	}

	public void setNoms(String noms) {
		this.noms = noms;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

}
