package br.ufc.dao;

import java.util.List;

import javax.persistence.Query;

import br.ufc.model.Participante;


public class ParticipanteJPADAO extends GenericJPADAO<Participante> implements ParticipanteDAO {
	
	public ParticipanteJPADAO() {
		this.persistentClass = Participante.class;
	}

	@Override
	public void update(Participante entity) {
		getEm().merge(entity);
		
	}
	
	public List<Participante> getPesquisa(String cpf){
		Query query = getEm().createNamedQuery("Participante.pesquisarCpf",Participante.class);
		query.setParameter("cpf", cpf);
		return query.getResultList();
		
	}

}
