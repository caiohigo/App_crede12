package br.ufc.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;



import javax.servlet.http.HttpServletRequest;

import br.ufc.dao.CarroDAO;
import br.ufc.dao.CarroJPADAO;
import br.ufc.dao.NucleoDAO;
import br.ufc.dao.NucleoJPADAO;
import br.ufc.model.Carro;
import br.ufc.model.Nucleo;
import br.ufc.service.GenericService;
import br.ufc.service.GenericServiceImpl;

@ManagedBean(name="nucleoBean")
public class NucleoBean {
	
	Nucleo nucleo = new Nucleo();
	

	public Nucleo getNucleo() {
		return nucleo;
	}


	public void setNucleo(Nucleo nucleo) {
		this.nucleo = nucleo;
	}


	public String inserirNucleo() {
		
		GenericService<Nucleo> nucleoService = new GenericServiceImpl<Nucleo>();
		nucleoService.save(nucleo);
			
		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com sucesso",
				"Inserido com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "";

		}
	
	public List<Nucleo> getNucleos() {

		NucleoDAO nucleoDAO = new NucleoJPADAO();
		List<Nucleo> l = nucleoDAO.find();

		return l;
	}

	public String buscarNucleo() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));

		NucleoDAO nucleoDAO = new NucleoJPADAO();
		nucleo = nucleoDAO.find(id);
		

		return "/adm/cadastrar/nucleo/editar";

	}

	public String atualizarNucleo() {

		NucleoDAO nucleoDAO = new NucleoJPADAO();
		nucleoDAO.update(nucleo);

		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Atualizado com sucesso", "Atualizado com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "/adm/cadastrar/nucleo/listar";

	}

	public void deletarNucleo() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));

		NucleoDAO nucleoDAO = new NucleoJPADAO();

		Nucleo persistedNucleo = nucleoDAO.find(id);
		nucleoDAO.delete(persistedNucleo);

	}
	
}
