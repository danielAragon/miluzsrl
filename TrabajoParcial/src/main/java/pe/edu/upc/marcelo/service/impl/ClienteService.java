package pe.edu.upc.marcelo.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pe.edu.upc.marcelo.dao.inter.IClienteDAO;
import pe.edu.upc.marcelo.entities.Cliente;
import pe.edu.upc.marcelo.service.inter.IClienteService;

@Named
@RequestScoped
public class ClienteService implements IClienteService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IClienteDAO dao;
	
	@Override
	public void create(Cliente t) throws Exception {
		// TODO Auto-generated method stub
		dao.create(t);
	}

	@Override
	public void update(Cliente t) throws Exception {
		// TODO Auto-generated method stub
		//dao.update(t);
	}

	@Override
	public void delete(Cliente t) throws Exception {
		// TODO Auto-generated method stub
		//dao.delete(t);
	}

	@Override
	public List<Cliente> reader() throws Exception {
		// TODO Auto-generated method stub
		return dao.reader();
	}

	@Override
	public List<Cliente> readerClienteByCI(Cliente cliente) {
		// TODO Auto-generated method stub
		return dao.readerClienteByCI(cliente);
	}

}
