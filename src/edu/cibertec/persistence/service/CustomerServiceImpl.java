package edu.cibertec.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.cibertec.entity.Customer;
import edu.cibertec.persistence.jpa.dao.CustomerJPA;

public class CustomerServiceImpl implements ICustomerService{
	static final Logger log = Logger.getLogger(CustomerServiceImpl.class);
	CustomerJPA custJPA = new CustomerJPA();
	@Override
	public Customer getCustomer(Integer id) throws Exception {
		log.info("Se ingreso a getCustomer()");
		Customer cust = new Customer();
		
		custJPA.createEM();
		cust = custJPA.get(id);
		custJPA.releaseEM();
		
		
		log.info("Se salio de getCustomer()");
		return cust;
	}

	@Override
	public List<Customer> getCustomers() throws Exception {
		log.info("Se ingreso a getCustomers()");
		List<Customer> lstCust = new ArrayList<Customer>();
		custJPA.createEM();
		lstCust = custJPA.getAll();
		custJPA.releaseEM();
		log.info("Se salio de getCustomers()");
		return lstCust;
	}

	@Override
	public Customer registrar(Customer Customer) throws Exception {
		log.info("Se ingreso a registrar()");
		

		try {

			custJPA.createEM();
			custJPA.beginTransaction();
			custJPA.registrar(Customer);
			custJPA.flush();
			custJPA.endTransaction();

		} catch (Exception e) {
			log.error("Algo salio mal al registrar Customer");
			custJPA.rollbackTransaction();
			log.fatal("Exception: ", e);
		}
		
		log.info("Se salio de registrar()");
		return Customer;
	}

	@Override
	public Customer actualizar(Customer Customer) throws Exception {
		log.info("Se ingreso a actualizar()");
		log.info("Se salio de actualizar()");
		return null;
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		log.info("Se ingreso a eliminar()");
		log.info("Se salio de eliminar()");
		
	}

}
