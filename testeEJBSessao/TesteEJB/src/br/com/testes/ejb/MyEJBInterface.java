package br.com.testes.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
public interface MyEJBInterface {
	
	public String say(String msg);
	
	public List<String> obterMensagens();
	
	public void liberarSesssao();
	

}
