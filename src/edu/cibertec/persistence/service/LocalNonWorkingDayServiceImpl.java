package edu.cibertec.persistence.service;

import java.util.List;

import org.apache.log4j.Logger;

import edu.cibertec.entity.LocalNonWorkingDay;
import edu.cibertec.entity.LocalWorkingWeekDay;
import edu.cibertec.persistence.jpa.dao.LocalNonWorkingDayJPA;
import edu.cibertec.persistence.jpa.dao.LocalWorkingWeekDayJPA;

public class LocalNonWorkingDayServiceImpl implements ILocalNonWorkingDay{
	static final Logger log = Logger.getLogger(LocalNonWorkingDayServiceImpl.class);
	LocalNonWorkingDayJPA lnwdJPA = new LocalNonWorkingDayJPA();
	@Override
	public LocalNonWorkingDay getLocalNonWorkingDay(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocalNonWorkingDay> getLocalNonWorkingDays() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocalNonWorkingDay> getLocalNonWorkingDaysXLocal(int id) throws Exception {
		log.info("Se ingreso a getLocalNonWorkingDaysXLocal()");
		List<LocalNonWorkingDay> lwwList= null;

		lnwdJPA.createEM();
		lwwList= lnwdJPA.getAllxLocal(id);
		lnwdJPA.releaseEM();
		
		log.info("Saliendo de getLocalNonWorkingDaysXLocal()");
		return lwwList;
	}

	@Override
	public LocalNonWorkingDay registrar(LocalNonWorkingDay LocalNonWorkingDay) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalNonWorkingDay actualizar(LocalNonWorkingDay LocalNonWorkingDay) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
