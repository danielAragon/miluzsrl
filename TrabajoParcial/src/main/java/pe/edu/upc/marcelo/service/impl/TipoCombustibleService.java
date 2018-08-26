package pe.edu.upc.marcelo.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pe.edu.upc.marcelo.dao.inter.ITipoCombustibleDAO;
import pe.edu.upc.marcelo.entities.Tipocombustible;
import pe.edu.upc.marcelo.service.inter.ITipoCombustibleService;

@Named
@RequestScoped
public class TipoCombustibleService implements ITipoCombustibleService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ITipoCombustibleDAO dao;

	@Override
	public void create(Tipocombustible t) throws Exception {
		// TODO Auto-generated method stub
		dao.create(t);
	}

	@Override
	public void update(Tipocombustible t) throws Exception {
		// TODO Auto-generated method stub
		dao.update(t);
	}

	@Override
	public void delete(Tipocombustible t) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(t);
	}

	@Override
	public List<Tipocombustible> reader() throws Exception {
		// TODO Auto-generated method stub
		return dao.reader();
	}

}
