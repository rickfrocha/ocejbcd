package ws;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.jws.WebService;

@Remote
@WebService(serviceName = "ServicoWS")
public interface Servico extends Serializable {
	
	String sayHello();
	
}
