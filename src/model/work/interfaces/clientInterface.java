package model.work.interfaces;

import model.work.entities.client;

public interface clientInterface {
	public boolean add(client e);
	public boolean update(client e);
	public boolean delete(client e);
	public boolean findById(client e);
	public boolean get(client e);

}
