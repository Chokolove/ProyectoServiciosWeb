package edu.cibertec.persistence.service;

import java.util.List;

import org.apache.log4j.Logger;

import edu.cibertec.entity.Reservation;
import edu.cibertec.entity.SoccerField;
import edu.cibertec.persistence.jpa.dao.ReservationJPA;

public class ReservationServiceImpl implements IReservationService{
	static final Logger log = Logger.getLogger(ReservationServiceImpl.class);
	ReservationJPA reservationJPA = new ReservationJPA();
	@Override
	public Reservation getReservation(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getReservations() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getReservationsXField(int id) throws Exception {
		log.info("Se ingreso a getReservationsXField()");
		List<Reservation>resList= null;

		reservationJPA.createEM();
		resList= reservationJPA.getAllxField(id);
		reservationJPA.releaseEM();
		
		log.info("Saliendo de getReservationsXField()");
		
		return resList;
	}

	@Override
	public Reservation registrar(Reservation Reservation) throws Exception {
		log.info("Se ingreso a registrar()");
		
		try {
			reservationJPA.createEM();
			reservationJPA.beginTransaction();
			reservationJPA.registrar(Reservation);
			reservationJPA.flush();
			reservationJPA.endTransaction();	
		} catch (Exception e){
			log.error("Algo salio mal al registrar Reservation");
			reservationJPA.rollbackTransaction();
			log.fatal("Exception: ", e);
		}
		log.info("Cuenta Creada");
		log.info("Se salio de registrar()");
		return Reservation;
	}

	@Override
	public Reservation actualizar(Reservation Reservation) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reservation> getReservationsXCustomer(int id) throws Exception {
		log.info("Se ingreso a getReservationsXCustomer()");
		List<Reservation>resList= null;

		reservationJPA.createEM();
		resList= reservationJPA.getAllxCustomer(id);
		reservationJPA.releaseEM();
		
		log.info("Saliendo de getReservationsXCustomer()");
		
		return resList;
	}

}
