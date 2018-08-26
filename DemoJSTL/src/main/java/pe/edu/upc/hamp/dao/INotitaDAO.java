package pe.edu.upc.hamp.dao;

import java.util.List;

import pe.edu.upc.hamp.entity.Notita;

public interface INotitaDAO {
	public void create(Notita notita);
	public void update(Notita notita);
	public List<Notita> read();
	public void delete(int id);
	public Notita getById(int id);
}
