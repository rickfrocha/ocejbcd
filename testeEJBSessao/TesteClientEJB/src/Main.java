
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.testes.ejb.ConsultaEJBInterface;
import br.com.testes.ejb.MyEJBInterface;

public class Main {

	static MyEJBInterface ejb = null;
	static ConsultaEJBInterface consultaEjb;
	
	private static MyEJBInterface getEJB() throws NamingException {
		if (ejb == null) {
			Properties p = new Properties();
			p.put("java.naming.factory.initial","org.apache.openejb.client.LocalInitialContextFactory");
			InitialContext ctx = new InitialContext(p);

			//java:/openejb/remote/myejb
			ejb = (MyEJBInterface) ctx.lookup("java:/openejb/local/myejb");
		}
		return ejb;
	}
	
	private static ConsultaEJBInterface getConsultaEJB() throws NamingException {
		if (consultaEjb == null) {
			Properties p = new Properties();
			p.put("java.naming.factory.initial","org.apache.openejb.client.LocalInitialContextFactory");
			InitialContext ctx = new InitialContext(p);
			consultaEjb = (ConsultaEJBInterface) ctx.lookup("java:/openejb/local/consEJB");
		}
		return consultaEjb;
	}
	
	
	public static void main(String[] args) {
		try {
			ejb = getEJB();
			System.out.println( ejb.say(" hello1 !!!")  );
			System.out.println( ejb.say(" hello2 !!!")  );
			System.out.println( ejb.say(" hello3 !!!")  );
			System.out.println( ejb.say(" hello4 !!!")  );
			System.out.println( ejb.say(" hello5 !!!")  );
			
			System.out.println( ejb.obterMensagens().toString() );
			ejb.liberarSesssao();
			
			System.out.println("fim");
			System.out.println(ejb == null);
			
			
			consultaEjb = getConsultaEJB();
			System.out.println( "times: "+ Arrays.asList(  consultaEjb.getTimes() )  );
			
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	


}
