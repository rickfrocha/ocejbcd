package servicos;

import java.util.Date;

import javax.jws.Oneway;
import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

import dto.ClienteDTO;

@WebService(serviceName="ClienteWSService",portName="ClienteWSPort",name="ClienteWS")
@Addressing
public class ClienteWS {
	
	public ClienteDTO consultaCliente(Integer codigo){
		return new ClienteDTO(codigo, "cliente "+codigo, new Date() );
	}
	
	@Oneway
	public void assincrono(){
		boolean execute = true;
		int count = 0;
		while(execute){
			count++;
			try {
				Thread.sleep(1000);
				System.out.println(">>>>>> executando!!! "+count);
				execute = count < 10;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
