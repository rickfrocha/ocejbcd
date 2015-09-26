package servicos;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/teste")
@Produces({"text/plain"})
public class TesteRest {
	
	@GET
	@Path("/ping")
	public String ping(){
		return "pong";
	}

}
