package pe.edu.upc.marcelo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.marcelo.entities.Tipocombustible;
import pe.edu.upc.marcelo.service.inter.ITipoCombustibleService;

@Named
@ViewScoped
public class TipoCombustibleController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITipoCombustibleService tipocombustibleService;
	
	Tipocombustible tipocombustible;
	List<Tipocombustible> listTipoCombustibles;
	
	@PostConstruct
	public void init() {
		this.tipocombustible = new Tipocombustible();
		this.listTipoCombustibles = new ArrayList<>();
		this.listTipoCombustible();
	}
	
	public String newTipoCombustible() {
		this.setTipocombustible(new Tipocombustible());
		return "tipocombustible_create.xhtml";
	}
	
	public void createTipoCombustible() {
		try {
			tipocombustibleService.create(tipocombustible);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updateTipoCombustible() {
		try {
			tipocombustibleService.update(tipocombustible);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void deleteTipoCombustible() {
		try {
			tipocombustibleService.delete(tipocombustible);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void listTipoCombustible() {
		// TODO Auto-generated method stub
		try {
			listTipoCombustibles = tipocombustibleService.reader();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void clearTipoCombustible() {
		init();
	}
	
	//========================================================================//

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

}
