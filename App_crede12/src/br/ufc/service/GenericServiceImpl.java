package br.ufc.service;

import java.util.List;
import java.util.Map;

import br.ufc.dao.GenericDAO;
import br.ufc.dao.GenericJPADAO;

public class GenericServiceImpl<T> implements GenericService<T> {

	private GenericDAO<T> genericDao;
	
	public GenericServiceImpl() {
		this.genericDao = new GenericJPADAO<T>();
	}
	
	@Override
	public void save(T entity) {
		genericDao.save(entity);
	}

	@Override
	public void update(T entity) {
		genericDao.update(entity);
	}

	@Override
	public T find(Class<T> entityClass, Object id) {
		return genericDao.find(id);
	}

	@Override
	public List<T> find(Class<T> entityClass) {
		return genericDao.find(entityClass);
	}

	@Override
	public void delete(T entity) {
		genericDao.delete(entity);
	}

	@Override
	public List<T> find(String query, Map<String, Object> namedParams) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
