package edu.cibertec.persistence.service;

import java.util.List;

import edu.cibertec.entity.Guest;

public interface IGuestService {
	public Guest getGuest(Integer id) throws Exception;
	public List<Guest> getGuests()	throws Exception;
	public Guest registrar(Guest Guest) throws Exception;
	public Guest	actualizar(Guest Guest) throws Exception;

	public void eliminar(Integer id) throws Exception;
}
