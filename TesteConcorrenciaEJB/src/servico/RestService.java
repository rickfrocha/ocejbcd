package servico;

import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejb.ConcorrenciaStateful;
import ejb.ConcorrenciaStateless;

@Path("/rest")
public class RestService {
	
	@EJB
	private ConcorrenciaStateless beanStateless;
	
	@EJB
	private ConcorrenciaStateful beanStateful;
	
	/**
	 * Utilizará uma instancia para cada thread para executar os metodos que nao irão se sobrepor (executa 1 e espera ate o fim para terminar)
	 */	
	private void runTestStatelessThread(){
		Thread threadSlow = new Thread(){
			public void run(){
			   beanStateless.slowMethod();	
			}
		};
		
		Thread threadFast = new Thread(){
			public void run(){
			   beanStateless.fastMethod();	
			}
		};
		
		threadSlow.start();
		threadFast.start();		
	}
	
	/**
	 * Utilizará a mesma instancia para executar os metodos que irão se sobrepor (executados ao mesmo tempo)
	 */
	private void runTestStatefulThead(){
		Thread threadSlow = new Thread(){
			public void run(){
				beanStateful.slowMethod();	
			}
		};
		
		Thread threadFast = new Thread(){
			public void run(){
				beanStateful.fastMethod();	
			}
		};
		
		threadSlow.start();
		threadFast.start();		
	}
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/testSL")
	public String initStateless() throws NamingException, JMSException{
		runTestStatelessThread();
		return "thread stateless executada com sucesso!";
	}


	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/testSF")
	public String initStateful() throws NamingException, JMSException{
		runTestStatefulThead();
		return "thread stateful executada com sucesso!";
	}


	
}
