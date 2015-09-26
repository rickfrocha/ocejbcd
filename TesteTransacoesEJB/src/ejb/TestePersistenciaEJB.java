package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dominio.Cliente;
import dominio.Endereco;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TestePersistenciaEJB {
	
	@EJB
	private DatabaseEJB db;
	
	private EntityManager em;
	
	private EntityManager getEntityManager(){
		return db != null ? db.getEntityManager() : null;
	}
	
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void gravarEndereco(Endereco endereco){
		em = this.getEntityManager();
		if(em != null){
			em.persist(endereco);
			System.out.println("Item persistido com sucesso!");
		}
	}
	
	
	public List<Endereco> getAllEnderecos(){
		em = this.getEntityManager();
		TypedQuery<Endereco> query = em.createQuery("Select c From Endereco c", Endereco.class);
		return query.getResultList();
	}
	
	public List<Cliente> getAllClientes(){
		em = this.getEntityManager();
		TypedQuery<Cliente> query = em.createQuery("Select c From Cliente c", Cliente.class);
		return query.getResultList();
	}

}
