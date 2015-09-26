import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */

/**
 * @author Ricardo Rocha
 * @since  07/08/2015
 *  
 */


@XmlRootElement(name="requestType")
@XmlType(namespace="http://www.meusistema.com" )
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestType {
	
	@XmlElement(required=true)
	private int codigo;
	

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	

}
