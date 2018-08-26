package pe.edu.upc.hamp.dao;

import java.util.List;

import pe.edu.upc.hamp.entity.Nota;

public interface INotaDAO {
	public void create(Nota c);
	public void delete(int id);
	public void update(Nota c);
	public List<Nota> reader();
	public Nota getById(int id);
}
