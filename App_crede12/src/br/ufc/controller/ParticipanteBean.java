package br.ufc.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.ufc.dao.AtividadeDAO;
import br.ufc.dao.AtividadeJPADAO;
import br.ufc.dao.ParticipanteDAO;
import br.ufc.dao.ParticipanteJPADAO;
import br.ufc.model.Evento;
import br.ufc.model.Participante;
import br.ufc.service.FuncionarioService;
import br.ufc.service.FuncionarioServiceImpl;

@ManagedBean(name = "participanteBean")
public class ParticipanteBean {

	private Participante participante = new Participante();
	private Evento evento = new Evento();

	public Evento getAtividade() {
		return evento;
	}

	public void setAtividade(Evento evento) {
		this.evento = evento;
	}

	public ParticipanteBean() {
		this.participante = new Participante();
	}

	public String inserirParticipante() {
		/*
		 * ParticipanteDAO participanteDAO = new ParticipanteJPADAO();
		 * 
		 * participanteDAO.save(this.participante);
		 */
		
		FuncionarioService funcionario = new FuncionarioServiceImpl();
		funcionario.save(participante);
		
		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com sucesso",
				"Inserido com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "/adm/funcionario/listar";

	}

	public String atividadesParticipante() {

		/*ParticipanteDAO dao = new ParticipanteJPADAO();

		participante = dao.find(participante.getId());*/
		
		FuncionarioService service = new FuncionarioServiceImpl();
		participante = service.find(Participante.class, participante.getId());
		
		// HttpSession session =(HttpSession)
		// FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		// session.setAttribute("object-participante", participante);

		return "evento/listarAtividadesDoParticipante.xhtml";
	}

	public List<Participante> getParticipantes() {
		
		ParticipanteDAO dao = new ParticipanteJPADAO();		
//		FuncionarioService funcionarioService = new FuncionarioServiceImpl();
		List<Participante> l = dao.find();
		

		return l;
	}

	public String atualizarParticipante() {
		
		FuncionarioService funcionario = new FuncionarioServiceImpl();
		funcionario.update(participante);
		
		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado com sucesso",
				"Atualizado com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "/adm/funcionario/listar";

	}

	public String addParticipante() {

		AtividadeDAO aDao = new AtividadeJPADAO();

		evento = aDao.find(evento.getId());

		ParticipanteDAO dao = new ParticipanteJPADAO();

		participante = dao.find(participante.getId());

		if (!participante.getAtividades().contains(evento)) {
			participante.getAtividades().add(evento);
			dao.update(participante);
		}

		FacesMessage m = new FacesMessage("Adicionado");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return null;
	}

	public String buscarParticipante() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		ParticipanteDAO dao = new ParticipanteJPADAO();
//		FuncionarioService funcionarioService = new FuncionarioServiceImpl();
		
		
		participante = dao.find(id);

		return "/adm/funcionario/editar";

	}

	public String removerParticipante() {

		Participante participante = new Participante();

		AtividadeDAO aDao = new AtividadeJPADAO();

		System.out.println(evento.getId() + "\n\n\n\n\n");

		evento = aDao.find(evento.getId());

		ParticipanteDAO dao = new ParticipanteJPADAO();

		participante = dao.find(participante.getId());

		participante.getAtividades().remove(evento);
		dao.update(participante);
		dao.commit();

		return "evento/listarAtividadesDoParticipante.xhtml";
	}

	public void deletarParticipante() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		
		ParticipanteDAO dao = new ParticipanteJPADAO();

	//	FuncionarioService funcionarioService = new FuncionarioServiceImpl();
		
		Participante persistedParticipante = dao.find(id);
		dao.delete(persistedParticipante);
		
	}

	public String pesquisa() {
		return "evento/resultadoPesquisa";
	}

	public List<Participante> getPesquisarCpf() {

		ParticipanteDAO participanteDAO = new ParticipanteJPADAO();
		String cpf = participante.getCpf();

		List<Participante> l = participanteDAO.getPesquisa(cpf);

		return l;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

}
