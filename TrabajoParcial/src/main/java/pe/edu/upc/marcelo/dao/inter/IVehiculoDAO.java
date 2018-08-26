package pe.edu.upc.marcelo.dao.inter;

import java.util.List;

import javax.ejb.Local;

import pe.edu.upc.marcelo.entities.Vehiculo;

@Local
public interface IVehiculoDAO extends IDAO<Vehiculo> {
	public List<Vehiculo> readerVehiculoByMatricula(Vehiculo vehiculo);
}
