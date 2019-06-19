package edu.cibertec.persistence.service;

import java.util.List;

import edu.cibertec.entity.Local;

public interface ILocalService {
	public Local getLocal(Integer id) throws Exception;
	public List<Local> getLocals()	throws Exception;
	public Local registrar(Local local) throws Exception;
	public Local	actualizar(Local local) throws Exception;

	public void eliminar(Integer id) throws Exception;
}
