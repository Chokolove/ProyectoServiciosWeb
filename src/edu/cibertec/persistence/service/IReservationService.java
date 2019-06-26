package edu.cibertec.persistence.service;

import java.util.List;

import edu.cibertec.entity.Reservation;

public interface IReservationService {
	public Reservation getReservation(Integer id) throws Exception;
	public List<Reservation> getReservations()	throws Exception;
	public List<Reservation> getReservationsXField(int id)	throws Exception;
	public List<Reservation> getReservationsXCustomer(int id)	throws Exception;
	public Reservation registrar(Reservation Reservation) throws Exception;
	public Reservation	actualizar(Reservation Reservation) throws Exception;

	public void eliminar(Integer id) throws Exception;
}
