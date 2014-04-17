package br.com.caelum.livraria.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.caelum.livraria.dao.LivrariaException;
import br.com.caelum.livraria.modelo.Autor;

@Named
@RequestScoped
public class AutorBean {
	
	private Autor autor = new Autor();
	
	@EJB AutorService service;
	
	public Autor getAutor() {
		return autor;
	}
	
	
	public void cadastra() {
	
		try {
			this.service.cadastra(autor);
			this.autor = new Autor();
		} catch (LivrariaException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
		}
	}
	
	public List<Autor> getAutores() {
		return this.service.pegaAutores();
	}
}
