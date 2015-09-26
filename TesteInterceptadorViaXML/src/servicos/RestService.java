package servicos;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ejbs.MyEJB;

@Path("/rest")
public class RestService {
	
	@EJB
	private MyEJB ejb;
	
	@Path("/say/{name}")
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String say(@PathParam("name") String name){
		return ejb.say(name);
	}

}
