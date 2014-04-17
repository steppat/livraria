package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AutorDao {

	@PersistenceContext
	EntityManager manager;

	@PostConstruct
	public void posConstrucao() {
		System.out.println("criando AutorDao " + this);
	}
	
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void salva(Autor autor) throws LivrariaException {
		
		System.out.println("salvando ..." + autor.getNome());
//		try {
//			Thread.sleep(15000);
//		} catch (InterruptedException e) {
//		}
		manager.persist(autor);
		
		System.out.println("salvou .... ???" + autor.getNome());

		throw new LivrariaException("algo inesperado aconteceu");
		
	}
	
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public List<Autor> todosAutores() {
		return this.manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.manager.find(Autor.class, autorId);
		return autor;
	}
	
}
