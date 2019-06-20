package edu.cibertec.persistence.service;

import java.util.List;

import edu.cibertec.entity.LocalNonWorkingDay;

public interface ILocalNonWorkingDay {
	public LocalNonWorkingDay getLocalNonWorkingDay(Integer id) throws Exception;
	public List<LocalNonWorkingDay> getLocalNonWorkingDays()	throws Exception;
	public List<LocalNonWorkingDay> getLocalNonWorkingDaysXLocal(int id)	throws Exception;
	public LocalNonWorkingDay registrar(LocalNonWorkingDay LocalNonWorkingDay) throws Exception;
	public LocalNonWorkingDay	actualizar(LocalNonWorkingDay LocalNonWorkingDay) throws Exception;

	public void eliminar(Integer id) throws Exception;
}
