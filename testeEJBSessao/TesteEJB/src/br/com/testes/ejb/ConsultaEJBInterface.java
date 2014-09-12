package br.com.testes.ejb;

import javax.ejb.Remote;


@Remote
public interface ConsultaEJBInterface {
	
	String[] getTimes();

}
