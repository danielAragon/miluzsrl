package pe.edu.upc.marcelo.dao.inter;

import java.util.List;

import javax.ejb.Local;

import pe.edu.upc.marcelo.entities.Operador;

@Local
public interface IOperadorDAO extends IDAO<Operador> {
	public List<Operador> readerOperadorByCI(Operador operador);
}
