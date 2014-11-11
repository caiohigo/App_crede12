package br.ufc.dao;

import br.ufc.model.Fornecedor;

public class FornecedorJPADAO extends GenericJPADAO<Fornecedor> implements FornecedorDAO{
	public FornecedorJPADAO(){
		this.persistentClass = Fornecedor.class;
	}
	@Override
	public void update(Fornecedor entity) {
		getEm().merge(entity);
		
	}

}
