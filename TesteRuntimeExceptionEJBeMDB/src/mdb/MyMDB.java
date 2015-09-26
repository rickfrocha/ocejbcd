/**
 * 
 */
package mdb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.jms.JMSException;
import javax.jms.Message;

/**
 * @author Ricardo Rocha
 * @since  24/03/2015
 *  
 */
@javax.ejb.MessageDriven(name="MyMDBQueue",
		activationConfig={ @ActivationConfigProperty(propertyName="destinationType", 
												   propertyValue="javax.jms.Queue"),
						   @ActivationConfigProperty(propertyName="destinationName", 
												   propertyValue="MyMDBQueue"),
						   @ActivationConfigProperty(propertyName="messageSelector", 
						   						   propertyValue="qtdEntrega < 3")												   
				}
		)
public class MyMDB implements javax.jms.MessageListener{
	
	public static final String PROPERTY_MSG_QTD_ENTREGA = "qtdEntrega";

	@Resource
	private javax.ejb.MessageDrivenContext context; 
	
	private void incrementTentativaEntrega(Message message){
		try{
			if(message.propertyExists(PROPERTY_MSG_QTD_ENTREGA)){
				int qtdTentativas = message.getIntProperty(PROPERTY_MSG_QTD_ENTREGA);
				message.clearProperties();
				message.setIntProperty(PROPERTY_MSG_QTD_ENTREGA, ++qtdTentativas);
			}	
		} catch(Exception ex) { }
	}
	
	@Override
	public void onMessage(Message message) {
		System.out.println( "Recebendo mensagem " );
		try{
			if(message.propertyExists(PROPERTY_MSG_QTD_ENTREGA)){
				int qtdTentativas = message.getIntProperty(PROPERTY_MSG_QTD_ENTREGA);
				System.out.println("tentativa de entrega: "+ qtdTentativas);
			}
			javax.jms.TextMessage tm = (javax.jms.TextMessage) message;
			System.out.println( "Recebido mensagem: " + tm.getText());
			
			String[] itens = tm.getText().split(" "); 
			System.out.println(itens[5]);
		} catch(JMSException jmse){
			System.out.println( "Desfazendo mensagem " );
			incrementTentativaEntrega(message);
			context.setRollbackOnly();
		} catch(Exception ex){
			System.out.println( "Desfazendo mensagem " );
			incrementTentativaEntrega(message);
			context.setRollbackOnly();
		}
	}

}
