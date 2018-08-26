package pe.edu.upc.marcelo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.marcelo.dao.inter.IUserDAO;
import pe.edu.upc.marcelo.entities.User;

@Stateless
public class UserDAO implements IUserDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="miluzsrl")
	EntityManager manager;
	
	@Override
	public void create(User t) throws Exception {
		// TODO Auto-generated method stub
		manager.persist(t);
	}

	@Override
	public void update(User t) throws Exception {
		// TODO Auto-generated method stub
		manager.merge(t);
	}

	@Override
	public void delete(User t) throws Exception {
		// TODO Auto-generated method stub
		manager.remove(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> reader() throws Exception {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<>();
		Query query = manager.createQuery("FROM User u");
		users = (List<User>)query.getResultList();
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User readerUser(String email, String password) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<>();
		User user = new User();
		Query query = manager.createQuery("FROM User u where u.email = ?1 and u.password = ?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		users = (List<User>)query.getResultList();
		if(users != null && !users.isEmpty()) {
			user = users.get(0);
		}
		return user;
	}

}
