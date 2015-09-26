package ejbs;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.ExcludeDefaultInterceptors;
import javax.interceptor.InvocationContext;

@Stateless(name="sayEJB")
@LocalBean
@ExcludeDefaultInterceptors
public class SayEJB {
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Resource(name="cumprimentoPadrao", type=java.lang.String.class)
	private String cumprimentoPadrao;
	
	public String say(String name){
		if("say".equalsIgnoreCase(name) ){
		   return cumprimentoPadrao;
		} 
		return "Hello "+ name + " !";
	}
	
	@AroundInvoke
	public Object intercept(InvocationContext ic) throws Exception{
		log.info(">>> Interceptador interno da classe " + this.getClass().getSimpleName() );
		log.info("Interceptando a classe: " + ic.getTarget().getClass().getSimpleName() );
		log.info("metodo: "+ic.getMethod());
		
		int count = 1;
		for(Object param: ic.getParameters()){
			log.info("Param: "+ count++ + " " + (String) param);
		}
		return ic.proceed();
		
	}

}
