package main;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejbs.GeradorMsg;

public class MainTesteAsycComRetorno {

	
	
	public static class ExecuteService implements Runnable{
		private GeradorMsg bean;
		private String name;
		
		public ExecuteService(GeradorMsg param,String name) {
			this.bean = param;
			this.name = name;
		}
		
		@Override
		public synchronized void run() {
			try {
				Future<String> retorno = bean.generate();
				//retorno.cancel(true); efetua cancelamento da tarefa
				while(!retorno.isDone()){
					System.out.println(">>>> Thread "+ name + " aguardando....");
				    Thread.sleep(10000);
				}				
				System.err.println(">>> retorno thread "+ name +":" + retorno.get() );
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		try {
			System.out.println(">>> Iniciando Threads....");

			Properties p = new Properties();
			p.put("java.naming.factory.initial","org.apache.openejb.client.LocalInitialContextFactory");
			InitialContext ctx = new InitialContext(p);
			
			GeradorMsg gerador = (GeradorMsg) ctx.lookup("java:openejb/remote/jndi/GeradorMsg");

			for(int ix = 0; ix < 10; ix++){
				String name = "thread"+ix;
				ExecuteService executor = new ExecuteService(gerador, name);
				Thread t = new Thread(executor);
				t.setName("thread"+ix);
				t.start();
				Thread.sleep(1000);
			}
			System.out.println(">>> FIm classe principal");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

}
