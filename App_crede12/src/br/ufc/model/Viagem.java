package br.ufc.model;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Table;
@Entity
@ManagedBean (name="viagem")
@Table(name="viagem")
public class Viagem {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	
	private String horarioSaida;
	private String horarioChegada;

	private String municipio;
	
	private String evento;
	
	private String tecnico;
	
	private String distancia;
	
	private String Carro;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getHorarioSaida() {
		return horarioSaida;
	}
	public void setHorarioSaida(String horarioSaida) {
		this.horarioSaida = horarioSaida;
	}
	public String getHorarioChegada() {
		return horarioChegada;
	}
	public void setHorarioChegada(String horarioChegada) {
		this.horarioChegada = horarioChegada;
	}
		public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	public String getTecnico() {
		return tecnico;
	}
	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}
	public String getDistancia() {
		return distancia;
	}
	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}
	public String getCarro() {
		return Carro;
	}
	public void setCarro(String carro) {
		Carro = carro;
	}
	public Viagem(int id, Date data, String horarioSaida,
			String horarioChegada, String municipio, String evento,
			String tecnico, String distancia, String carro) {
		super();
		this.id = id;
		this.data = data;
		this.horarioSaida = horarioSaida;
		this.horarioChegada = horarioChegada;
		this.municipio = municipio;
		this.evento = evento;
		this.tecnico = tecnico;
		this.distancia = distancia;
		Carro = carro;
	}
	public Viagem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
