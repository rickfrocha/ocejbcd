package ejbs;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * Session Bean implementation class TesteBean
 * 
 * Referência:
 * http://www.javahelp.info/2009/11/01/using-transactionattribute-in-submethods-on-same-ejb3-beans/
 * 
 */
@Stateless(mappedName = "ejb/testeBean")
@LocalBean
public class TesteBean {
	
	@EJB
	private TesteBean ejb;
	

    /**
     * Default constructor. 
     */
    public TesteBean() {
        // TODO Auto-generated constructor stub
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String sayWithTransaction(){
    	return this.sayWithNeverTransaction(); //se chamado diretamente com(this), não gera excessão
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)    
    public String sayWithTransactionByInterface(){
    	return ejb.sayWithNeverTransaction(); //se chamado irá gerar exceção pois a interface dispara o interceptador de seguranca e transacoes	
    } 
    
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public String sayWithNeverTransaction(){
    	return "Ola";
    }

}
