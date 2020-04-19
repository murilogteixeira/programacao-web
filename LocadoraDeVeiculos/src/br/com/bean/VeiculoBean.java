package br.com.bean;

public class VeiculoBean {
	private String marca;
	private String modelo;
	private String foto;
	private Double preco;
	private Integer id;
	
	public VeiculoBean(String marca, String modelo, String foto, Double preco, Integer id) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.foto = foto;
		this.preco = preco;
		this.id = id;
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

	public Integer getId() {
		return id;
	}
	
}
