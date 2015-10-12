package servicos;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejb.MyEJB;

@Path("/rest")
public class RestService {
	
	@EJB
	private MyEJB ejb;
	
	@GET
	@Path("/teste")
	@Produces(MediaType.TEXT_PLAIN)
	public String ping(){
		ejb.teste();
		return "teste executado!!!";
	}
}
