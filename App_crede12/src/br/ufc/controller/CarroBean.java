package br.ufc.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.metamodel.source.annotations.entity.EntityClass;

import com.sun.xml.internal.stream.Entity;

import br.ufc.service.CadastroService;
import br.ufc.service.CadastroServiceImpl;
import br.ufc.service.FuncionarioService;
import br.ufc.service.FuncionarioServiceImpl;
import br.ufc.service.GenericService;
import br.ufc.service.GenericServiceImpl;
import br.ufc.dao.CarroDAO;
import br.ufc.dao.CarroJPADAO;
import br.ufc.dao.GenericDAO;
import br.ufc.dao.GenericJPADAO;
import br.ufc.dao.ParticipanteDAO;
import br.ufc.dao.ParticipanteJPADAO;
import br.ufc.model.Carro;
import br.ufc.model.Participante;

@ManagedBean(name = "carroBean")
public class CarroBean {

	Carro carro = new Carro();

	public String inserirCarro() {

		CadastroService carroN = new CadastroServiceImpl();
		carroN.save(carro);

		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Inserido com sucesso", "Inserido com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "";

	}

	public List<Carro> getCarros() {

		CarroDAO carroDAO = new CarroJPADAO();
		List<Carro> l = carroDAO.find();
		
		
		return l;
	}
	
	

	public String buscarCarro() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		
		CadastroService carroService  = new CadastroServiceImpl(); 
		carro = carroService.find(Carro.class,id);
		
		return "/adm/cadastrar/carro/editar";

	}

	public String atualizarCarro() {

		CadastroService carroService  = new CadastroServiceImpl(); 
		carroService.update(carro);

		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Atualizado com sucesso", "Atualizado com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "/adm/cadastrar/carro/listar";

	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

}
