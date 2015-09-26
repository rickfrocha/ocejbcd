package ws;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * endpoint: http://DAROCHRI3:8080/servicos/corporativos/sayService?wsdl
 * @author darochri
 *
 */
@Stateless
@WebService(serviceName = "servicos/corporativos", //Nome do caminho para acessar servico 
            name = "sayService") //nome especifico do servico
public class ServicoImpl implements Servico {

	@Override
	public String sayHello() {
		return "Ola";
	}

}
