package edu.cibertec.persistence.service;

import java.util.List;

import org.apache.log4j.Logger;

import edu.cibertec.entity.Account;
import edu.cibertec.entity.Local;
import edu.cibertec.persistence.jpa.dao.LocalJPA;

public class LocalServiceImpl implements ILocalService{
	
	static final Logger log = Logger.getLogger(LocalServiceImpl.class);
	LocalJPA localJPA = new LocalJPA();
	
	@Override
	public Local getLocal(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Local> getLocals() throws Exception {
		log.info("Se ingreso a getLocals()");
		List<Local>accs= null;

		localJPA.createEM();
		accs= localJPA.getAll();
		localJPA.releaseEM();
		
		log.info("Saliendo de getLocals()");
		
		return accs;
	}

	@Override
	public Local registrar(Local local) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Local actualizar(Local local) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
