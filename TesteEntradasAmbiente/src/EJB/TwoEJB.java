/**
 * 
 */
package EJB;

import javax.annotation.Resource;
import javax.ejb.Stateless;

/**
 * @author Ricardo Rocha
 * @since  26/09/2015
 * 
 * Chapater 16 EJB Specification
 *  
 */
@Stateless
public class TwoEJB {

	@Resource(name="porta")
	private Integer portaAcesso;
	
	/**
	 * 
	 */
	public TwoEJB() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void setPortaAcesso(Integer porta){
		System.out.println("Injetandoooooooooo TWO porta acesso: " + porta);
		this.portaAcesso = porta;
	}
	
	public Integer obterPortaAcesso(){
		return portaAcesso;
	}

}
