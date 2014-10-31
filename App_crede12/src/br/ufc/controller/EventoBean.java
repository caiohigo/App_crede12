package br.ufc.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.ufc.dao.AtividadeDAO;
import br.ufc.dao.AtividadeJPADAO;
import br.ufc.model.Evento;
import br.ufc.service.EventoService;
import br.ufc.service.EventoServiceImpl;

@ManagedBean(name="eventoBean")
public class EventoBean {

	
	private Evento evento = new Evento();
//	private Participante participantes = new Participante();
	
	EventoService eventoService = new EventoServiceImpl();
	
	AtividadeDAO atividadeDAO = new AtividadeJPADAO();
	private List<Evento> eventos;
	
	/*public Participante getParticipantes() {
		
		return participantes;
	}


	public void setParticipantes(Participante participantes) {
		this.participantes = participantes;
	}*/


	public EventoBean() {
		this.evento = new Evento();
	}
	
	
	public String inserirEvento(){
		
		EventoService eventoService = new EventoServiceImpl();
		
		
			eventoService.save(evento);
			
		
		return "/adm/evento/listarEvento";
		
	}
	
	public List<Evento> getAtividades(){
		
		
		if (eventos==null){
		eventos =  atividadeDAO.find();
		}
		return eventos;
	}
	
	public String atualizarEvento(){
		
			EventoService eventoService = new EventoServiceImpl();
			eventoService.update(evento);
		
			
			return "/adm/evento/listarEvento";
		}

	public String buscarEvento(){
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		
		AtividadeDAO dao = new AtividadeJPADAO();
		evento = dao.find(id);

		return "/adm/evento/atualizarEvento";
		
	}

	public void deletarEvento(){
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		AtividadeDAO atividadeDAO = new AtividadeJPADAO();
		
		Evento persistedEvento  = atividadeDAO.find(id);
		atividadeDAO.delete(persistedEvento);
		
	}
	
	
	/*			public String participantesEmAtividade(){
				
				HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
				
				int id = Integer.parseInt(request.getParameter("id"));
				
				AtividadeDAO dao = new AtividadeJPADAO();
				
				evento = dao.find(id);
			
				return "evento/listarParticipantesEmAtividade.xhtml";
		}
	*/
	
	public Evento getEvento() {
		return evento;
	}


	public void set(Evento evento) {
		this.evento = evento;
	}

	


}
