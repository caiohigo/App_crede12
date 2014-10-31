package br.ufc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ParticipanteEvento {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(nullable = false, name = "id_participante")
	private Participante participante;

	@ManyToOne
	@JoinColumn(nullable = false, name = "id_evento")
	private Evento evento;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
