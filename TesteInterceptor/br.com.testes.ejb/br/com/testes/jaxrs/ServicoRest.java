package br.com.testes.jaxrs;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.testes.ejb.Venda;


@Path("/rest")
public class ServicoRest {
	
	@EJB
	private Venda vendaEJB;
	
	@GET
	@Path("/addItem/{id}")
	@Produces("text/plain")
	public String addItem(@PathParam("id") Integer id){
		if(vendaEJB.addItem(id)){
			return "Item incluido com sucesso";
		} 
		return "Item não incluido. Id: "+id;
	}

}
