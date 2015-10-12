/**
 * 
 */
package servico;

import javax.ejb.Stateless;

/**
 * @author Ricardo Rocha
 * @since  03/10/2015
 * 
 * 1 - Se nao for definido uma interface, por padrao será @LocalBean
 * 2 - @LocalBean permite acesso apenas a metodos publicos 
 *  
 */
@Stateless
public class MyEJB {

	/**
	 * 
	 */
	public MyEJB() {
		// TODO Auto-generated constructor stub
	}
	
	//Sera executado com sucesso
	public String testeA(){
		return "teste A";
	}
	
	//Devera lançar exceção EJBExceptio
	String testeB(){
		return "teste B";
	}

	//Devera lançar exceção
	protected String testeC(){
		return "teste C";
	}
}
