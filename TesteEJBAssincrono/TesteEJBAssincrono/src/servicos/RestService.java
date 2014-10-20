package servicos;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("rest")
public class RestService {
	
	@GET
	@Produces("text/plain")
	@Path("/ping")
	public String ping(){
		return "pong";
	}

}
