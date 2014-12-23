package br.ufc.dao;

import java.sql.SQLException;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import br.ufc.model.Administrador;

public class AdministradorJPADAO extends GenericJPADAO<Administrador> implements
		AdministradorDAO {

	public AdministradorJPADAO() {
		this.persistentClass = Administrador.class;
	}

	@Override
	public Administrador autenticaAdministrador(Administrador administrador) {

		String hql = "select a from Administrador a where a.login = :login and a.senha = :senha";

		Query query = this.getEm().createQuery(hql);
		query.setParameter("login", administrador.getLogin());
		query.setParameter("senha", administrador.getSenha());

		Administrador admAutenticado = null;

		try {
			admAutenticado = (Administrador) query.getSingleResult();
		} catch (PersistenceException ex) {
			ex.printStackTrace();
			return null;
		}

		return admAutenticado;
	}

	@Override
	public boolean loginExistente(Administrador administrador) {

		String hql = "select a from Administrador a where login = :login";

		Query query = getEm().createNamedQuery(hql);
		query.setParameter("login", administrador.getLogin());

		try {
			Object obj = query.getFirstResult();
			if (obj != null) {
				return true;
			}
		} catch (PersistenceException ex) {
			return false;
		}

		return false;
	}

}
