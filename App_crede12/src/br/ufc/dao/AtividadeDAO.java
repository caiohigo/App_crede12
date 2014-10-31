package br.ufc.dao;

import java.util.List;

import br.ufc.model.Evento;
import br.ufc.model.Participante;

public interface AtividadeDAO extends GenericDAO<Evento> {

	public void adicionarParticipantes(Evento evento,List<Participante> participantes);
	public List<Participante> participanteForaDoEvento(Evento evento);
	public List<Participante> participanteNoEvento(Evento evento);
	
}
