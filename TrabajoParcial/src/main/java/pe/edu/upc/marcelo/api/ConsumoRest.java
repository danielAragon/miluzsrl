package pe.edu.upc.marcelo.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import pe.edu.upc.marcelo.entities.Consumo;
import pe.edu.upc.marcelo.service.inter.IConsumoService;

@Path("/v1/consumos")
public class ConsumoRest {

	@Inject
	IConsumoService consumoService;
	
	Gson gson;

	@PostConstruct
	void init() {
		gson = new Gson();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response create(Consumo c) {

		String out = "";

		try {
			consumoService.create(c);
			out = gson.toJson("Consumo Registrado");
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

		return Response.status(Response.Status.OK).entity(out).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listConsumos() {
		
		List<Consumo> consumos = new ArrayList<>();
		String out = "";
		System.out.print("holasholasholas");
		try {
			consumos = consumoService.reader();
			out = gson.toJson(consumos);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

		return Response.status(Response.Status.OK).entity(out).build();
	}
	
}
