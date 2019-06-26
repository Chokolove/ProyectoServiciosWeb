package edu.cibertec.persistence.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import edu.cibertec.entity.Reservation;

public class ReservationJPA extends GenericoJPA{
	public Reservation get(Integer id) throws Exception{
		return em.find(Reservation.class, id);
	}

	public List<Reservation> getAll() throws Exception {
		TypedQuery<Reservation> query = em.createQuery("FROM Reservation",Reservation.class);
		return query.getResultList();
	}

	public List<Reservation> getAllxField(int id) throws Exception {
		TypedQuery<Reservation> query = em.createQuery("FROM Reservation where soccerField.id = ?1",Reservation.class);
		query.setParameter(1, id);
		return query.getResultList();
	}
	public List<Reservation> getAllxCustomer(int id) throws Exception {
		TypedQuery<Reservation> query = em.createQuery("FROM Reservation where reserverId = ?1",Reservation.class);
		query.setParameter(1, id);
		return query.getResultList();
	}
	public void registrar(Reservation ReservationJPA) throws Exception{
		em.persist(ReservationJPA);
	}
	public void actualizar(Reservation ReservationJPA) throws Exception{
		em.merge(ReservationJPA);
	}
	public void eliminar(Integer id) throws Exception {
		Reservation ReservationEliminar = (Reservation) em.getReference(Reservation.class, id);
		em.remove(ReservationEliminar);
	}
}
