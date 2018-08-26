package pe.edu.upc.marcelo.dao.inter;

import java.util.List;

import javax.ejb.Local;

import pe.edu.upc.marcelo.entities.Cliente;

@Local
public interface IClienteDAO extends IDAO<Cliente> {
	public List<Cliente> readerClienteByCI(Cliente cliente);
}
