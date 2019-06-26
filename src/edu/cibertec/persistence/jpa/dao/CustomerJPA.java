package edu.cibertec.persistence.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import edu.cibertec.entity.Customer;

public class CustomerJPA extends GenericoJPA{
private static final long serialVersionUID = 1L;
	
	public Customer get(Integer id) throws Exception{
		return em.find(Customer.class, id);
	}
	
	public List<Customer> getAll() throws Exception {
		TypedQuery<Customer> query = em.createQuery("FROM Customer",Customer.class);
		return query.getResultList();
	}
	public void registrar(Customer CustomerJPA) throws Exception{
		em.persist(CustomerJPA);
	}
	public void actualizar(Customer CustomerJPA) throws Exception{
		em.merge(CustomerJPA);
	}
	public void eliminar(Integer id) throws Exception {
		Customer CustomerEliminar = (Customer) em.getReference(Customer.class, id);
		em.remove(CustomerEliminar);
	}
}
