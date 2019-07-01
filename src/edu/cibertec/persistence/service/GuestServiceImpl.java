package edu.cibertec.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.cibertec.entity.Guest;
import edu.cibertec.persistence.jpa.dao.GuestJPA;

public class GuestServiceImpl implements IGuestService{
	static final Logger log = Logger.getLogger(GuestServiceImpl.class);
	GuestJPA jpa = new GuestJPA();
	@Override
	public Guest getGuest(Integer id) throws Exception {
		log.info("Se ingreso a getGuest()");
		
		Guest gue = new Guest();
		jpa.createEM();
		gue = jpa.get(id);
		jpa.releaseEM();
		
		log.info("Se salio de getGuest()");
		return gue;
	}

	@Override
	public List<Guest> getGuests() throws Exception {
		log.info("Se ingreso a getGuests()");
		
		List<Guest> guests = new ArrayList<Guest>();
		jpa.createEM();
		guests = jpa.getAll();
		jpa.releaseEM();
		
		log.info("Se salio de getGuests()");
		return null;
	}

	@Override
	public Guest registrar(Guest Guest) throws Exception {
		log.info("Se ingreso a registrar()");
		
		try {
			jpa.createEM();
			jpa.beginTransaction();
			jpa.registrar(Guest);
			jpa.flush();
			jpa.endTransaction();	
		} catch (Exception e) {
			log.error("Algo salio mal al regestrar Guest");
			jpa.rollbackTransaction();
			log.fatal("Exception: ",e);
		}
		
		log.info("Se salio de registrar()");
		return null;
	}

	@Override
	public Guest actualizar(Guest Guest) throws Exception {
		log.info("Se ingreso a actualizar()");
		log.fatal("No hay logica implementada");
		log.info("Se salio de actualizar()");
		return null;
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		log.info("Se ingreso a eliminar()");
		log.fatal("No hay logica implementada");
		log.info("Se salio de eliminar()");
		
	}

}
