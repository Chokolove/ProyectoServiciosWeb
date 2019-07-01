package edu.cibertec.persistence.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import edu.cibertec.entity.Guest;

public class GuestJPA extends GenericoJPA{
	private static final long serialVersionUID = 1L;

	public Guest get(Integer id) throws Exception{
		return em.find(Guest.class, id);
	}

	public List<Guest> getAll() throws Exception {
		TypedQuery<Guest> query = em.createQuery("FROM Guest",Guest.class);
		return query.getResultList();
	}
	public void registrar(Guest GuestJPA) throws Exception{
		em.persist(GuestJPA);
	}
	public void actualizar(Guest GuestJPA) throws Exception{
		em.merge(GuestJPA);
	}
	public void eliminar(Integer id) throws Exception {
		Guest GuestEliminar = (Guest) em.getReference(Guest.class, id);
		em.remove(GuestEliminar);
	}
}
