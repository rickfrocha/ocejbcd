package servicos;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import EJB.MyEJB;
import EJB.TwoEJB;

@Path("/rest")
public class RestService {
	
	@EJB
	private MyEJB ejb;
	
	@EJB
	private TwoEJB two;
	
	
	@Path("/obter")
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public Integer obter(){
		return ejb.obterValorTipoLog();
	}
	
	@Path("/porta")
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public Integer porta(){
		return two.obterPortaAcesso();
	}

	@Path("/email")
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String email(){
		return ejb.obterEmail();
	}

	
	@Path("/smtp/{id}")
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String smtp(@PathParam("id") Integer id){
		String retorno=null;
		try{
			switch (id) {
			case 1:
				retorno = ejb.obterSMTPLookup1();
				break;
			case 2:
				retorno = ejb.obterSMTPLookup2();
				break;
			case 3:
				retorno = ejb.obterSMTPLookup3();
				break;
	
			default:
				retorno = "Nao identificado!";
				break;
			}
		} catch(Exception e){
			System.out.println("Erro: "+e.getMessage() );
		}
		return retorno;
	}
	
}
