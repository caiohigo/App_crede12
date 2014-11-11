package br.ufc.dao;

import br.ufc.model.Hospedagem;

public class HospedagemJPADAO extends GenericJPADAO<Hospedagem> implements HospedagemDAO {
	public HospedagemJPADAO(){
		this.persistentClass = Hospedagem.class;
	}
	@Override
	public void update(Hospedagem entity) {
		getEm().merge(entity);
		
	}

}
