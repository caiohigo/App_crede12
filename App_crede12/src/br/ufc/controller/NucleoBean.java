package br.ufc.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

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
}