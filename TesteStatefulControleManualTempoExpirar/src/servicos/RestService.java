package servicos;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ejb.MeuEJBStateful;

@Path("/rest")
public class RestService {
	
	@EJB
	private MeuEJBStateful ejb;
	
	@Path("/add/{msg}")
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public void add(@PathParam("msg") String msg){
		ejb.adicionarMensagem(msg);
	}
	
	@Path("/obter")
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public List<String> obter(@PathParam("msg") String msg){
		return ejb.obterMensagens();
	}
	
	@Path("/checkout")
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public void checkout(){
		ejb.destruir();
	}
	

}
