package br.com.beans;

public class VeiculoBeans {
	String marca;
	String modelo;
	String foto;
	
	public VeiculoBeans(String marca, String modelo, String foto) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.foto = foto;
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
	
	
}
