package edu.cibertec.persistence.service;

import java.util.List;

import edu.cibertec.entity.LocalWorkingWeekDay;

public interface ILocalWorkingWeekDay {

	public LocalWorkingWeekDay getLocalWorkingWeekDay(Integer id) throws Exception;
	public List<LocalWorkingWeekDay> getLocalWorkingWeekDays()	throws Exception;
	public List<LocalWorkingWeekDay> getLocalWorkingWeekDaysXLocal(int id)	throws Exception;
	public LocalWorkingWeekDay registrar(LocalWorkingWeekDay LocalWorkingWeekDay) throws Exception;
	public LocalWorkingWeekDay	actualizar(LocalWorkingWeekDay LocalWorkingWeekDay) throws Exception;

	public void eliminar(Integer id) throws Exception;
}
