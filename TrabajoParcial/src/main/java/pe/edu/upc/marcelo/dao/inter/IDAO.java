package pe.edu.upc.marcelo.dao.inter;

import java.util.List;

public interface IDAO<T> {
	void create(T t) throws Exception;
	void update(T t) throws Exception;
	void delete(T t) throws Exception;
	List<T> reader() throws Exception;
}
