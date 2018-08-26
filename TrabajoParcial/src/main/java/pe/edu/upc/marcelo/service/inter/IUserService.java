package pe.edu.upc.marcelo.service.inter;

import pe.edu.upc.marcelo.entities.User;

public interface IUserService extends IService<User> {
	public User readerUser(String email, String password);
}
