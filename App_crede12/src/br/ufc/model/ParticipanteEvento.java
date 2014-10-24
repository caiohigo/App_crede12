package br.ufc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ParticipanteEvento {

	@Id
	@GeneratedValue
	private long id;
	private String comentario;
	private String tipoParticipacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getTipoParticipacao() {
		return tipoParticipacao;
	}

	public void setTipoParticipacao(String tipoParticipacao) {
		this.tipoParticipacao = tipoParticipacao;
	}

}
