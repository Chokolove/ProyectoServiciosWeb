package edu.cibertec.persistence.service;

import java.util.List;

import edu.cibertec.entity.Customer;

public interface ICustomerService {
	public Customer getCustomer(Integer id) throws Exception;
	public List<Customer> getCustomers()	throws Exception;
	public Customer registrar(Customer Customer) throws Exception;
	public Customer	actualizar(Customer Customer) throws Exception;

	public void eliminar(Integer id) throws Exception;
}
