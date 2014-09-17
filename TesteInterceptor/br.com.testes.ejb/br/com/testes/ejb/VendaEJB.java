package br.com.testes.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.interceptor.ExcludeDefaultInterceptors;
import javax.interceptor.Interceptors;

@Stateless(name="vendaEJB")
public class VendaEJB implements Venda {
	
	@PostConstruct
	public void init(){
		System.out.println("Inicializando EJB Venda!!!");
	}

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
