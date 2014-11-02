package br.ufc.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.ufc.service.CadastroService;
import br.ufc.service.CadastroServiceImpl;
import br.ufc.model.Carro;



@ManagedBean (name="carroBean")
public class CarroBean {
	
	Carro carro = new Carro();
	
		
	public String inserirCarro() {
		
		CadastroService carroN = new CadastroServiceImpl();
		carroN.save(carro);
			
		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com sucesso",
				"Inserido com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "";

	}


	public Carro getCarro() {
		return carro;
	}


	public void setCarro(Carro carro) {
		this.carro = carro;
	}


	

	


	

}
