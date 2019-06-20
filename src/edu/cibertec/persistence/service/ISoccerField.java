package edu.cibertec.persistence.service;

import java.util.List;

import edu.cibertec.entity.SoccerField;

public interface ISoccerField {
	
	public SoccerField getSoccerField(Integer id) throws Exception;
	public List<SoccerField> getSoccerFields()	throws Exception;
	public List<SoccerField> getSoccerFieldsXLocal(int id)	throws Exception;
	public SoccerField registrar(SoccerField SoccerField) throws Exception;
	public SoccerField	actualizar(SoccerField SoccerField) throws Exception;

	public void eliminar(Integer id) throws Exception;
}
