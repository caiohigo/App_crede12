package br.ufc.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.ufc.model.Cidade;
import br.ufc.service.GenericService;
import br.ufc.service.GenericServiceImpl;

@ManagedBean (name="cidadeBean")
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
		
	FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com sucesso",
			"Inserido com sucesso");
	FacesContext.getCurrentInstance().addMessage(null, m);

	return "";

	}


}
