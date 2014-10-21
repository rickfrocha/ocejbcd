package main;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.ws.BindingType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	private Integer codigo;
	
	@XmlAttribute
	private String nome;
	
	@XmlElement
	private Date dtNascimento;
	
	
	public ClienteDTO() {
	
	}
	
	public ClienteDTO(Integer codigo, String nome, Date dtNascimento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
