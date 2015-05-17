package ejbs;

import interceptadores.MeuInterceptador;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 * Session Bean implementation class MeuEJB
 */
@Stateless(mappedName = "ejb/MeuEJB")
@LocalBean
public class MeuEJB {

    /**
     * Default constructor. 
     */
    public MeuEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public String sayHello(){
    	return this.getMessage();
    }
    
    /**
     * Nenhum interceptador é chamado
     * Interceptador funciona apenas para métodos publicos
     * É a mesma coisa de chamar um método com (this) dentro de um contexto transacional 
     * 
     */
    @Interceptors(value={MeuInterceptador.class})
    private String getMessage(){
    	return "ola!!!";
    }

}
