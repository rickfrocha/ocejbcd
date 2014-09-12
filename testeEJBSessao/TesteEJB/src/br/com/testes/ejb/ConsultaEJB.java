package br.com.testes.ejb;

import javax.ejb.Stateless;

@Stateless(mappedName="consEJB")
public class ConsultaEJB implements ConsultaEJBInterface {

	@Override
	public String[] getTimes() {
		return new String[]{"Sao Paulo","Palmeiras","Bahia","Cruzeiro"};
	}

}
