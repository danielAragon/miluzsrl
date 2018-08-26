package pe.edu.upc.marcelo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.marcelo.entities.Cliente;
import pe.edu.upc.marcelo.entities.Consumo;
import pe.edu.upc.marcelo.entities.Operador;
import pe.edu.upc.marcelo.entities.Tipocombustible;
import pe.edu.upc.marcelo.entities.Vehiculo;
import pe.edu.upc.marcelo.service.inter.IClienteService;
import pe.edu.upc.marcelo.service.inter.IConsumoService;
import pe.edu.upc.marcelo.service.inter.IOperadorService;
import pe.edu.upc.marcelo.service.inter.ITipoCombustibleService;
import pe.edu.upc.marcelo.service.inter.IVehiculoService;

@Named
@ViewScoped
public class ConsumoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IConsumoService consumoService;
	
	@Inject
	private IOperadorService operadorService;
	
	@Inject
	private ITipoCombustibleService tipocombustibleService;
	
	@Inject
	private IVehiculoService vehiculoService;
	
	@Inject
	private IClienteService clienteService;
	
	Consumo consumo;
	List<Consumo> listConsumos;
	
	Operador operador;
	List<Operador> listOperadores;
	
	Tipocombustible tipocombustible;
	List<Tipocombustible> listTipoCombustibles;
	
	Vehiculo vehiculo;
	List<Vehiculo> listVehiculos;
	
	Cliente cliente;
	List<Cliente> listClientes;
	
	@PostConstruct 
	public void init() {
		this.consumo = new Consumo();
		this.listConsumos = new ArrayList<>();
		this.operador = new Operador();
		this.listOperadores = new ArrayList<>();
		this.tipocombustible = new Tipocombustible();
		this.listTipoCombustibles = new ArrayList<>();
		this.vehiculo = new Vehiculo();
		this.listVehiculos = new ArrayList<>();
		this.cliente = new Cliente();
		this.listClientes = new ArrayList<>();
		
		this.listConsumos();
		this.listOperadores();
		this.listTipoCombustibles();
		this.listVehiculos();
		this.listClientes();
	}
	
	public String newConsumo() {
		this.setConsumo(new Consumo());
		return "consumo_create.xhtml";
	}
	
	public void createConsumo() {
		try {
			consumo.setOperador(consumo.getOperador());
			consumo.setTipocombustible(consumo.getTipocombustible());
			consumo.setCliente(consumo.getCliente());
			consumo.setVehiculo(consumo.getVehiculo());
			
			consumoService.create(consumo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public double calculaMonto(Consumo c) {
		double monto = this.consumoService.CalculaMontoTotal(c);
		return monto;
	}
	
	private void listClientes() {
		// TODO Auto-generated method stub
		try {
			listClientes = clienteService.reader();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void listVehiculos() {
		// TODO Auto-generated method stub
		try {
			listVehiculos = vehiculoService.reader();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void listTipoCombustibles() {
		// TODO Auto-generated method stub
		try {
			listTipoCombustibles = tipocombustibleService.reader();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void listOperadores() {
		// TODO Auto-generated method stub
		try {
			listOperadores = operadorService.reader();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void listConsumos() {
		// TODO Auto-generated method stub
		try {
			listConsumos = consumoService.reader();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clearConsumo() {
		init();
	}

	//=====================================================================//
	
	public Consumo getConsumo() {
		return consumo;
	}
	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}
	public List<Consumo> getListConsumos() {
		return listConsumos;
	}
	public void setListConsumos(List<Consumo> listConsumos) {
		this.listConsumos = listConsumos;
	}
	public Operador getOperador() {
		return operador;
	}
	public void setOperador(Operador operador) {
		this.operador = operador;
	}
	public List<Operador> getListOperadores() {
		return listOperadores;
	}
	public void setListOperadores(List<Operador> listOperadores) {
		this.listOperadores = listOperadores;
	}
	public Tipocombustible getTipocombustible() {
		return tipocombustible;
	}
	public void setTipocombustible(Tipocombustible tipocombustible) {
		this.tipocombustible = tipocombustible;
	}
	public List<Tipocombustible> getListTipoCombustibles() {
		return listTipoCombustibles;
	}
	public void setListTipoCombustibles(List<Tipocombustible> listTipoCombustibles) {
		this.listTipoCombustibles = listTipoCombustibles;
	}
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Cliente> getListClientes() {
		return listClientes;
	}
	public void setListClientes(List<Cliente> listClientes) {
		this.listClientes = listClientes;
	}
}
