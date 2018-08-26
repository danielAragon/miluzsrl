package pe.edu.upc.marcelo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.marcelo.entities.Grifo;
import pe.edu.upc.marcelo.service.inter.IGrifoService;

@Named
@ViewScoped
public class GrifoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IGrifoService grifoService;
	
	Grifo grifo;
	List<Grifo> listGrifos;
	
	@PostConstruct
	public void init() {
		this.grifo = new Grifo();
		this.listGrifos = new ArrayList<>();
		this.ListGrifos();
	}

	public String newGrifo() {
		this.setGrifo(new Grifo());
		return "grifo_create.xhtml";
	}
	
	public void createGrifo() {
		try {
			grifoService.create(grifo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateGrifo() {
		try {
			grifoService.update(grifo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void deleteGrifo() {
		try {
			grifoService.delete(grifo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void ListGrifos() {
		// TODO Auto-generated method stub
		try {
			listGrifos = grifoService.reader();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void clearGrifo() {
		init();
	}
	
	//====================================================//

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
