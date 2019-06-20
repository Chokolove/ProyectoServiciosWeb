package edu.cibertec.persistence.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import edu.cibertec.entity.LocalNonWorkingDay;;

public class LocalNonWorkingDayJPA extends GenericoJPA{
	private static final long serialVersionUID = 1L;
	public LocalNonWorkingDay get(Integer id) throws Exception{
		return em.find(LocalNonWorkingDay.class, id);
	}

	public List<LocalNonWorkingDay> getAll() throws Exception {
		TypedQuery<LocalNonWorkingDay> query = em.createQuery("FROM LocalNonWorkingDay",LocalNonWorkingDay.class);
		return query.getResultList();
	}

	public List<LocalNonWorkingDay> getAllxLocal(int id) throws Exception {
		TypedQuery<LocalNonWorkingDay> query = em.createQuery("FROM LocalNonWorkingDay where local.id = ?1",LocalNonWorkingDay.class);
		query.setParameter(1, id);
		return query.getResultList();
	}
	public void registrar(LocalNonWorkingDay LocalNonWorkingDayJPA) throws Exception{
		em.persist(LocalNonWorkingDayJPA);
	}
	public void actualizar(LocalNonWorkingDay LocalNonWorkingDayJPA) throws Exception{
		em.merge(LocalNonWorkingDayJPA);
	}
	public void eliminar(Integer id) throws Exception {
		LocalNonWorkingDay LocalNonWorkingDayEliminar = (LocalNonWorkingDay) em.getReference(LocalNonWorkingDay.class, id);
		em.remove(LocalNonWorkingDayEliminar);
	}
}
