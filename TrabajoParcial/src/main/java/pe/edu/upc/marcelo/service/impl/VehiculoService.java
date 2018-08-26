package pe.edu.upc.marcelo.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pe.edu.upc.marcelo.dao.inter.IVehiculoDAO;
import pe.edu.upc.marcelo.entities.Vehiculo;
import pe.edu.upc.marcelo.service.inter.IVehiculoService;

@Named
@RequestScoped
public class VehiculoService implements IVehiculoService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IVehiculoDAO dao;

	@Override
	public void create(Vehiculo t) throws Exception {
		// TODO Auto-generated method stub
		dao.create(t);
	}

	@Override
	public void update(Vehiculo t) throws Exception {
		// TODO Auto-generated method stub
		//dao.update(t);
	}

	@Override
	public void delete(Vehiculo t) throws Exception {
		// TODO Auto-generated method stub
		//dao.delete(t);
	}

	@Override
	public List<Vehiculo> reader() throws Exception {
		// TODO Auto-generated method stub
		return dao.reader();
	}

	@Override
	public List<Vehiculo> readerVehiculoByMatricula(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		return dao.readerVehiculoByMatricula(vehiculo);
	}

}
