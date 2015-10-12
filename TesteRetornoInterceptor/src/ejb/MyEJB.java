/**
 * 
 */
package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * @author Ricardo Rocha
 * @since  03/10/2015
 *  
 */
@LocalBean
@Stateless
public class MyEJB {

	
	public String teste(){
		return "ola";
	}
	
	
	@AroundInvoke   //Havera class cast exception na chamada do metodo teste()
	public Object interceptador(InvocationContext ic) throws Exception{
		return new Integer(10);
	}

}
