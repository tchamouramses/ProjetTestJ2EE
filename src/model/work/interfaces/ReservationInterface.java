package model.work.interfaces;

import model.work.entities.Reservation;

public interface ReservationInterface {
	public boolean add(Reservation e);
	public boolean update(Reservation e);
	public boolean delete(Reservation e);
	public boolean findById(Reservation e);
	public boolean get(Reservation e);

}
