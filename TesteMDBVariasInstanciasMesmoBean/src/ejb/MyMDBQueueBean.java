/**
 * 
 */
package ejb;

import java.util.concurrent.atomic.AtomicInteger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author Ricardo Rocha
 * @since  03/10/2015
 *  
 *  Serao criados 3 instancias deste MDB (Vide ejb-jar.xml)
 *  Testes realizados com TomEE V7
 *  
 */
@MessageDriven( name="MyMDBQueue",
				activationConfig={
				  	       @ActivationConfigProperty(propertyName ="destinationType",
				  	    		                     propertyValue="javax.jms.Queue"),
				  	       @ActivationConfigProperty(propertyName="destinationName", 
												     propertyValue="MyMDBQueue")				  	    		                     
                        }
               )
public class MyMDBQueueBean implements MessageListener {

	private static AtomicInteger contadorInstancia = new AtomicInteger(0);
	private int idInstancia = contadorInstancia.incrementAndGet();

	
	/**
	 * 
	 */
	public MyMDBQueueBean() {
		System.out.println("Criado a instancia "+idInstancia);
	}
	
	/* (non-Javadoc)
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	@Override
	public void onMessage(Message inMessage) {
		
		TextMessage txtMessage = (TextMessage) inMessage;
		try {
			System.out.println("MDB "+idInstancia+" recebeu a mensagem: "+ txtMessage.getText() );
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
