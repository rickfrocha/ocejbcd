package servico;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rest")
public class RestService {
	
	@EJB
	private MyEJB cliente;
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/testeA")
	public String teste(){
		return cliente.testeA();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/testeB")
	public String testeB(){
		return cliente.testeB();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/testeC")
	public String testeC(){
		return cliente.testeC();
	}
	
	
}
