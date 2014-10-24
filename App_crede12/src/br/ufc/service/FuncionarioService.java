package br.ufc.service;

import br.ufc.model.Participante;

public interface FuncionarioService extends GenericService<Participante>{

	public Participante buscarCpf();
	
}
