/**
 * 
 */
package ejb;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * @author Ricardo Rocha
 * @since  03/10/2015
 *  
 */
@LocalBean
@Local(MyEJBLocal.class)
@Remote(MyEJBRemote.class)
@Stateless
public class MyEJB implements MyEJBLocal, MyEJBRemote {

	/* (non-Javadoc)
	 * @see ejb.MyEJBLocal#teste()
	 * @see ejb.MyEJBRemote#teste()
	 */
	@Override
	public String teste() {
		return "teste";
	}


}
