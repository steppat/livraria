package br.com.caelum.livraria.dao;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class LivrariaException extends Exception {

	public LivrariaException(String mensagem) {
		super(mensagem);
	}

}
