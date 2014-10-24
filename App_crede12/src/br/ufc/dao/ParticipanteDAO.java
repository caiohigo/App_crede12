package br.ufc.dao;

import java.util.List;

import br.ufc.model.Participante;

public interface ParticipanteDAO extends GenericDAO<Participante> {
	public List<Participante> getPesquisa(String cpf);
	

	

		
	
	
}
