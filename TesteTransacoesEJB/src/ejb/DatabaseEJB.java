package ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class DatabaseEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	public void init(){
		System.out.println("Iniciando PersistenceEJB.");		
	}
	
	public EntityManager getEntityManager(){
		return em;
	}

	
	@PreDestroy
	public void destroy(){
		System.out.println("Finalizando PersistenceEJB.");
	}
}
