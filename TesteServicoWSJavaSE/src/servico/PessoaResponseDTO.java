package servico;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PessoaResponseDTO {
	
	private int id;
	private String nome;
	private Date dtNascimento;
	
	public PessoaResponseDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public PessoaResponseDTO(int id, String nome, Date dtNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	

}
