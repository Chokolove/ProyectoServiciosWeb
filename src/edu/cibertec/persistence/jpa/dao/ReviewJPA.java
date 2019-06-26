package edu.cibertec.persistence.jpa.dao;

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
	public List<Review> getAllxField(int id) throws Exception {
		TypedQuery<Review> query = em.createQuery("FROM Review where local.id = ?1",Review.class);
		query.setParameter(1, id);
		return query.getResultList();
	}
	public void registrar(Review ReviewJPA) throws Exception{
		em.persist(ReviewJPA);
	}
	public void actualizar(Review ReviewJPA) throws Exception{
		em.merge(ReviewJPA);
	}
	public void eliminar(Integer id) throws Exception {
		Review ReviewEliminar = (Review) em.getReference(Review.class, id);
		em.remove(ReviewEliminar);
	}
}
