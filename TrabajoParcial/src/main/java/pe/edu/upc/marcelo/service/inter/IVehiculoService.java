package pe.edu.upc.marcelo.service.inter;

import java.util.List;

import pe.edu.upc.marcelo.entities.Vehiculo;

public interface IVehiculoService extends IService<Vehiculo> {
	public List<Vehiculo> readerVehiculoByMatricula(Vehiculo vehiculo);
}
