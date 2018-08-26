package pe.edu.upc.marcelo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.marcelo.dao.inter.IVehiculoDAO;
import pe.edu.upc.marcelo.entities.Vehiculo;

@Stateless
public class VehiculoDAO implements IVehiculoDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="miluzsrl")
	EntityManager manager;
	
	@Override
	public void create(Vehiculo t) throws Exception {
		// TODO Auto-generated method stub
		manager.persist(t);
	}

	@Override
	public void update(Vehiculo t) throws Exception {
		// TODO Auto-generated method stub
		//manager.merge(t);
	}

	@Override
	public void delete(Vehiculo t) throws Exception {
		// TODO Auto-generated method stub
		//manager.remove(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> reader() throws Exception {
		// TODO Auto-generated method stub
		List<Vehiculo> vehiculos = new ArrayList<>();
		Query query = manager.createQuery("FROM Vehiculo v");
		vehiculos = (List<Vehiculo>)query.getResultList();
		return vehiculos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> readerVehiculoByMatricula(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		List<Vehiculo> vehiculos = new ArrayList<>();
		Query query = manager.createQuery("FROM Vehiculo v where v.matricula like ?1");
		query.setParameter(1,vehiculo.getMatricula()+"%");
		vehiculos = (List<Vehiculo>)query.getResultList();
		return vehiculos;
	}

}
