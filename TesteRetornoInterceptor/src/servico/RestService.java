package servico;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejb.MyEJB;

@Path("/rest")
public class RestService {
	
	@EJB
	private MyEJB cliente;
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/teste")
	public String teste(){
		return cliente.teste();
	}

}
