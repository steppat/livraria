package br.com.caelum.livraria.login;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

public class Autorizador implements PhaseListener{
	
	private static final long serialVersionUID = 1L;

	@Inject
	UsuarioLogadoBean usuarioLogado;

	public void afterPhase(PhaseEvent event) {

		FacesContext context = event.getFacesContext();
		
		if ("/login.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}
		
		// Usando o usuarioLogado que foi injetado
		if (!usuarioLogado.isLogado()) {

			NavigationHandler handler = context.getApplication()
					.getNavigationHandler();
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			
			//efetua renderização da tela
			context.renderResponse();
		}
	}	

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	
	

}
