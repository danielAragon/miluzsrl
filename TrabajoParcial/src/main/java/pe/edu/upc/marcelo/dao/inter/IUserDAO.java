package pe.edu.upc.marcelo.dao.inter;

import javax.ejb.Local;

import pe.edu.upc.marcelo.entities.User;

@Local
public interface IUserDAO extends IDAO<User> {
	public User readerUser(String email, String password);
}
