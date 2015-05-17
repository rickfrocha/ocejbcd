/**
 * 
 */
package interceptadores;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * @author Ricardo Rocha
 * @since  16/05/2015
 *  
 */
public class MeuInterceptador {
	
	@AroundInvoke
	public Object intercept(InvocationContext ic) throws Exception{
		System.out.println("Interceptando "+ic.getTarget().getClass().getName() );
		return ic.proceed();
	}

}
