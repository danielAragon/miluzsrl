package pe.edu.upc.marcelo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.marcelo.dao.inter.IConsumoDAO;
import pe.edu.upc.marcelo.entities.Consumo;

@Stateless
public class ConsumoDAO implements IConsumoDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="miluzsrl")
	EntityManager manager;
	
	@Override
	public void create(Consumo t) throws Exception {
		// TODO Auto-generated method stub
		manager.persist(t);
	}

	@Override
	public void update(Consumo t) throws Exception {
		// TODO Auto-generated method stub
		//manager.merge(t);
	}

	@Override
	public void delete(Consumo t) throws Exception {
		// TODO Auto-generated method stub
		//manager.remove(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Consumo> reader() throws Exception {
		// TODO Auto-generated method stub
		List<Consumo> consumos = new ArrayList<>();
		Query query = manager.createQuery("FROM Consumo c");
		consumos = (List<Consumo>)query.getResultList();
		return consumos;
	}

}
