package br.com.dao;

import java.util.ArrayList;

import br.com.bean.VeiculoBean;

public class VeiculoDAO {
	private static ArrayList<VeiculoBean> lista = null;
	
	public VeiculoDAO() {
		if(lista == null) {
			lista = new ArrayList<>();
			VeiculoBean veiculo = new VeiculoBean("VW", "Gol", "https://i.ytimg.com/vi/shjCEUR5PjQ/maxresdefault.jpg", 125.0, getProxId());
			lista.add(veiculo);
		}
	}
	
	static public boolean insereVeiculo(VeiculoBean veiculo) {
		return lista.add(veiculo);
	}
	
	static public boolean removeVeiculo(VeiculoBean veiculo) {
		return lista.remove(veiculo);
	}
	
	static public void atualizaVeiculo(VeiculoBean veiculo) {
		int id = veiculo.getId();
		lista.remove(id);
		lista.add(id, veiculo);
	}
	
	static public ArrayList<VeiculoBean> lista() {
		return lista;
	}
	
	static public Integer getProxId() {
		return lista.size();
	}
}
