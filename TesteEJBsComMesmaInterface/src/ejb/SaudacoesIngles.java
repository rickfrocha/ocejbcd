/**
 * 
 */
package ejb;

import javax.ejb.Stateless;

/**
 * @author Ricardo Rocha
 * @since  06/10/2015
 *  
 */
@Stateless
public class SaudacoesIngles implements SaudacoesInterface {


	/* (non-Javadoc)
	 * @see ejb.SaudacoesInterface#digaOla(java.lang.String)
	 */
	@Override
	public String digaOla(String nome) {
		return "Hello "+nome;
	}

	
}
