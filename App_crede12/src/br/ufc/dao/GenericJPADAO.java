package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.ufc.utils.JPAUtils;

public class GenericJPADAO<T> implements GenericDAO<T> {

	 protected Class<T> persistentClass;
	 
		public void save(T entity) {
			getEm().persist(entity);
		}
		
	 
		public void delete(T entity) {
			getEm().remove(getEm().merge(entity));
		}
	 
		
		public void update(T entity) {
			getEm().merge(entity);
		}

		public T find(Object id) {
			return getEm().find(persistentClass, id);
		}
	 
		public List<T> find() {
			CriteriaQuery<T> cq = getEm().getCriteriaBuilder().createQuery(persistentClass);
			cq.from(persistentClass);
			return getEm().createQuery(cq).getResultList();
		}
	 
		public List<T> find(Class type) {
			CriteriaQuery<T> cq = getEm().getCriteriaBuilder().createQuery(persistentClass);
			cq.from(type);
			return getEm().createQuery(cq).getResultList();
		}
		
		public EntityManager getEm() {
			return JPAUtils.getEntityManager();
		}
	 
		public void beginTransaction() {
			JPAUtils.beginTransaction();
		}
	 
		public void commit() {
			JPAUtils.commit();
		}
	 
		public void rollback() {
			JPAUtils.rollback();
		}
	 
		public void close() {
			JPAUtils.closeEntityManager();
		}
}
