package br.ufc.dao;


import br.ufc.model.LocalEvento;

public class LocalEventoJPADAO extends GenericJPADAO<LocalEvento> implements LocalEventoDAO {
	public LocalEventoJPADAO(){
		this.persistentClass = LocalEvento.class;
	}
	@Override
	public void update(LocalEvento entity) {
		getEm().merge(entity);
		
	}

}
