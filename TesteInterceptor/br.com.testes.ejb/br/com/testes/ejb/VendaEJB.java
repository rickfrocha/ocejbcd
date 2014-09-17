package br.com.testes.ejb;

import javax.ejb.Stateless;
import javax.interceptor.ExcludeDefaultInterceptors;
import javax.interceptor.Interceptors;

@Stateless(name="vendaEJB")
@ExcludeDefaultInterceptors
public class VendaEJB implements Venda {

	@Interceptors(InterceptadorVenda.class)
	public boolean addItem(Integer id) {
		if(id > 0){
			System.out.println("EJB >>> Item sendo incluido " + id);
		} else {
			System.out.println("EJB >>> Item com valor invalido " + id);
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}
