package br.ufc.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;



import br.ufc.model.Quarto;
import br.ufc.service.GenericService;
import br.ufc.service.GenericServiceImpl;

@ManagedBean(name="quartoBean")
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
			
		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com sucesso",
				"Inserido com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);

		return "";

		}

}
