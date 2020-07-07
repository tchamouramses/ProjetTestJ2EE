package model.work.interfaces;

import java.util.List;

import model.work.entities.chambre;

public interface chambreInterface {
	public boolean add(chambre e);
	public boolean update(chambre e);
	public boolean delete(chambre e);
	public chambre findById(chambre e);
	public List<chambre> get();
}
