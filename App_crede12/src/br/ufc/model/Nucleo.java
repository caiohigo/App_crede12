package br.ufc.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;

@ManagedBean
@Entity
public class Nucleo {
	
	private String nome;
	private String sigla;
	private String coordenador;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getCoordenador() {
		return coordenador;
	}
	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}
	
	
	

}
