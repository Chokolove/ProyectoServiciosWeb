package edu.cibertec.persistence.service;

import java.util.List;

import org.apache.log4j.Logger;

import edu.cibertec.entity.LocalWorkingWeekDay;
import edu.cibertec.entity.SoccerField;
import edu.cibertec.persistence.jpa.dao.LocalWorkingWeekDayJPA;

public class LocalWorkingWeekDayServiceImpl implements ILocalWorkingWeekDay{
	static final Logger log = Logger.getLogger(LocalWorkingWeekDayServiceImpl.class);
	LocalWorkingWeekDayJPA lwwJPA = new LocalWorkingWeekDayJPA();
	@Override
	public LocalWorkingWeekDay getLocalWorkingWeekDay(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocalWorkingWeekDay> getLocalWorkingWeekDays() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocalWorkingWeekDay> getLocalWorkingWeekDaysXLocal(int id) throws Exception {
		log.info("Se ingreso a getLocalWorkingWeekDaysXLocal()");
		List<LocalWorkingWeekDay> lwwList= null;

		lwwJPA.createEM();
		lwwList= lwwJPA.getAllxLocal(id);
		lwwJPA.releaseEM();
		
		log.info("Saliendo de getLocalWorkingWeekDaysXLocal()");
		return lwwList;
	}

	@Override
	public LocalWorkingWeekDay registrar(LocalWorkingWeekDay LocalWorkingWeekDay) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalWorkingWeekDay actualizar(LocalWorkingWeekDay LocalWorkingWeekDay) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
