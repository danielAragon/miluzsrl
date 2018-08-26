package pe.edu.upc.marcelo.service.inter;

import pe.edu.upc.marcelo.entities.Consumo;

public interface IConsumoService extends IService<Consumo> {
	public double CalculaMontoTotal(Consumo consumo);
}
