package pe.edu.upc.marcelo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.marcelo.dao.inter.ITipoCombustibleDAO;
import pe.edu.upc.marcelo.entities.Tipocombustible;

@Stateless
public class TipoCombustibleDAO implements ITipoCombustibleDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="miluzsrl")
	EntityManager manager;
	
	@Override
	public void create(Tipocombustible t) throws Exception {
		// TODO Auto-generated method stub
		manager.persist(t);
	}

	@Override
	public void update(Tipocombustible t) throws Exception {
		// TODO Auto-generated method stub
		manager.merge(t);
	}

	@Override
	public void delete(Tipocombustible t) throws Exception {
		// TODO Auto-generated method stub
		manager.remove(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tipocombustible> reader() throws Exception {
		// TODO Auto-generated method stub
		List<Tipocombustible> tipocombustibles = new ArrayList<>();
		Query query = manager.createQuery("FROM Tipocombustible t");
		tipocombustibles = (List<Tipocombustible>)query.getResultList();
		return tipocombustibles;
	}

}
