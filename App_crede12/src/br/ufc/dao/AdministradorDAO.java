package br.ufc.dao;

import br.ufc.model.Administrador;

public interface AdministradorDAO extends GenericDAO<Administrador>{

	public Administrador autenticaAdministrador(Administrador administrador);
	
}
