package br.ufc.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.ufc.dao.CidadeDAO;
import br.ufc.dao.CidadeJPADAO;
import br.ufc.dao.FornecedorDAO;
import br.ufc.dao.FornecedorJPADAO;
import br.ufc.dao.HospedagemDAO;
import br.ufc.dao.HospedagemJPADAO;
import br.ufc.model.Cidade;
import br.ufc.model.Fornecedor;
import br.ufc.model.Hospedagem;
import br.ufc.service.GenericService;
import br.ufc.service.GenericServiceImpl;

@ManagedBean(name = "fornecedorBean")
public class FornecedorBean {

	Fornecedor fornecedor = new Fornecedor();

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String inserirFornecedor() {

		GenericService<Fornecedor> fornecedorService = new GenericServiceImpl<Fornecedor>();
		fornecedorService.save(fornecedor);

		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Inserido com sucesso", "Inserido com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "";

	}

	public List<Fornecedor> getFornecedores() {

		FornecedorDAO fornecedorDao = new FornecedorJPADAO();
		List<Fornecedor> l = fornecedorDao.find();

		return l;
	}

	public String buscarFornecedor() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));

		FornecedorDAO fornecedorDao = new FornecedorJPADAO();
		fornecedor = fornecedorDao.find(id);

		return "/adm/cadastrar/fornecedor/editar";

	}

	public String atualizarFornecedor() {

		FornecedorDAO fornecedorDao = new FornecedorJPADAO();
		fornecedorDao.update(fornecedor);

		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Atualizado com sucesso", "Atualizado com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "/adm/cadastrar/fornecedor/listar";

	}
	
	public void deletarFornecedor() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));

		FornecedorDAO fornecedorDAO = new FornecedorJPADAO();

		Fornecedor persistedFornecedor = fornecedorDAO.find(id);
		fornecedorDAO.delete(persistedFornecedor);

	}

}
