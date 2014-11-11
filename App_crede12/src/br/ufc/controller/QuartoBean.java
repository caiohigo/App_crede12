package br.ufc.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.ufc.dao.CarroDAO;
import br.ufc.dao.CarroJPADAO;
import br.ufc.dao.QuartoDAO;
import br.ufc.dao.QuartoJPADAO;
import br.ufc.model.Carro;
import br.ufc.model.Quarto;
import br.ufc.service.GenericService;
import br.ufc.service.GenericServiceImpl;

@ManagedBean(name = "quartoBean")
public class QuartoBean {

	Quarto quarto = new Quarto();

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public String inserirQuarto() {

		GenericService<Quarto> quartoService = new GenericServiceImpl<Quarto>();
		quartoService.save(quarto);

		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Inserido com sucesso", "Inserido com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "";

	}

	public List<Quarto> getQuartos() {

		QuartoDAO quartoDAO = new QuartoJPADAO();
		List<Quarto> l = quartoDAO.find();

		return l;
	}

	public String buscarQuarto() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));

		QuartoDAO quartoDAO = new QuartoJPADAO();
		quarto = quartoDAO.find(id);

		return "/adm/cadastrar/quarto/editar";

	}

	public String atualizarQuarto() {

		QuartoDAO quartoDAO = new QuartoJPADAO();
		quartoDAO.update(quarto);

		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Atualizado com sucesso", "Atualizado com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "/adm/cadastrar/quarto/listar";

	}

	public void deletarQuarto() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));

		QuartoDAO quartoDAO = new QuartoJPADAO();

		Quarto persistedQuarto = quartoDAO.find(id);
		quartoDAO.delete(persistedQuarto);

	}

}
