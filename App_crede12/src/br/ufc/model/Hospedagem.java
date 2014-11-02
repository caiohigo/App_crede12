package br.ufc.model;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@ManagedBean (name="hospedagem")
@Table(name="hospedagem")
public class Hospedagem {
	
	@Id
	@GeneratedValue
	private int id;
	
	// id, data da entrada , data da saída, nome do hospede , sexo masculino ou feminino 
	
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Date dataEntrada;
	
	@Temporal(TemporalType.DATE)
	private Date dataSaida;
	
	private String quarto;
	
	private String obs;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getQuarto() {
		return quarto;
	}

	public void setQuarto(String quarto) {
		this.quarto = quarto;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	
	
	
	

}
