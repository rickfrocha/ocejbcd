package br.com.testes.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateful;


@Stateful(mappedName="myejb",name="myejb")
public class MyEJB implements MyEJBInterface{
	
	private List<String> mensagens;
	
	@PostConstruct
	public void init(){
		System.out.println("Iniciandooooooooooooooooooo");
		mensagens = new ArrayList<String>();
	}
	
	public String say(String msg){
		mensagens.add(msg);
		return "say "+msg;
	}
	
	public List<String> obterMensagens(){
		return mensagens;
	}
	
	@Remove
	public void liberarSesssao(){
		mensagens.clear();
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Liberandooooooooooooooooooo");
	}

}
