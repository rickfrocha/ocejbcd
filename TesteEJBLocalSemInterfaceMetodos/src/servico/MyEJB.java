/**
 * 
 */
package servico;

import javax.ejb.Stateless;

/**
 * @author Ricardo Rocha
 * @since  03/10/2015
 * 
 * 1 - Se nao for definido uma interface, por padrao ser� @LocalBean
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
	
	//Devera lan�ar exce��o EJBExceptio
	String testeB(){
		return "teste B";
	}

	//Devera lan�ar exce��o
	protected String testeC(){
		return "teste C";
	}
}
