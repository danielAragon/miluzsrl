package pe.edu.upc.marcelo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.marcelo.dao.inter.IOperadorDAO;
import pe.edu.upc.marcelo.entities.Operador;

@Stateless
public class OperadorDAO implements IOperadorDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="miluzsrl")
	EntityManager manager;
	
	@Override
	public void create(Operador t) throws Exception {
		// TODO Auto-generated method stub
		manager.persist(t);
	}

	@Override
	public void update(Operador t) throws Exception {
		// TODO Auto-generated method stub
		manager.merge(t);
	}

	@Override
	public void delete(Operador t) throws Exception {
		// TODO Auto-generated method stub
		manager.remove(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Operador> reader() throws Exception {
		// TODO Auto-generated method stub
		List<Operador> operadores = new ArrayList<>();
		Query query = manager.createQuery("FROM Operador o");
		operadores=(List<Operador>)query.getResultList();
		return operadores;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Operador> readerOperadorByCI(Operador operador) {
		// TODO Auto-generated method stub
		List<Operador> operadores = new ArrayList<>();
		Query query = manager.createQuery("FROM Operador o where o.ci like ?1");
		query.setParameter(1, operador.getCi() + "%");
		operadores = (List<Operador>)query.getResultList();
		return operadores;
	}

}
