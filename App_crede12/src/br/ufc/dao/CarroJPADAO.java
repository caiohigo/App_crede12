package br.ufc.dao;

import br.ufc.model.Carro;


public class CarroJPADAO extends GenericJPADAO<Carro> implements CarroDAO {
	public CarroJPADAO(){
		this.persistentClass = Carro.class;
	}
	@Override
	public void update(Carro entity) {
		getEm().merge(entity);
		
	}
}
