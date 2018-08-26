package pe.edu.upc.marcelo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.marcelo.dao.inter.IClienteDAO;
import pe.edu.upc.marcelo.entities.Cliente;

@Stateless
public class ClienteDAO implements IClienteDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="miluzsrl")
	EntityManager manager;
	
	@Override
	public void create(Cliente t) throws Exception {
		// TODO Auto-generated method stub
		manager.persist(t);
	}

	@Override
	public void update(Cliente t) throws Exception {
		// TODO Auto-generated method stub
		//manager.merge(t);
	}

	@Override
	public void delete(Cliente t) throws Exception {
		// TODO Auto-generated method stub
		//manager.remove(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> reader() throws Exception {
		// TODO Auto-generated method stub
		List<Cliente> clientes = new ArrayList<>();
		Query query = manager.createQuery("FROM Cliente c");
		clientes = (List<Cliente>)query.getResultList();
		return clientes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> readerClienteByCI(Cliente cliente) {
		// TODO Auto-generated method stub
		List<Cliente> clientes = new ArrayList<>();
		Query query = manager.createQuery("FROM Cliente c where c.ci like ?1");
		query.setParameter(1, cliente.getCi() + "%");
		clientes = (List<Cliente>)query.getResultList();
		return clientes;
	}

}
