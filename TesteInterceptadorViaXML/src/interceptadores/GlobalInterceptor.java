package interceptadores;

import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class GlobalInterceptor {
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@AroundInvoke
	public Object intercept(InvocationContext ic) throws Exception{
		log.info("Interceptando a classe: " + ic.getTarget().getClass().getSimpleName() );
		log.info("metodo: "+ic.getMethod());
		
		int count = 1;
		for(Object param: ic.getParameters()){
			log.info("Param: "+ count++ + " " + (String) param);
		}
		return ic.proceed();
	}

}
