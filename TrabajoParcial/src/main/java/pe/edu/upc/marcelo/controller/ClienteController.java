package pe.edu.upc.marcelo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.marcelo.entities.Cliente;
import pe.edu.upc.marcelo.service.inter.IClienteService;

@Named
@ViewScoped
public class ClienteController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IClienteService clienteService;
	
	Cliente cliente;
	List<Cliente> listClientes;
	
	@PostConstruct
	public void init() {
		this.cliente = new Cliente();
		this.listClientes = new ArrayList<>();
		this.listClientes();
	}

	public String newCliente() {
		this.setCliente(new Cliente());
		return "cliente_create.xhtml";
	}
	
	public void createCliente() {
		try {
			clienteService.create(cliente);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
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
	
	public void findClienteByCI() {
		try {
			if(cliente.getCi().isEmpty()) {
				this.listClientes();
			} else {
				listClientes = this.clienteService.readerClienteByCI(this.getCliente());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void clearCliente() {
		init();
	}

	//=======================================================//
	
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