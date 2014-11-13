package br.ufc.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.ufc.dao.CarroDAO;
import br.ufc.dao.CarroJPADAO;
import br.ufc.dao.CidadeDAO;
import br.ufc.dao.CidadeJPADAO;
import br.ufc.model.Carro;
import br.ufc.model.Cidade;
import br.ufc.service.CadastroService;
import br.ufc.service.CadastroServiceImpl;
import br.ufc.service.GenericService;
import br.ufc.service.GenericServiceImpl;

@ManagedBean(name = "cidadeBean")
public class CidadeBean {

	Cidade cidade = new Cidade();

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String inserirCidade() {

		GenericService<Cidade> cidadeService = new GenericServiceImpl<Cidade>();
		cidadeService.save(cidade);

		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Inserido com sucesso", "Inserido com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "";

	}

	public List<Cidade> getCidades() {

		CidadeDAO cidadeDAO = new CidadeJPADAO();
		List<Cidade> l = cidadeDAO.find();

		return l;
	}

	public String buscarCidade() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));

		CidadeDAO cidadeDao = new CidadeJPADAO();
		cidade = cidadeDao.find(id);

		return "/adm/cadastrar/cidade/editar";

	}

	public String atualizarCidade() {

		CidadeDAO cidadeDao = new CidadeJPADAO();
		cidadeDao.update(cidade);
		
		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Atualizado com sucesso", "Atualizado com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "/adm/cadastrar/cidade/listar";

	}
	
	public void deletarCidade() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));

		CidadeDAO cidadeDAO = new CidadeJPADAO();

		Cidade persistedCidade = cidadeDAO.find(id);
		cidadeDAO.delete(persistedCidade);

	}

}
