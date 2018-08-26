package pe.edu.upc.marcelo.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.marcelo.entities.User;
import pe.edu.upc.marcelo.service.inter.IUserService;

@Named
@ViewScoped
public class UserController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IUserService userService;
	
	User user;
	
	@PostConstruct
	public void init() {
		user = new User();
	}
	
	public String login() {
		String view = "";
		try {
			user = userService.readerUser(user.getEmail(), user.getPassword());
			if(user.getId() > 0)
				view = "panel.xhtml";
			else
				view = "index.xhtml";
		} catch (Exception e) {
			// TODO: handle exception
			view = "index.xhtml";
		}
		return view;
	}
	
	public String logout() {
		String view = "";
		try {
			view = "index.xhtml";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return view;
	}
	
	//=====================================================//

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
