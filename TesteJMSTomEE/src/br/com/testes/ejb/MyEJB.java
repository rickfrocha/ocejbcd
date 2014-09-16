package br.com.testes.ejb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;


@MessageDriven(name="bar", activationConfig={
		 					@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
		 					@ActivationConfigProperty(propertyName="destinationName", propertyValue="bar"),
				})
public class MyEJB implements javax.jms.MessageListener{
	
	
    @Resource
    private ConnectionFactory connectionFactory;
    

	@Override
	public void onMessage(Message request) {
		TextMessage tx = (TextMessage) request;
		
		try {
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			TextMessage resposta = session.createTextMessage();
			resposta.setJMSCorrelationID(request.getJMSCorrelationID());
			resposta.setText("Resposta automatica!!!!!");
			MessageProducer p = session.createProducer(request.getJMSReplyTo());
			p.send(resposta);
			
			System.out.println(">>>>>>>> Mensagem recebida: "+tx.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
