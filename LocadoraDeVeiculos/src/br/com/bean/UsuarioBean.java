package br.com.bean;

public class UsuarioBean {
	String nome;
	String email;
	String senha;
	Integer id;
	
	public UsuarioBean(String nome, String email, String senha, Integer id) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Id: " + id + " Nome: " + nome + " Email: " + email;
	}
}
