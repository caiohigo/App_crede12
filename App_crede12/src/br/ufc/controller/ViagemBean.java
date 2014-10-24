package br.ufc.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.ufc.dao.ParticipanteDAO;
import br.ufc.dao.ParticipanteJPADAO;
import br.ufc.dao.ViagemDAO;
import br.ufc.dao.ViagemJPADAO;
import br.ufc.model.Evento;
import br.ufc.model.Participante;
import br.ufc.model.Viagem;
import br.ufc.service.EventoService;
import br.ufc.service.ViagemService;
import br.ufc.service.ViagemServiceImpl;

@ManagedBean(name = "viagemBean")
public class ViagemBean {
	private Viagem viagem = new Viagem();

	public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

	public List<Viagem> getViagens() {
		ViagemDAO viagemDAO = new ViagemJPADAO();

		List<Viagem> l = viagemDAO.find();

		return l;
	}

	public String buscarViagem() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		
		ViagemDAO dao = new ViagemJPADAO();
		viagem = dao.find(id);

		return "/adm/viagem/atualizarViagem";

	}

	public String inserirViagem() {
		
		ViagemService viagens = new ViagemServiceImpl();
		viagens.save(viagem);


		FacesMessage m = new FacesMessage("inserido com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);
		return "/adm/viagem/listarViagem";

	}

	public String atualizarViagem() {

		ViagemService viagems = new ViagemServiceImpl();
		viagems.update(viagem);
		
		return "/adm/viagem/listarViagem";
	}

	public void deletarViagem() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));

		ViagemService viagems = new ViagemServiceImpl();
		ViagemDAO viagemDAO = new ViagemJPADAO();

		Viagem persistedViagem = viagemDAO.find(id);
		viagemDAO.delete(persistedViagem);

	}

	

	
}
