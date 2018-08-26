package pe.edu.upc.marcelo.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pe.edu.upc.marcelo.dao.inter.IUserDAO;
import pe.edu.upc.marcelo.entities.User;
import pe.edu.upc.marcelo.service.inter.IUserService;

@Named
@RequestScoped
public class UserService implements IUserService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IUserDAO dao;
	
	@Override
	public void create(User t) throws Exception {
		// TODO Auto-generated method stub
		dao.create(t);
	}

	@Override
	public void update(User t) throws Exception {
		// TODO Auto-generated method stub
		dao.update(t);
	}

	@Override
	public void delete(User t) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(t);
	}

	@Override
	public List<User> reader() throws Exception {
		// TODO Auto-generated method stub
		return dao.reader();
	}

	@Override
	public User readerUser(String email, String password) {
		// TODO Auto-generated method stub
		return dao.readerUser(email, password);
	}

}
