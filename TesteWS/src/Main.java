import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

/**
 * 
 */

/**
 * @author Ricardo Rocha
 * @since  07/08/2015
 *  
 */
@WebService(serviceName="MyService",targetNamespace="http://www.meusistema.com")
@SOAPBinding(style= Style.DOCUMENT, parameterStyle = ParameterStyle.WRAPPED, use=SOAPBinding.Use.LITERAL)
public class Main {
	
	public Main(){
	   	
	}
	
	@WebMethod(operationName="teste2")
	public String teste2( 
			              @WebParam(name="req") 
			              RequestType request){
		return "vc esta testando? codigor="+request.getCodigo();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/MyService", new Main() );
	}

}
