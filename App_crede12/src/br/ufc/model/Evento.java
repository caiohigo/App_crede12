package br.ufc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@ManagedBean
@Entity
@Table(name="evento")
public class Evento {

	@Id
	@GeneratedValue
	private int id;
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	@Temporal(TemporalType.DATE)
	private Date dataFinal;
	private String nome;
	private String nucleo;
	private String funcionario;
	private String local;
	private String fornecedor;
	private int quantParticipante;

	
	
	@OneToMany(mappedBy="evento")
	private List<ParticipanteEvento> participantesDoEvento;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuantParticipante() {
		return quantParticipante;
	}
	public void setQuantParticipante(int quantParticipante) {
		this.quantParticipante = quantParticipante;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public String getNucleo() {
		return nucleo;
	}
	public void setNucleo(String nucleo) {
		this.nucleo = nucleo;
	}
	public String getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public List<ParticipanteEvento> getParticipantesDoEvento() {
		return participantesDoEvento;
	}
	public void setParticipantesDoEvento(
			List<ParticipanteEvento> participantesDoEvento) {
		this.participantesDoEvento = participantesDoEvento;
	}
	

	
	

}
