package servico;

import java.util.Date;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rest")
public class RestService {
	
	
	@Resource
	private javax.jms.ConnectionFactory jmsConnectionFactoty;
	
	@Resource(name="MyMDBQueue")
	private Queue jmsQueue;	
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/teste")
	public String teste() throws JMSException{
		Connection con = jmsConnectionFactoty.createConnection();
		Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageProducer producer = session.createProducer(jmsQueue);
		TextMessage message = session.createTextMessage();
		message.setText("Ola "+ new Date());
		producer.send(message);
		con.close(); //automaticamente fecha todos os demais recursos
		return "mensagem enviada!";
	}

}
