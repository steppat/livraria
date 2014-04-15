package br.com.caelum.livraria.bean;

import javax.inject.Named;

import br.com.caelum.livraria.modelo.Usuario;

@Named
public class LoginBean {
	
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}
	
	public String efetuaLogin() {
		return "mainpage?faces-redirect=true";
	}
}
