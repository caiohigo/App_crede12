package br.ufc.dao;

import br.ufc.model.Evento;
import br.ufc.model.Participante;
import br.ufc.model.ParticipanteEvento;

public interface ParticipanteEventoDAO extends GenericDAO<ParticipanteEvento>{

	public ParticipanteEvento getParticipanteEvento(Participante participante, Evento evento);
	
}
