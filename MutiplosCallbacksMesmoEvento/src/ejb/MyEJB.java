package ejb;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/***
 * 
 * @author Ricardo Rocha
 * @since  23/03/2015 
 * 
 * Classe utilizada para verificar se é possível ter vários callbacks do mesmo tipo em uma mesma classe
 * 
 * Foi confirmado que sim. 
 * Criacao:
 * >>>>> Executando init()
 * >>>>> Executando init1()
 * >>>>> exetando teste!!!!!
 *
 * Destruição:
 * >>>>> Executando close3()
 * >>>>> Executando close()
 * >>>>> Executando close1()
 * 
 * 
 * Como pode ser observado ele é executado conforme ordem definida na classe.
 * Teste realizado com TomEE 7 e GlassFish 4
 * 
 */
@Stateless
@LocalBean
public class MyEJB {
	
	@PostConstruct
	public void init(){
		System.out.println(">>>>> Executando init()");
	}
	
	@PostConstruct
	public void init1(){
		System.out.println(">>>>> Executando init1()");
	}

	@PreDestroy
	public void close3(){
		System.out.println(">>>>> Executando close3()");		
	}
	
	public void teste(){
		System.out.println(">>>>> exetando teste!!!!!");
	}
	
	@PreDestroy
	public void close(){
		System.out.println(">>>>> Executando close()");		
	}

	@PreDestroy
	public void close1(){
		System.out.println(">>>>> Executando close1()");		
	}
	
}
