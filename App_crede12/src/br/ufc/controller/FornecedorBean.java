package br.ufc.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.ufc.model.Fornecedor;
import br.ufc.service.GenericService;
import br.ufc.service.GenericServiceImpl;

@ManagedBean(name="fornecedorBean")
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
			
		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com sucesso",
				"Inserido com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "";

	}


}
