package ejb;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

/**
 * 
 * @author Ricardo Rocha
 * @since  23/03/2015
 * 
 * Classe criada para testar exceção em RunTimeException
 * A ideia é verificar se o EJB é descartado após um exceção em tempo de execução
 *
 */
@Stateless
public class MyEJB implements MyEJBLocal {
	
	@PostConstruct
	public void init(){		
		System.out.println(">>>>> Executando init()");
	}
	public void teste(){
		//System.out.println(">>>>> processando teste!!!!!");
		//new RuntimeException("Erro ocorrido no EJB");
		String numero = "-";
		new Integer(numero);
	}
	
	@PreDestroy
	public void close(){
		System.out.println(">>>>> Finalizando EJB");		
	}
	
}
