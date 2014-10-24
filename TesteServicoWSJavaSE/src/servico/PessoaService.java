package servico;

import java.util.Date;

import javax.jws.WebService;

@WebService
public class PessoaService {
	
	public PessoaResponseDTO obterPessoa(){
		return new PessoaResponseDTO(1, "ricardo", new Date() );
	}

}
