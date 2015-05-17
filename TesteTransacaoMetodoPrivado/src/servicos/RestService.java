package servicos;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejbs.TesteBean;

@Path("/rest")
public class RestService {
	
	@EJB
	private TesteBean ejb;
	
	
	@GET
	@Path("/testeEJB")
	@Produces(MediaType.TEXT_PLAIN)
	public String sendTesteEJB(){
		return ejb.sayWithTransaction();
	}
	
	
	@GET
	@Path("/testeEJB2")
	@Produces(MediaType.TEXT_PLAIN)
	public String sendTesteEJB2(){
		return ejb.sayWithTransactionByInterface(); //gera exceção
	}
	
	
	
}
