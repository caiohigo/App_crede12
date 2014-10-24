package br.ufc.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.ufc.enumeration.EnumLogin;

@ManagedBean(name="loginBean")
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 9108781020220176401L;
	private String nome;
	private String senha;

	public LoginBean() {
		System.out.println("construtor login bean");
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}
	
	public String logout(){
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		
		return "/login";
	}
	public String login() {
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if (EnumLogin.LOGIN.getConteudo().equals("1") && EnumLogin.SENHA.getConteudo().equals("1")) {
			if (session == null) {
				session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			}
			session.setAttribute("nome", nome);
			return "/adm/index?faces-redirect=true";
		} else {
			if (session != null) {
				session.invalidate();
			}
		}
		FacesContext.getCurrentInstance().addMessage("Login ou senha invalido", new FacesMessage("Login ou senha, invalido"));
		return "/login";
		
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}

