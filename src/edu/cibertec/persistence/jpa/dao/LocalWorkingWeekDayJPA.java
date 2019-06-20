package edu.cibertec.persistence.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import edu.cibertec.entity.LocalWorkingWeekDay;

public class LocalWorkingWeekDayJPA extends GenericoJPA{
	private static final long serialVersionUID = 1L;

	public LocalWorkingWeekDay get(Integer id) throws Exception{
		return em.find(LocalWorkingWeekDay.class, id);
	}

	public List<LocalWorkingWeekDay> getAll() throws Exception {
		TypedQuery<LocalWorkingWeekDay> query = em.createQuery("FROM LocalWorkingWeekDay",LocalWorkingWeekDay.class);
		return query.getResultList();
	}
	public List<LocalWorkingWeekDay> getAllxLocal(int id) throws Exception {
		TypedQuery<LocalWorkingWeekDay> query = em.createQuery("FROM LocalWorkingWeekDay where local.id = ?1",LocalWorkingWeekDay.class);
		query.setParameter(1, id);
		return query.getResultList();
	}
	public void registrar(LocalWorkingWeekDay LocalWorkingWeekDayJPA) throws Exception{
		em.persist(LocalWorkingWeekDayJPA);
	}
	public void actualizar(LocalWorkingWeekDay LocalWorkingWeekDayJPA) throws Exception{
		em.merge(LocalWorkingWeekDayJPA);
	}
	public void eliminar(Integer id) throws Exception {
		LocalWorkingWeekDay LocalWorkingWeekDayEliminar = (LocalWorkingWeekDay) em.getReference(LocalWorkingWeekDay.class, id);
		em.remove(LocalWorkingWeekDayEliminar);
	}
}
