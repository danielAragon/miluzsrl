package pe.edu.upc.marcelo.service.inter;

import java.util.List;

public interface IService<T> {
	void create(T t) throws Exception;
	void update(T t) throws Exception;
	void delete(T t) throws Exception;
	List<T> reader() throws Exception;
}