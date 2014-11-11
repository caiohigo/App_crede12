package br.ufc.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.ufc.dao.CarroDAO;
import br.ufc.dao.CarroJPADAO;
import br.ufc.dao.GenericDAO;
import br.ufc.dao.GenericJPADAO;
import br.ufc.dao.HospedagemDAO;
import br.ufc.dao.HospedagemJPADAO;
import br.ufc.dao.ParticipanteDAO;
import br.ufc.dao.ParticipanteJPADAO;
import br.ufc.model.Carro;
import br.ufc.model.Hospedagem;
import br.ufc.model.Participante;
import br.ufc.service.HospedagemService;
import br.ufc.service.HospedagemServiceImpl;
import br.ufc.service.ViagemService;
import br.ufc.service.ViagemServiceImpl;

@ManagedBean(name = "hospedagembean")
public class HospedagemBean {
	Hospedagem hospedagem = new Hospedagem();

	public Hospedagem getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;

	}

	public String inserirHospedagem() {
		HospedagemService hospedagens = new HospedagemServiceImpl();
		hospedagens.save(hospedagem);

		FacesMessage m = new FacesMessage("inserido com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "/adm/hospedagem/listarHospedagem";
	}

	public List<Hospedagem> getHospedagens() {

		HospedagemDAO hospedagemDAO = new HospedagemJPADAO();
		List<Hospedagem> l = hospedagemDAO.find();

		return l;
	}

	public String buscarHospedagem() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));

		HospedagemDAO hospedagemDAO = new HospedagemJPADAO();
		hospedagem = hospedagemDAO.find(id);

		return "/adm/cadastrar/hospedagem/editar";

	}

	public String atualizarHospedagem() {

		HospedagemDAO hospedagemDAO = new HospedagemJPADAO();
		hospedagemDAO.update(hospedagem);

		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Atualizado com sucesso", "Atualizado com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "/adm/cadastrar/hospedagem/listar";

	}

	public void deletarHospedagem() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));

		HospedagemDAO hospedagemDAO = new HospedagemJPADAO();

		Hospedagem persistedHospedagem = hospedagemDAO.find(id);
		hospedagemDAO.delete(persistedHospedagem);

	}

}
