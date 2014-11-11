package br.ufc.dao;


import br.ufc.model.Quarto;

public class QuartoJPADAO extends GenericJPADAO<Quarto> implements QuartoDAO {
	public QuartoJPADAO(){
		this.persistentClass = Quarto.class;
	}
	@Override
	public void update(Quarto entity) {
		getEm().merge(entity);
		
	}

}
