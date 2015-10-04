package servico;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejb.MyEJB;
import ejb.MyEJBLocal;
import ejb.MyEJBRemote;

@Path("/rest")
public class RestService {
	
	@EJB
	private MyEJB cliente1;

	@EJB
	private MyEJB cliente2;

	@EJB
	private MyEJBLocal clienteLocal1;
	
	@EJB
	private MyEJBLocal clienteLocal2;
	
	@EJB
	private MyEJBRemote clienteRemoto1;
	
	@EJB
	private MyEJBRemote clienteRemoto2;
	
	
	@PostConstruct
	public void init(){
		System.out.println("cliente sem interface 1 = cliente sem interface 2"+ cliente1.equals(cliente2));
		System.out.println("cliente local1 = cliente local2"+ clienteLocal1.equals(clienteLocal2));
		System.out.println("cliente remoto1 = cliente remoto2"+ clienteRemoto1.equals(clienteRemoto2));
		//
		System.out.println("cliente sem interface 1 = cliente local 1"+ cliente1.equals(clienteLocal1));
		System.out.println("cliente sem interface 1 = cliente remoto 1"+ cliente1.equals(clienteRemoto1));
	}
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/teste")
	public String teste(){
		return cliente1.teste();
	}

}
