package br.com.bean;

public class VeiculoBean {
	private String marca;
	private String modelo;
	private String foto;
	private Double preco;
	private Integer id;
	private boolean alugado;
	private String descricao;
	
	public VeiculoBean(String marca, String modelo, String foto, Double preco, String descricao, Integer id, boolean alugado) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.foto = foto;
		this.preco = preco;
		this.id = id;
		this.alugado = alugado;
		this.descricao = descricao;
	}
	
	public VeiculoBean(String marca, String modelo, String foto, Double preco, String descricao) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.foto = foto;
		this.preco = preco;
		this.alugado = false;
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
	
	public boolean getAlugado() {
		return alugado;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Id: " + id + " Marca: " + marca + " Modelo: " + modelo + " Preço: " + preco;
	}
	
}
