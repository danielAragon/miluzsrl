package pe.edu.upc.marcelo.service.inter;

import java.util.List;

import pe.edu.upc.marcelo.entities.Cliente;

public interface IClienteService extends IService<Cliente> {
	public List<Cliente> readerClienteByCI(Cliente cliente);
}
