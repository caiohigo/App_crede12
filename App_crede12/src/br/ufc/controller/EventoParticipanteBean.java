package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.ufc.dao.AtividadeDAO;
import br.ufc.dao.AtividadeJPADAO;
import br.ufc.dao.ParticipanteDAO;
import br.ufc.dao.ParticipanteEventoDAO;
import br.ufc.dao.ParticipanteEventoJPADAO;
import br.ufc.dao.ParticipanteJPADAO;
import br.ufc.model.Evento;
import br.ufc.model.Participante;
import br.ufc.model.ParticipanteEvento;

@SessionScoped
@ManagedBean(name = "eventoParticipanteBean")
public class EventoParticipanteBean {

	private Evento evento;
	private List<Participante> participantes;
	private List<Participante> participantesSelecionados;

	public EventoParticipanteBean() {
		participantesSelecionados = new ArrayList<Participante>();
	}

	public String prepararAdicionarParticipante() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));

		AtividadeDAO dao = new AtividadeJPADAO();
		this.evento = dao.find(id);
		
		participantes = dao.participanteForaDoEvento(evento);

		return "/adm/evento/adicionarParticipante?faces-redirect=true";
	}

	public String adicionarParticipantes(){
		
		AtividadeDAO dao = new AtividadeJPADAO();
		dao.adicionarParticipantes(evento,participantesSelecionados);
		
		return "/adm/evento/listarEvento?faces-redirect=true";
	}
	
	public String adicionarParticipante(){
		
		AtividadeDAO dao = new AtividadeJPADAO();
		dao.adicionarParticipantes(evento,participantesSelecionados);
		
		return "/adm/evento/listarEvento?faces-redirect=true";
	}
	
	public String prepararListarParticipante(){
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		AtividadeDAO dao = new AtividadeJPADAO();
		this.evento = dao.find(id);
		this.participantes = dao.participanteNoEvento(evento);
		
		
		return "/adm/evento/listarParticipantes";
	}
	
	public void removerParticipante(){
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		
		ParticipanteDAO pDao = new ParticipanteJPADAO();
		Participante participante = pDao.find(id);
		
		ParticipanteEventoDAO peDao = new ParticipanteEventoJPADAO();
		ParticipanteEvento pe = peDao.getParticipanteEvento(participante, evento);
		
		peDao.delete(pe);
		
		AtividadeDAO atividadeDao = new AtividadeJPADAO();
		
		this.participantes = atividadeDao.participanteNoEvento(evento);
		
	}
	
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public List<Participante> getParticipantesSelecionados() {
		return participantesSelecionados;
	}
	
	public void setParticipantesSelecionados(
			List<Participante> participantesSelecionados) {
		this.participantesSelecionados = participantesSelecionados;
	}

}
