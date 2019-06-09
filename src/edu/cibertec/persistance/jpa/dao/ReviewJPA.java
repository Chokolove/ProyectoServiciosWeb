package edu.cibertec.persistance.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import edu.cibertec.entity.Review;

public class ReviewJPA extends GenericoJPA{
	
	private static final long serialVersionUID = 1L;

	public Review get(Integer id) throws Exception{
		return em.find(Review.class, id);
	}
	public List<Review> getAll() throws Exception {
		TypedQuery<Review> query = em.createQuery("FROM Review",Review.class);
		return query.getResultList();
	}
	public void registrar(Review reviewJPA) throws Exception{
		em.persist(reviewJPA);
	}
	public void actualizar(Review reviewJPA) throws Exception{
		em.merge(reviewJPA);
	}
	public void eliminar(Integer id) throws Exception {
		Review reviewEliminar = (Review) em.getReference(Review.class, id);
		em.remove(reviewEliminar);
	}
}