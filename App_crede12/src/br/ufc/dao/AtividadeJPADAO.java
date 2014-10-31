package br.ufc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.ufc.model.Evento;
import br.ufc.model.Participante;
import br.ufc.model.ParticipanteEvento;


public class AtividadeJPADAO extends GenericJPADAO<Evento> implements AtividadeDAO {
	public AtividadeJPADAO(){
		this.persistentClass = Evento.class;
	}

	@Override
	public void update(Evento entity) {
		getEm().merge(entity);
		
	}

	@Override
	public void adicionarParticipantes(Evento evento, List<Participante> participantes) {
		
		for (Participante participante : participantes) {
			
			ParticipanteEvento participanteEvento = new ParticipanteEvento();
			participanteEvento.setEvento(evento);
			participanteEvento.setParticipante(participante);

			System.out.println("Teste");
			getEm().persist(participanteEvento);	
			
		}
		
	}
	
	public List<Participante> participanteForaDoEvento(Evento evento){
		
		Query query = getEm().createQuery("select distinct p from Participante p where not exists (select pe from ParticipanteEvento pe where pe.participante = p.id and pe.evento = :evento)");
		
		query.setParameter("evento", evento);
		
		return query.getResultList();
	}

	public static void main(String[] args) {
		AtividadeJPADAO dao = new AtividadeJPADAO();
		Evento e = new Evento();
		e.setId(1);
		
		System.out.println(dao.participanteForaDoEvento(e));
		
	}

	@Override
	public List<Participante> participanteNoEvento(Evento evento) {

		String hql = "select p from Participante p, ParticipanteEvento pe where p = pe.participante and pe.evento = :evento";	
		
		Query query = getEm().createQuery(hql);
		
		query.setParameter("evento", evento);
		
		List<Participante> list = query.getResultList();
		
		return (list != null)? list : new ArrayList<Participante>();
	}
	
}

