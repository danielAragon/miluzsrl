package pe.edu.upc.marcelo.service.inter;

import java.util.List;

import pe.edu.upc.marcelo.entities.Operador;

public interface IOperadorService extends IService<Operador> {
	public List<Operador> readerOperadorByCI(Operador operador);
}
