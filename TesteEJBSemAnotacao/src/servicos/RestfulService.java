package servicos;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ejbs.MyEJBLocal;

@Path("/rest")
public class RestfulService {
	
	@EJB
	private MyEJBLocal myEJB;
	
	@GET
	@Produces("text/plain")
	@Path("/say/{msg}")
	public String say(@PathParam("msg") String msg){
		return myEJB.say(msg);
	}

}
