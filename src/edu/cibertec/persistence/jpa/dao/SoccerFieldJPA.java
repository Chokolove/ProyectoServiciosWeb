package edu.cibertec.persistence.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import edu.cibertec.entity.SoccerField;

public class SoccerFieldJPA extends GenericoJPA{
	
	public SoccerField get(Integer id) throws Exception{
		return em.find(SoccerField.class, id);
	}
	
	public List<SoccerField> getAll() throws Exception {
		TypedQuery<SoccerField> query = em.createQuery("FROM SoccerField",SoccerField.class);
		return query.getResultList();
	}
	
	public List<SoccerField> getAllxLocal(int id) throws Exception {
		TypedQuery<SoccerField> query = em.createQuery("FROM SoccerField where local.id = ?1",SoccerField.class);
		query.setParameter(1, id);
		return query.getResultList();
	}
	public void registrar(SoccerField SoccerFieldJPA) throws Exception{
		em.persist(SoccerFieldJPA);
	}
	public void actualizar(SoccerField SoccerFieldJPA) throws Exception{
		em.merge(SoccerFieldJPA);
	}
	public void eliminar(Integer id) throws Exception {
		SoccerField SoccerFieldEliminar = (SoccerField) em.getReference(SoccerField.class, id);
		em.remove(SoccerFieldEliminar);
	}
}
