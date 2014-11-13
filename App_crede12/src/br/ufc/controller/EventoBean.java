package br.ufc.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.ufc.dao.AtividadeDAO;
import br.ufc.dao.AtividadeJPADAO;
import br.ufc.dao.CarroDAO;
import br.ufc.dao.CarroJPADAO;
import br.ufc.dao.FornecedorDAO;
import br.ufc.dao.FornecedorJPADAO;
import br.ufc.dao.LocalEventoDAO;
import br.ufc.dao.LocalEventoJPADAO;
import br.ufc.dao.NucleoDAO;
import br.ufc.dao.NucleoJPADAO;
import br.ufc.dao.ParticipanteDAO;
import br.ufc.dao.ParticipanteJPADAO;
import br.ufc.model.Carro;
import br.ufc.model.Evento;
import br.ufc.model.Fornecedor;
import br.ufc.model.LocalEvento;
import br.ufc.model.Nucleo;
import br.ufc.model.Participante;
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
	
	
	
	
	public Evento getEvento() {
		return evento;
	}


	public void set(Evento evento) {
		this.evento = evento;
	}

	public List<Nucleo> getListaDeNucleos() {
		NucleoDAO dao = new NucleoJPADAO();
		return dao.find();
	}
	
	public List<Participante> getListaDeParticipantes() {
		ParticipanteDAO dao = new ParticipanteJPADAO();
		return dao.find();
	}

	public List<LocalEvento> getListaDeLocais() {
		LocalEventoDAO dao = new LocalEventoJPADAO();
		return dao.find();
	}
	
	public List<Fornecedor> getListaDeFornecedores() {
		FornecedorDAO dao = new FornecedorJPADAO();
		return dao.find();
	}
}
