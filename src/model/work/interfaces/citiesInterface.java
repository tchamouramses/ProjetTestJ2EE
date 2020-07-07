package model.work.interfaces;

import java.util.List;

import model.work.entities.cite;

public interface citiesInterface {
	public boolean add(cite e);
	public boolean update(cite e);
	public boolean delete(cite e);
	public cite findById(cite e);
	public List<cite> get();

}
