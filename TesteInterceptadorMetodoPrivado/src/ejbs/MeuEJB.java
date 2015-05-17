package ejbs;

import interceptadores.MeuInterceptador;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 * Session Bean implementation class MeuEJB
 */
@Stateless(mappedName = "ejb/MeuEJB")
@LocalBean
public class MeuEJB {
	
	@EJB
	private MeuEJB ejb;

    /**
     * Default constructor. 
     */
    public MeuEJB() {
        // TODO Auto-generated constructor stub
    }
    
    
    /**
     * Teste para validar a chamada de metodo privado com (this) e interceptor 
     * 
     */
    public String sayHello(){
    	return this.getMessage();
    }

    /**
     * Nenhum interceptador � chamado
     * Interceptador funciona apenas para m�todos publicos
     * � a mesma coisa de chamar um m�todo com (this) dentro de um contexto transacional 
     * 
     */
    @Interceptors(value={MeuInterceptador.class})
    private String getMessage(){
    	return "ola!!!";
    }
    
    
    /**
     * 
     * Teste para validar a chamada de metodo public com (this) e interceptor
     */
    public String sayHello2(){
    	return this.getMessagePublicWithThis();
    }
    

    /**
     * 
     * Nenhum interceptador ser� chamado pois � chamado via (this)
     */
    @Interceptors(value={MeuInterceptador.class})
    public String getMessagePublicWithThis(){
    	return "ola!!!";
    }
    
    
    /**
     * 
     * Teste para validar a chamada de metodo public com ID  e interceptor
     */
    public String sayHello3(){
    	return ejb.getMessagePublicWithEJB();
    }
    

    /**
     * 
     * Interceptador ser� chamado
     * Isto prova que interceptadores s�o chamados apenas em m�todos publicos
     * e quando m�todo auxiliares s�o chamados via contexto
     */
    @Interceptors(value={MeuInterceptador.class})
    public String getMessagePublicWithEJB(){
    	return "ola!!!";
    }
    
    
    

}
