package main;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Main {

	private static <T> String serializeToXml(Class<T> classe, T valor) throws JAXBException{
		StringWriter sw = new StringWriter();
		
		JAXBContext context = JAXBContext.newInstance( classe );
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(valor, sw);
		
		return sw.toString();
	}
	
	@SuppressWarnings("unchecked")
	private static <T> T unserializeXmlToObject(String xml, Class<T> classe) throws JAXBException{
		JAXBContext context = JAXBContext.newInstance( classe );
		Unmarshaller unmarchaler = context.createUnmarshaller();
		
		ByteArrayInputStream bais = new ByteArrayInputStream( xml.getBytes() );
		
		return (T) unmarchaler.unmarshal(bais);
	}

	public static void main(String[] args) {
		try {
			
			ClienteDTO dto = new ClienteDTO(1, "cliente "+1, new Date() );
			System.out.println("DTO: "+dto.getDtNascimento());
			String xml = serializeToXml(ClienteDTO.class, dto);			
			System.out.println( xml );
			
			ClienteDTO unserialize = unserializeXmlToObject(xml, ClienteDTO.class);
			System.out.println("DTO codigo: "+unserialize.getCodigo());			
			System.out.println("DTO nome: "+unserialize.getNome());
			System.out.println("DTO dtNasc: "+unserialize.getDtNascimento());

			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
