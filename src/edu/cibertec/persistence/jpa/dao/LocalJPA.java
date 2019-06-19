package edu.cibertec.persistence.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import edu.cibertec.entity.Local;

public class LocalJPA extends GenericoJPA{
	private static final long serialVersionUID = 1L;
	public Local get(Integer id) throws Exception{
		return em.find(Local.class, id);
	}
	
	public List<Local> getAll() throws Exception {
		TypedQuery<Local> query = em.createQuery("FROM Local",Local.class);
		return query.getResultList();
	}
	public void registrar(Local localJPA) throws Exception{
		em.persist(localJPA);
	}
	public void actualizar(Local localJPA) throws Exception{
		em.merge(localJPA);
	}
	public void eliminar(Integer id) throws Exception {
		Local localEliminar = (Local) em.getReference(Local.class, id);
		em.remove(localEliminar);
	}
}
