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

import pe.edu.upc.marcelo.entities.Grifo;
import pe.edu.upc.marcelo.service.inter.IGrifoService;

@Path("/v1/grifo")
public class GrifoRest {
	@Inject
	private IGrifoService grifoService;
	
	private Gson gson;
	
	@PostConstruct
	public void init() {
		gson = new Gson();
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createGrifo(Grifo g) {
		String out = "";
		try {
			grifoService.create(g);
			out = gson.toJson("Grifo Registrado");
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		return Response.status(Response.Status.OK).entity(out).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGrifos() {
		
		List<Grifo> grifos = new ArrayList<>();
		String out = "";
		
		try {
			grifos = grifoService.reader();
			out = gson.toJson(grifos);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

		return Response.status(Response.Status.OK).entity(out).build();
	}
}
