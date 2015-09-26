package ejb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

/**
 * Session Bean implementation class MeuEJB
 */
@Stateful
@StatefulTimeout(unit=TimeUnit.SECONDS,value=30)
@LocalBean
public class MeuEJBStateful {

   private List<String> mensagens = new ArrayList<String>();
   
   public void adicionarMensagem(String msg){
	   System.out.println("Mensagem adicionada:"+msg);
	   mensagens.add(msg);
   }
   
   public List<String> obterMensagens(){
	   return mensagens;
   }
    
   @Remove
   public void destruir(){
	   System.out.println("chamada do metodo destruir!!!");
   } 
   
   
   @PreDestroy
   public void preDestroy(){
	   System.out.println("chamada do metodo preDestroy!!!");	   
   }

}
