package br.ufc.dao;


import br.ufc.model.Nucleo;

public class NucleoJPADAO extends GenericJPADAO<Nucleo> implements NucleoDAO {
	public NucleoJPADAO(){
		this.persistentClass = Nucleo.class;
	}
	@Override
	public void update(Nucleo entity) {
		getEm().merge(entity);
		
	}

}
