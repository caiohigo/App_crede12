package br.ufc.enumeration;

public enum EnumLogin {

	LOGIN("1"),SENHA("1");
	
    EnumLogin(String conteudo){
		this.conteudo = conteudo;
	}
	
	private String conteudo;

	public String getConteudo() {
		return conteudo;
	}
	
	
	
}
