package br.ufc.controller;

import javax.faces.bean.ManagedBean;

import br.ufc.model.LocalEvento;
import br.ufc.service.LocalService;
import br.ufc.service.LocalServiceImpl;

@ManagedBean
public class LocalBean {
	
	LocalEvento localEvento = new LocalEvento();

	public LocalEvento getLocalEvento() {
		return localEvento;
	}

	public void setLocalEvento(LocalEvento localEvento) {
		this.localEvento = localEvento;
	}
	
	public String inserirLocal(){
		
		LocalService localService = new LocalServiceImpl();
		localService.save(localEvento);
		
		
		
		return "";
	}

}
