package model.work.interfaces;

import java.util.List;

import model.work.entities.client;

public interface clientInterface {
	public boolean add(client e);
	public boolean update(client e);
	public boolean delete(client e);
	public client findById(client e);
	public List<client> get();

}
