package br.com.mind.to;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;

@XmlRootElement
public class CadastroTo {

	private int id;
	private String nome;
	private String crp;
	private String rm;
	private String nomeInstituicao;
	private long cpf;
	private long telefone;
	private String email;
	
	private String dataNascimento;
	private String genero;
	private String tempoConversa;
	private String linhaTerapeutica;
	private String senha;
	private long avatar;
	private String tempoUso;
	
	public CadastroTo() {
		super();
	}

	public CadastroTo(int id, String nome, String senha, String email, String genero,String crp, String dataNascimento, 
			String rm, String nomeInstituicao, long cpf, long telefone,
			String tempoConversa, String linhaTerapeutica,
			long avatar, String tempoUso) {
		super();
		this.id = id;
		this.nome = nome;
		this.crp = crp;
		this.rm = rm;
		this.nomeInstituicao = nomeInstituicao;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.tempoConversa = tempoConversa;
		this.linhaTerapeutica = linhaTerapeutica;
		this.senha = senha;
		this.avatar = avatar;
		this.tempoUso = tempoUso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrp() {
		return crp;
	}

	public void setCrp(String crp) {
		this.crp = crp;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTempoConversa() {
		return tempoConversa;
	}

	public void setTempoConversa(String tempoConversa) {
		this.tempoConversa = tempoConversa;
	}

	public String getLinhaTerapeutica() {
		return linhaTerapeutica;
	}

	public void setLinhaTerapeutica(String linhaTerapeutica) {
		this.linhaTerapeutica = linhaTerapeutica;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getAvatar() {
		return avatar;
	}

	public void setAvatar(long avatar) {
		this.avatar = avatar;
	}

	public String getTempoUso() {
		return tempoUso;
	}

	public void setTempoUso(String tempoUso) {
		this.tempoUso = tempoUso;
	}
	
	

}
