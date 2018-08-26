package pe.edu.upc.marcelo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.marcelo.dao.inter.IGrifoDAO;
import pe.edu.upc.marcelo.entities.Grifo;

@Stateless
public class GrifoDAO implements IGrifoDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="miluzsrl")
	EntityManager manager;
	
	@Override
	public void create(Grifo t) throws Exception {
		// TODO Auto-generated method stub
		manager.persist(t);
	}

	@Override
	public void update(Grifo t) throws Exception {
		// TODO Auto-generated method stub
		manager.merge(t);
	}

	@Override
	public void delete(Grifo t) throws Exception {
		// TODO Auto-generated method stub
		manager.remove(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grifo> reader() throws Exception {
		// TODO Auto-generated method stub
		List<Grifo> grifos = new ArrayList<>();
		Query query = manager.createQuery("FROM Grifo g");
		grifos = (List<Grifo>)query.getResultList();
		return grifos;
	}

}
