package br.ufc.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.ufc.dao.AdministradorDAO;
import br.ufc.dao.AdministradorJPADAO;
import br.ufc.enumeration.EnumLogin;
import br.ufc.model.Administrador;

@ManagedBean(name="loginBean")
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 9108781020220176401L;

	private Administrador administrador;
	
	public LoginBean() {
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if (session != null) {
			session.invalidate();
		}
		administrador = new Administrador();
	}
	
	public String logout(){
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		
		return "/login";
	}
	public String login() {
		
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
		AdministradorDAO admDAO = new AdministradorJPADAO();
		
		administrador = admDAO.autenticaAdministrador(administrador);
		
		if (administrador != null) {
			if (session == null) {
				session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			}
			session.setAttribute("adm", administrador);
			return "/adm/index?faces-redirect=true";
		} else {
			if (session != null) {
				session.invalidate();
			}
		}
		FacesContext.getCurrentInstance().addMessage("Login ou senha invalido", new FacesMessage("Login ou senha, invalido"));
		return "/login";
		
		
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	
	
}

