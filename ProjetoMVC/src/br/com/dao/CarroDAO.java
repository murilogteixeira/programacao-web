package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.bean.CarroBean;

// Acesso ao banco de dados
public class CarroDAO {
	private static List<CarroBean> lista = null;
	
	public CarroDAO() {
		if (lista == null) {
			lista = new ArrayList<CarroBean>();
			CarroBean carro = new CarroBean("Opala", "Chevrolet");
			lista.add(carro);
		}
	}
	
	public boolean insereCarro(CarroBean carro) {
		return lista.add(carro);
	}
}
