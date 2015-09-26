package ejb;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

/**
 * 
 * @author Ricardo Rocha
 * @since  23/03/2015
 * 
 * Classe criada para testar exce��o em RunTimeException
 * A ideia � verificar se o EJB � descartado ap�s um exce��o em tempo de execu��o
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
