package br.com.caelum.livraria.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Autorizador implements PhaseListener {

	private static final long serialVersionUID = 1L;

	public void afterPhase(PhaseEvent event) {

		FacesContext context = event.getFacesContext();

		if ("/login.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}

		UsuarioLogado usuarioLogado = procuraUsuarioLogado(context);

		// Usando o usuarioLogado que foi injetado
		if (!usuarioLogado.isLogado()) {

			NavigationHandler handler = context.getApplication()
					.getNavigationHandler();
			handler.handleNavigation(context, null, "login?faces-redirect=true");

			// efetua renderiza????o da tela
			context.renderResponse();
		}
	}

	private UsuarioLogado procuraUsuarioLogado(FacesContext context) {
		return (UsuarioLogado) context.getApplication().getELResolver()
				.getValue(context.getELContext(), null, "usuarioLogado");
	}

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
