package servicos;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.Queue;
import javax.jms.Session;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import mdb.MyMDB;
import ejb.MyEJBLocal;

@Path("/rest")
public class RestService {
	
	@EJB
	private MyEJBLocal ejb;
	
	@Resource
	private javax.jms.ConnectionFactory jmsConnectionFactoty;
	
	@Resource(name="MyMDBQueue")
	private Queue jmsQueue;
	
	
	@GET
	@Path("/testeEJB")
	@Produces(MediaType.TEXT_PLAIN)
	public String sendTesteEJB(){
		try{
			ejb.teste();
		} catch(RuntimeException ex){
			ex.printStackTrace();
		} catch(Throwable ex){
			ex.printStackTrace();
		}
		return "teste executado!!!";
	}
	
	@GET
	@Path("/testeMDB/{msg}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sendTesteMDB(@PathParam("msg") String msg){
		try{
			javax.jms.Connection con = jmsConnectionFactoty.createConnection();			
			javax.jms.Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);						
			javax.jms.TextMessage tm = session.createTextMessage();
			tm.setText(msg);			
			tm.setIntProperty(MyMDB.PROPERTY_MSG_QTD_ENTREGA, 2);

			javax.jms.MessageProducer producer = session.createProducer(jmsQueue);
			producer.send(tm);			
			
		} catch(Throwable ex){
			ex.printStackTrace();
		}
		return "Mensagem enviada!!!";
	}
	
}
