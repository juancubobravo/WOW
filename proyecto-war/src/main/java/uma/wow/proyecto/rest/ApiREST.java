package uma.wow.proyecto.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("")
public class ApiREST {
	
	@Path("/healthcheck")
	@GET
	public Response getHealthcheck() {
		
		return Response.ok().build();
	
}

}
