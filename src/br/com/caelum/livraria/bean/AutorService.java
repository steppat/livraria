package br.com.caelum.livraria.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.dao.LivrariaException;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
//@Interceptors({LogInterceptador.class})
//@ExcludeDefaultInterceptors
@WebService
public class AutorService implements AutorRemote{

	@EJB
	AutorDao dao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void cadastra(Autor autor) throws LivrariaException {
		dao.salva(autor);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Autor> pegaAutores() {
		return dao.todosAutores();
	}

}
