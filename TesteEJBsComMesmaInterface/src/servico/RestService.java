package servico;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejb.SaudacoesInterface;

@Path("/rest")
@EJB( 
     name="meuApelidoDado", 
     beanInterface=SaudacoesInterface.class)
public class RestService {
	
	//@EJB(lookup="ejb/saudacoesPortugues") //funciona
	//@EJB(name="ejb/saudacoesPortugues") //funciona
	//@EJB(name="saudacoesPortugues") //funciona
	//@EJB(beanName="ejb/saudacoesPortugues") //NAO funciona
	//@EJB
		/*
	         Como existem dois ejbs com o mesmo nome, deve ser especificado o "beanName" para diferencia-lo
	         Se fosse uma interface remota, deveria utilizar um lookup
	         Se não informar a interface será lançado uma exceção pois o container não saberá qual injetar
	     */
	private SaudacoesInterface saudacoes;
	
	@PostConstruct
	public void init(){
		try {
			Context context = new InitialContext();
			saudacoes = (SaudacoesInterface) context.lookup("java:comp/env/meuApelidoDado");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/saudacoes/portugues/{nome}")
	public String saudacoesPortugues(@PathParam("nome") String nome) {
		return saudacoes.digaOla(nome);
	}
	
}
