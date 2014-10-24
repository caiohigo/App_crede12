package br.ufc.model;



import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@ManagedBean(name="participante")
@Entity
@Table(name="participante")
@NamedQuery(name="Participante.pesquisarCpf", query="Select p from Participante p where p.cpf = :cpf")
public class Participante  {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String cpf;
	
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	
	private String endereco;
	
	private String cidade;
	
	private String uf;
	
	private String cep;
	
	private String telefone;
	
	private String email;
	
	
	
	@ManyToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinTable(name = "atividade_participante" ,joinColumns= @JoinColumn(name="participante_id"), inverseJoinColumns=@JoinColumn(name="atividade_id" ))
	private List<Evento> eventos;
	
	@OneToMany
	@JoinColumn(name="id_participante")
	private List<ParticipanteEvento> eventosDoParticipante;
	
	public Participante(String cpf, String nome, Date data, String endereco,
			String cidade, String uf, String cep, String telefone, String email) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.data = data;
		this.endereco = endereco;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.telefone = telefone;
		this.email = email;
	}
	public List<Evento> getAtividades() {
		return eventos;
	}
	public void setAtividades(List<Evento> eventos) {
		this.eventos = eventos;
	}
	public Participante() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
