package br.ufc.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.ufc.model.Hospedagem;
import br.ufc.service.HospedagemService;
import br.ufc.service.HospedagemServiceImpl;
import br.ufc.service.ViagemService;
import br.ufc.service.ViagemServiceImpl;

@ManagedBean(name="hospedagembean")
public class HospedagemBean {
	Hospedagem hospedagem = new Hospedagem();
		
	
	public Hospedagem getHospedagem() {
		return hospedagem;
	}
	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
		
		
	}
	
	
	public String inserirHospedagem (){
		HospedagemService hospedagens = new HospedagemServiceImpl();
		hospedagens.save(hospedagem);
		
		FacesMessage m = new FacesMessage("inserido com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);
		
		return "/adm/hospedagem/listarHospedagem";
	}
	
	public String atualizarHospedegem(){
		HospedagemService hospedagens = new HospedagemServiceImpl();
		hospedagens.update(hospedagem);
		
		FacesMessage m = new FacesMessage("Atualizado com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, m);
		
		return "/adm/hospedagem/listarHospedagem";
	}
	
	public void deletarHospede(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		
		HospedagemService hospedagens = new HospedagemServiceImpl();
		hospedagens.delete(hospedagem);
		
		
	}
	

}
