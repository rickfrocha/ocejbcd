package servicos;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ejbs.MeuEJB;

@Path("/rest")
public class RestService {
	
	@EJB
	private MeuEJB ejb;
	
	@Path("/say")
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String say(){
		return ejb.sayHello();
	}
	
	@Path("/say2")
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String say2(){
		return ejb.sayHello2();
	}
	
	
	@Path("/say3")
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String say3(){
		return ejb.sayHello3();
	}
	
	

}
