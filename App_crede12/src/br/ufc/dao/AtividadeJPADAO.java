package br.ufc.dao;

import br.ufc.model.Evento;


public class AtividadeJPADAO extends GenericJPADAO<Evento> implements AtividadeDAO {
	public AtividadeJPADAO(){
		this.persistentClass = Evento.class;
	}

	@Override
	public void update(Evento entity) {
		getEm().merge(entity);
		
	}
}

