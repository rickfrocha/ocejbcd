package servico;

import javax.jws.WebService;

@WebService
public class CalculadoraService {
	
	public int calcular(int a, int b){
		return a + b;
	}

}
