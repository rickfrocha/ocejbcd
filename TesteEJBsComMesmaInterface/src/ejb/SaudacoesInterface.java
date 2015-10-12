/**
 * 
 */
package ejb;

import javax.ejb.Local;

/**
 * @author Ricardo Rocha
 * @since  06/10/2015
 *  
 */
@Local
public interface SaudacoesInterface {
	
	/**
	 * M�todo realiza sauda��es em multiplas linguagens
	 * @param nome Nome da Pessoa
	 * @return String Mensagem de retorno
	 */
	String digaOla(String nome);

}
