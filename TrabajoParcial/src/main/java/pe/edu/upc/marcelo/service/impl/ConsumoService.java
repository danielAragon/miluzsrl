package pe.edu.upc.marcelo.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pe.edu.upc.marcelo.dao.inter.IConsumoDAO;
import pe.edu.upc.marcelo.entities.Consumo;
import pe.edu.upc.marcelo.service.inter.IConsumoService;

@Named
@RequestScoped
public class ConsumoService implements IConsumoService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IConsumoDAO dao;

	@Override
	public void create(Consumo t) throws Exception {
		// TODO Auto-generated method stub
		dao.create(t);
	}

	@Override
	public void update(Consumo t) throws Exception {
		// TODO Auto-generated method stub
		//dao.update(t);
	}

	@Override
	public void delete(Consumo t) throws Exception {
		// TODO Auto-generated method stub
		//dao.delete(t);
	}

	@Override
	public List<Consumo> reader() throws Exception {
		// TODO Auto-generated method stub
		return dao.reader();
	}

	@Override
	public double CalculaMontoTotal(Consumo consumo) {
		// TODO Auto-generated method stub
		int cantidad = consumo.getCantidad();
		double precio = consumo.getTipocombustible().getPrecioventa();
		double descuento = consumo.getDescuento();
		
		double pago = cantidad*precio*(1-descuento);
		
		double pagomostrado = Math.round(pago * Math.pow(10, 2)) / Math.pow(10, 2);
		
		return pagomostrado;
	}

}
