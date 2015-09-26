package service;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ejbs.MyEJB;

@Path("/service")
public class RestService {

	
	@GET
	@Produces("text/plain")
	@Path("/say/{msg}")
	public String say(@PathParam("msg") String say){
		try {
			Context ctx = new InitialContext();
			MyEJB ejb = (MyEJB) ctx.lookup("java:global/TesteJNDIEJB/MyEJB");
			return ejb.say(say);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return "Erro!!!";
		
	}
}
