package restful;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dominio.Endereco;
import ejb.TestePersistenciaEJB;

@Path("/servico")
@Produces(MediaType.TEXT_PLAIN)
public class Servico {
	
	@EJB
	private TestePersistenciaEJB persist;
	
	@GET	
	@Path("/persist")
	public void testePersist(){
		Endereco e = new Endereco();
		e.setRua("Rua xxxxx");
		e.setBairro("Bairro xxxx");
		e.setEstado("Sp");
		e.setCidade("Sao Paulo");
		persist.gravarEndereco(e);
	}
	
	
	@GET	
	@Path("/listClientes")
	public String listClientes(){
		return persist.getAllClientes().toString();
	}
	
	@GET	
	@Path("/listEnderecos")
	public String listEnderecos(){
		return parseListEnderecoToString( persist.getAllEnderecos() );
	}
	
	private String parseListEnderecoToString(List<Endereco> lst){
		String ret = "";
		for(Endereco e : lst){
			ret += e.getId() + " / " + e.getRua() + "\r\n";
		}
		return ret;
	}

}
