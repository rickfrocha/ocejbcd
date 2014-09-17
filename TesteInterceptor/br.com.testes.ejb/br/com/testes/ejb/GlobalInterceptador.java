package br.com.testes.ejb;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class GlobalInterceptador {
	
	@AroundInvoke
	public Object intercept(InvocationContext ic) throws Exception{
		System.out.println("Global Interceptor >>> Metodo " + ic.getMethod());
		return ic.proceed();		
	}

}
