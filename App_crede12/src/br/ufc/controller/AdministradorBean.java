package br.ufc.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.ufc.dao.AdministradorDAO;
import br.ufc.dao.AdministradorJPADAO;
import br.ufc.model.Administrador;

@ManagedBean
public class AdministradorBean {

	private Administrador administrador;
	private String novaSenha;

	public AdministradorBean(){
		this.administrador = new Administrador();
	}
	
	public String adicionarAdministrador(){
		try{
			AdministradorDAO dao = new AdministradorJPADAO();
			if(dao.loginExistente(administrador)){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível cadastrar administrador, nome de login já utilizado"));
				return "/adm/index";
			}
			
			dao.save(administrador);
	
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Administrador adicionado"));
		}catch(Exception ex){
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível cadastrar administrador, nome de login já utilizado"));
			
		}
		return "/adm/index";
	}
	
	public String alterarSenha(){
		
		try{
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			
			Administrador adm = (Administrador)session.getAttribute("adm");
			
			if(adm != null){
				AdministradorDAO dao = new AdministradorJPADAO();
				adm = dao.find(adm.getId());
				
				adm.setSenha(novaSenha);
				
				dao.update(adm);
				
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Senha alterada com sucesso!"));
			
		}catch(Exception ex){
			ex.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aconteceu um erro ao alterar senha!"));
		}

		return "/adm/index";
	}
	
	
	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}
	
	

}
