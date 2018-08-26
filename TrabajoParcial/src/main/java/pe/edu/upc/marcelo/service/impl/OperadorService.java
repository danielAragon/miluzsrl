package pe.edu.upc.marcelo.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pe.edu.upc.marcelo.dao.inter.IOperadorDAO;
import pe.edu.upc.marcelo.entities.Operador;
import pe.edu.upc.marcelo.service.inter.IOperadorService;

@Named
@RequestScoped
public class OperadorService implements IOperadorService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IOperadorDAO dao;

	@Override
	public void create(Operador t) throws Exception {
		// TODO Auto-generated method stub
		dao.create(t);
	}

	@Override
	public void update(Operador t) throws Exception {
		// TODO Auto-generated method stub
		dao.update(t);
	}

	@Override
	public void delete(Operador t) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(t);
	}

	@Override
	public List<Operador> reader() throws Exception {
		// TODO Auto-generated method stub
		return dao.reader();
	}

	@Override
	public List<Operador> readerOperadorByCI(Operador operador) {
		// TODO Auto-generated method stub
		return dao.readerOperadorByCI(operador);
	}

}
