package model.work.interfaces;

import model.work.entities.cite;

public interface citiesInterface {
	public boolean add(cite e);
	public boolean update(cite e);
	public boolean delete(cite e);
	public boolean findById(cite e);
	public boolean get(cite e);

}
