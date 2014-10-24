package br.ufc.model;

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
	private String nome;
	private String ministrante;
	private int quantParticipante;
	@Temporal(TemporalType.DATE)
	private Date dataEvento;
	
	
	@OneToMany
	@JoinColumn(name="id_evento")
	private List<ParticipanteEvento> participantesDoEvento;
	
	

	@ManyToMany(mappedBy="eventos", cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.EAGER)
    private List<Participante> participantes;
	
	
	public List<Participante> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMinistrante() {
		return ministrante;
	}
	public void setMinistrante(String ministrante) {
		this.ministrante = ministrante;
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
	public Date getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}
	
	
	

	
	

}
