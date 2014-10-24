package br.ufc.dao;


import br.ufc.model.Viagem;

public class ViagemJPADAO extends GenericJPADAO<Viagem> implements ViagemDAO {
	public ViagemJPADAO(){
		this.persistentClass = Viagem.class;
	}

	@Override
	public void update(Viagem entity) {
		getEm().merge(entity);
		
	}
}
