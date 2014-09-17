package br.com.testes.ejb;

import javax.annotation.PostConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class GlobalInterceptador {
	
	@PostConstruct
	public void init(InvocationContext iv) throws Exception{
		System.out.println("Global Interceptador >>> Inicializacao >>> Metodo: " + iv.getMethod());
		iv.proceed();
	}
	
	@AroundInvoke
	public Object intercept(InvocationContext ic) throws Exception{
		System.out.println("Global Interceptor >>> Metodo " + ic.getMethod());
		return ic.proceed();		
	}

}
