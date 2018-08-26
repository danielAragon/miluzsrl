package pe.edu.upc.marcelo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.marcelo.entities.Grifo;
import pe.edu.upc.marcelo.entities.Operador;
import pe.edu.upc.marcelo.service.inter.IGrifoService;
import pe.edu.upc.marcelo.service.inter.IOperadorService;

@Named
@ViewScoped
public class OperadorController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IOperadorService operadorService;
	
	@Inject
	private IGrifoService grifoService;
	
	Operador operador;
	List<Operador> listOperadores;
	
	Grifo grifo;
	List<Grifo> listGrifos;
	
	@PostConstruct
	public void init() {
		this.operador = new Operador();
		this.listOperadores = new ArrayList<>();
		this.grifo = new Grifo();
		this.listGrifos = new ArrayList<>();
		this.listOperadores();
		this.listGrifos();
	}

	public String newOperador() {
		this.setOperador(new Operador());
		return "operador_create.xhtml";
	}
	
	public void createOperador() {
		try {
			operador.setGrifo(operador.getGrifo());
			operadorService.create(operador);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateOperador() {
		try {
			//operador.setGrifo(operador.getGrifo());
			operadorService.update(operador);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void deleteOperador() {
		try {
			operadorService.delete(operador);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void listOperadores() {
		// TODO Auto-generated method stub
		try {
			listOperadores = operadorService.reader();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void listGrifos() {
		// TODO Auto-generated method stub
		try {
			listGrifos = grifoService.reader();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void findOperadorByCI() {
		try {
			if(operador.getCi().isEmpty()) {
				listOperadores();
			} else {
				listOperadores = this.operadorService.readerOperadorByCI(this.getOperador());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void clearOperador() {
		init();
	}

	//==================================================================//
	
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

	public Grifo getGrifo() {
		return grifo;
	}

	public void setGrifo(Grifo grifo) {
		this.grifo = grifo;
	}

	public List<Grifo> getListGrifos() {
		return listGrifos;
	}

	public void setListGrifos(List<Grifo> listGrifos) {
		this.listGrifos = listGrifos;
	}
}
