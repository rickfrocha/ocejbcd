package br.com.testes.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;


@MessageDriven(name="resp", activationConfig={
			@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
			@ActivationConfigProperty(propertyName="destinationName", propertyValue="resp"),
})
public class MyEJBResposta implements javax.jms.MessageListener {

	@Override
	public void onMessage(Message request) {
		TextMessage tx = (TextMessage) request;
		try {
			System.out.println("Recebendo resposta: "+tx.getText());
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
