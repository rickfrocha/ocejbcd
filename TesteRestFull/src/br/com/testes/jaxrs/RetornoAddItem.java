package br.com.testes.jaxrs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RetornoAddItem {
	@XmlElement
	private String msg;
	
	public RetornoAddItem() {
		// TODO Auto-generated constructor stub
	}
	public RetornoAddItem(String msg) {
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}			

}
