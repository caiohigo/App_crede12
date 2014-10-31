package br.ufc.dao;

import javax.persistence.Query;

import br.ufc.model.Evento;
import br.ufc.model.Participante;
import br.ufc.model.ParticipanteEvento;

public class ParticipanteEventoJPADAO extends GenericJPADAO<ParticipanteEvento> implements ParticipanteEventoDAO{

	public ParticipanteEventoJPADAO() {
		this.persistentClass = ParticipanteEvento.class;
	}
	
	@Override
	public ParticipanteEvento getParticipanteEvento(Participante participante, Evento evento){

		String hql = "select pe from ParticipanteEvento pe where pe.evento = :evento and pe.participante = :participante";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("evento", evento);
		query.setParameter("participante", participante);
		
		return (ParticipanteEvento)query.getSingleResult();
	}
	
	
}
