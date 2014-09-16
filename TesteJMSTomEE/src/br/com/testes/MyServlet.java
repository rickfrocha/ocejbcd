package br.com.testes;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/teste")
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    @Resource(name = "bar")
    private Queue barQueue;
    
    @Resource(name = "resp")
    private Queue resp;

    @Resource
    private ConnectionFactory connectionFactory;	


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		    try{
				Connection connection = connectionFactory.createConnection();
		        connection.start();
	
		        // Create a Session
		        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	
		        // Create a MessageProducer from the Session to the Topic or Queue
		        MessageProducer producer = session.createProducer(barQueue);
		        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	
		        // Create a message
		        TextMessage message = session.createTextMessage("Hello World!");
		        message.setJMSReplyTo(resp);
	
		        // Tell the producer to send the message
		        producer.send(message);
		        
		        System.out.println("fim");
		    } catch(Exception ex){
		    	ex.printStackTrace();
		    }

	}


}
