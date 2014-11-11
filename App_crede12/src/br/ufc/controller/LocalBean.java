package br.ufc.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.ufc.dao.CarroDAO;
import br.ufc.dao.CarroJPADAO;
import br.ufc.dao.LocalEventoDAO;
import br.ufc.dao.LocalEventoJPADAO;
import br.ufc.model.Carro;
import br.ufc.model.LocalEvento;
import br.ufc.service.LocalService;
import br.ufc.service.LocalServiceImpl;

@ManagedBean
public class LocalBean {

	LocalEvento localEvento = new LocalEvento();

	public LocalEvento getLocalEvento() {
		return localEvento;
	}

	public void setLocalEvento(LocalEvento localEvento) {
		this.localEvento = localEvento;
	}

	public String inserirLocal() {

		LocalService localService = new LocalServiceImpl();
		localService.save(localEvento);
		
		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Inserido com sucesso", "Inserido com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "";
	}

	public List<LocalEvento> getLocalEventos() {

		LocalEventoDAO localEventoDAO = new LocalEventoJPADAO();
		List<LocalEvento> l = localEventoDAO.find();

		return l;
	}

	public String buscarLocalEvento() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));

		LocalEventoDAO localEventoDAO = new LocalEventoJPADAO();
		localEvento = localEventoDAO.find(id);

		return "/adm/cadastrar/LocalEvento/editar";

	}

	public String atualizarLocalEvento() {

		LocalEventoDAO localEventoDAO = new LocalEventoJPADAO();
		localEventoDAO.update(localEvento);

		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Atualizado com sucesso", "Atualizado com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "/adm/cadastrar/LocalEvento/listar";

	}

	public void deletarLocalEvento() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));

		LocalEventoDAO localEventoDAO = new LocalEventoJPADAO();

		LocalEvento persistedLocalEvento = localEventoDAO.find(id);
		localEventoDAO.delete(persistedLocalEvento);

	}

}
