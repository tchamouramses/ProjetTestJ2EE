package model.work.interfaces;

import model.work.entities.chambre;

public interface chambreInterface {
	public boolean add(chambre e);
	public boolean update(chambre e);
	public boolean delete(chambre e);
	public boolean findById(chambre e);
	public boolean get(chambre e);
}
