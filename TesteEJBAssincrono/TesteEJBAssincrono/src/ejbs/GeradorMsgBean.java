package ejbs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name="GeradorMsg",mappedName="jndi/GeradorMsg")
@Remote(GeradorMsg.class)
public class GeradorMsgBean implements GeradorMsg{
	
	private static final long serialVersionUID = 1L;
	
	private List<String> mensagens = new ArrayList<String>();
	
	@Resource
	private SessionContext ctx;
	
	@PostConstruct
	public void init(){
		mensagens.add("ola! (Port)");
		mensagens.add("hello! (Eng)");
		mensagens.add("hola! (Span)");
		mensagens.add("hallo! (Deut)");
		
	}

	@Asynchronous
	public Future<String> generate(){
		if( ctx.wasCancelCalled()){
			System.out.println(">>>> Processo cancelado!!!!");
			return null;
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String randonMsg = mensagens.get( new Random().nextInt(mensagens.size()) );
		return new AsyncResult<String>(randonMsg);
	}

	@Asynchronous
	public void ping() {
		System.err.println(">>>>>>>>> Pong!!!");		
	}

}
