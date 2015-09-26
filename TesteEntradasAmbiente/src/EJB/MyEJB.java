/**
 * 
 */
package EJB;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Ricardo Rocha
 * @since  26/09/2015
 *  
 */
@Stateless(name="myEJB")
public class MyEJB {

	@Resource
	private Integer tipoLog;
	
	@Resource(name="porta")
	private Integer portaAcesso = 15;
	
	@Resource
	private EJBContext contextEJB;
	
	/* 
	 * Havera injecao de entrada de ambiente aqui sem uso de @Resource
	 * Vide ejb-jar.xml
	 * 
	 */
	private String emailContato;
	
	
	public void setTipoLog(Integer tipo){
		System.out.println("Injetandoooooooooo " + tipo);
		this.tipoLog = tipo;
	}
	
	
	/**
	 * 
	 */
	public MyEJB() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer obterValorTipoLog(){
		return tipoLog;
	}
	
	public Integer obterPortaAccesso(){
		return portaAcesso;
	}
	
	public String obterEmail(){
		return emailContato == null ? "Nao informado" : emailContato;
	}

	
	
	/**
	 * Exemplo 1
	 * É obtido o valor do contexto utilizando "java:comp/env/nome-da-entrada-ambiente"
	 * @return
	 * @throws NamingException
	 */
	public String obterSMTPLookup1() throws NamingException{
		Context context = new InitialContext();
		String smtp = (String) context.lookup("java:/comp/env/smtpLookup");		 	
		return "Lookup1: " +smtp;
	}

	
	/**
	 * Exemplo 2
	 * É obtido o contexto principal para simplificar as buscas que posteriormente não precisa mais informar "java:comp/env"
	 * @return
	 * @throws NamingException
	 */
	public String obterSMTPLookup2() throws NamingException{
		Context context = new InitialContext();
		Context myLocalContextEJB = (Context) context.lookup("java:/comp/env");		
		String smtp = (String) myLocalContextEJB.lookup("smtpLookup");
		return "Lookup2: " +smtp;
	}
	
	/**
	 * Exemplo 3
	 * É obtido a entrada de ambiente atraves do EJBContext.lookup
	 * Desta forma nao é preciso informar o "java:comp/env"
	 * Sua implementação interna deve ser parecida como o exemplo 2
	 * @return
	 * @throws NamingException
	 */
	public String obterSMTPLookup3() throws NamingException{
		String smtp = (String) contextEJB.lookup("smtpLookup");
		return "Lookup3: " +smtp;
	}
	
}
