package br.ufc.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.ufc.dao.AtividadeDAO;
import br.ufc.dao.AtividadeJPADAO;
import br.ufc.dao.CarroDAO;
import br.ufc.dao.CarroJPADAO;
import br.ufc.dao.CidadeDAO;
import br.ufc.dao.CidadeJPADAO;
import br.ufc.dao.ParticipanteDAO;
import br.ufc.dao.ParticipanteJPADAO;
import br.ufc.dao.ViagemDAO;
import br.ufc.dao.ViagemJPADAO;
import br.ufc.model.Carro;
import br.ufc.model.Cidade;
import br.ufc.model.Evento;
import br.ufc.model.Participante;
import br.ufc.model.Viagem;
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
		return "/adm/viagem/listarViagem? faces-redirect=true";

	}

	public String atualizarViagem() {

		ViagemService viagems = new ViagemServiceImpl();
		viagems.update(viagem);
		
		return "/adm/viagem/listarViagem? faces-redirect=true";
	}

	public void deletarViagem() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));

	
		ViagemDAO viagemDAO = new ViagemJPADAO();

		Viagem persistedViagem = viagemDAO.find(id);
		viagemDAO.delete(persistedViagem);

	}

	public List<Cidade> getListaDeCidades() {
		CidadeDAO dao = new CidadeJPADAO();
		return dao.find();
	}
	
	public List<Participante> getListaDeParticipantes() {
		ParticipanteDAO dao = new ParticipanteJPADAO();
		return dao.find();
	}
	
	public List<Evento> getListaDeEventos() {
		AtividadeDAO dao = new AtividadeJPADAO();
		return dao.find();
	}
	
	public List<Carro> getListaDeCarros() {
		CarroDAO dao = new CarroJPADAO();
		return dao.find();
	}
}
