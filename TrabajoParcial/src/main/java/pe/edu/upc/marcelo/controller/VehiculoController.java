package pe.edu.upc.marcelo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.marcelo.entities.Vehiculo;
import pe.edu.upc.marcelo.service.inter.IVehiculoService;

@Named
@ViewScoped
public class VehiculoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IVehiculoService vehiculoService;
	
	Vehiculo vehiculo;
	List<Vehiculo> listVehiculos;
	
	@PostConstruct
	public void init() {
		this.vehiculo = new Vehiculo();
		this.listVehiculos = new ArrayList<>();
		this.listVehiculos();
	}
	
	public String newVehiculo() {
		this.setVehiculo(new Vehiculo());
		return "vehiculo_create.xhtml";
	}
	
	public void createVehiculo() {
		try {
			vehiculoService.create(vehiculo);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void listVehiculos() {
		// TODO Auto-generated method stub
		try {
			listVehiculos = vehiculoService.reader();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void findVehiculoByMatricula() {
		try {
			if(vehiculo.getMatricula().isEmpty()) {
				listVehiculos();
			} else {
				listVehiculos = this.vehiculoService.readerVehiculoByMatricula(this.getVehiculo());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void clearVehiculo() {
		init();
	}
	
	//===========================================================//

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public List<Vehiculo> getListVehiculos() {
		return listVehiculos;
	}

	public void setListVehiculos(List<Vehiculo> listVehiculos) {
		this.listVehiculos = listVehiculos;
	}
}
