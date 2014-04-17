package br.com.caelum.livraria.dao;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioDao {

	@EJB Banco banco;

	public Usuario buscaPeloLogin(String login) {
		return this.banco.buscaPeloNome(login);
	}
	
}
