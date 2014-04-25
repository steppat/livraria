package br.com.caelum.livraria.util;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Stateless;


@Stateless
@Startup
public class Agendador {

	
	@PostConstruct
	void posContrucao() {
		System.out.println("foi...");
	}
	
	@Schedule(persistent=false, hour="*", minute="*/1", second="10")
	public void executaPeriodicamente() {
		System.out.println("verificando servico se há um novo livro disponível");
	}
}
