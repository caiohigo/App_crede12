package br.ufc.dao;

import br.ufc.model.Carro;
import br.ufc.model.Cidade;

public class CidadeJPADAO extends GenericJPADAO<Cidade> implements CidadeDAO {
	public CidadeJPADAO(){
		this.persistentClass = Cidade.class;
	}
	@Override
	public void update(Cidade entity) {
		getEm().merge(entity);
		
	}

}
