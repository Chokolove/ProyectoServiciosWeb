package edu.cibertec.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import edu.cibertec.persistence.service.AccountServiceImpl;

public class JPAUtil {

	private static final EntityManagerFactory emf;
	static final Logger log = Logger.getLogger(JPAUtil.class);
	static{
		
		try{
			emf=Persistence.createEntityManagerFactory("PF");
			log.info("Se cargo la Persistencia");
		} catch(Throwable e){
			e.printStackTrace();
			throw new ExceptionInInitializerError();
			
		}
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}
	
	public static void main(String[] args) {
		
		
		
	}
}
