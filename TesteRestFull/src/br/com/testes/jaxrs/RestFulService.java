package br.com.testes.jaxrs;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rest")
public class RestFulService {
	
	@Path("/ping")
	@GET
	@Produces("application/json")
	public String ping(){
		return "pong";
	}

	@Path("/addItem/{id}/produto")
	@GET
	@Produces( MediaType.APPLICATION_JSON )	
	public RetornoAddItem addItem(@PathParam("id") Integer id){
		System.out.println("valor recebido: "+id);
        return new RetornoAddItem("ok");
	}
	
	
	 @GET
	 @Path("/list")
	 public Response list() {
		 List<String> retorno = Collections.singletonList("hello");
		 return Response.ok(retorno).build();
	 }	

}
