package edu.cibertec.persistence.service;

import java.util.List;

import org.apache.log4j.Logger;

import edu.cibertec.entity.Local;
import edu.cibertec.entity.SoccerField;
import edu.cibertec.persistence.jpa.dao.LocalJPA;
import edu.cibertec.persistence.jpa.dao.SoccerFieldJPA;

public class SoccerFieldServiceImpl implements ISoccerField{
	static final Logger log = Logger.getLogger(SoccerFieldServiceImpl.class);
	SoccerFieldJPA soccerJPA = new SoccerFieldJPA();
	@Override
	public SoccerField getSoccerField(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SoccerField> getSoccerFields() throws Exception {
		log.info("Se ingreso a getSoccerFields()");
		List<SoccerField>soccList= null;

		soccerJPA.createEM();
		soccList= soccerJPA.getAll();
		soccerJPA.releaseEM();
		
		log.info("Saliendo de getSoccerFields()");
		
		return soccList;
	}

	@Override
	public SoccerField registrar(SoccerField SoccerField) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SoccerField actualizar(SoccerField SoccerField) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SoccerField> getSoccerFieldsXLocal(int id) throws Exception {
		log.info("Se ingreso a getSoccerFieldsXLocal()");
		List<SoccerField>soccList= null;

		soccerJPA.createEM();
		soccList= soccerJPA.getAllxLocal(id);
		soccerJPA.releaseEM();
		
		log.info("Saliendo de getSoccerFieldsXLocal()");
		
		return soccList;
	}

}
