package br.com.bean;

public class UsuarioBean {
	private String nome;
	private String email;
	private String senha;
	private Integer id;
	// private ArrayList<Integer> alugadosID;
	
	public UsuarioBean(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		// this.alugadosID = new ArrayList<>();
	}

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

	// public void addVeiculoAlugado(VeiculoBean alugado) {
	// 	this.alugadosID.add(alugado.getId());
	// }

	// public ArrayList<Integer> getAlugados() {
	// 	return alugadosID;
	// }
	
	@Override
	public String toString() {
		return "Id: " + id + " Nome: " + nome + " Email: " + email;
	}
}
