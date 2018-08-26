package pe.edu.upc.marcelo.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pe.edu.upc.marcelo.dao.inter.IGrifoDAO;
import pe.edu.upc.marcelo.entities.Grifo;
import pe.edu.upc.marcelo.service.inter.IGrifoService;

@Named
@RequestScoped
public class GrifoService implements IGrifoService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IGrifoDAO dao;

	@Override
	public void create(Grifo t) throws Exception {
		// TODO Auto-generated method stub
		dao.create(t);
	}

	@Override
	public void update(Grifo t) throws Exception {
		// TODO Auto-generated method stub
		dao.update(t);
	}

	@Override
	public void delete(Grifo t) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(t);
	}

	@Override
	public List<Grifo> reader() throws Exception {
		// TODO Auto-generated method stub
		return dao.reader();
	}

}
