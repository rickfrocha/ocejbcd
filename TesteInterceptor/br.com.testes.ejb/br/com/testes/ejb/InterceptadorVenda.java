package br.com.testes.ejb;

import java.util.Arrays;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class InterceptadorVenda {
	
	@AroundInvoke
	public Object intercepter(InvocationContext iv) throws Exception{
		System.out.println("Interceptor venda >>> Método invocado: "+iv.getMethod() + " / classe: "+iv.getTarget()+ " / parametros:"+ Arrays.asList( iv.getParameters() ).toString() );
		Integer id = (Integer) iv.getParameters()[0];
		if(id.intValue() == 10){ 
			System.out.println("Interceptor venda >>> Valor inválido!!: " );
			return Boolean.FALSE;
		}
		return iv.proceed();
	}

}
