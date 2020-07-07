package model.work.interfaces;

import java.util.List;

import model.work.entities.Reservation;

public interface ReservationInterface {
	public boolean add(Reservation e);
	public boolean update(Reservation e);
	public boolean delete(Reservation e);
	public Reservation findById(Reservation e);
	public List<Reservation> get();

}
