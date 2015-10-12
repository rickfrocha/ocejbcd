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
@Stateless(name="saudacoesPortugues", mappedName="ejb/saudacoesPortugues")
public class SaudacoesPortugues implements SaudacoesInterface {


	/* (non-Javadoc)
	 * @see ejb.SaudacoesInterface#digaOla(java.lang.String)
	 */
	@Override
	public String digaOla(String nome) {
		return "Ola "+nome;
	}

}
