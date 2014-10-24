package main;

import javax.xml.ws.Endpoint;

import servico.CalculadoraService;
import servico.PessoaService;

public class Main {

	public static void main(String[] args) {
		System.out.println(" web service - Inicializando ");
		CalculadoraService calcService = new CalculadoraService();
		PessoaService pessoaService = new PessoaService();
		
		//Endpoint.publish("http://localhost:8080/calculadoraService", calcService );
		Endpoint.publish("http://localhost:8080/pessoaService", pessoaService );
		System.out.println(" web service - Publicado ");
	}

}
