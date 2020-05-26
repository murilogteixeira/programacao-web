package br.com.bean;

// Modelo
public class CarroBean {
	private String fabricanteCarro;
	
	private String modeloCarro;

	public CarroBean(String fabricanteCarro, String modeloCarro) {
		super();
		this.fabricanteCarro = fabricanteCarro;
		this.modeloCarro = modeloCarro;
	}

	public String getFabricanteCarro() {
		return fabricanteCarro;
	}

	public void setFabricanteCarro(String fabricanteCarro) {
		this.fabricanteCarro = fabricanteCarro;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}
	
}
