package br.com.dao;

import java.util.ArrayList;

import br.com.bean.VeiculoBean;

public class VeiculoDAO {
	private static ArrayList<VeiculoBean> lista = null;
	
	public VeiculoDAO() {
		if(lista == null) {
			lista = new ArrayList<>();
			VeiculoBean veiculo1 = new VeiculoBean("Volkwagem", "Arteon", "https://i.ytimg.com/vi/shjCEUR5PjQ/maxresdefault.jpg", 125.0, getProxId());
			lista.add(veiculo1);
			VeiculoBean veiculo2 = new VeiculoBean("Dodge", "Challenger", "https://i.ytimg.com/vi/shjCEUR5PjQ/maxresdefault.jpg", 125.0, getProxId());
			lista.add(veiculo2);
			VeiculoBean veiculo3 = new VeiculoBean("Audi", "RS6", "https://i.ytimg.com/vi/shjCEUR5PjQ/maxresdefault.jpg", 125.0, getProxId());
			lista.add(veiculo3);
			VeiculoBean veiculo4 = new VeiculoBean("Renault", "Optima", "https://i.ytimg.com/vi/shjCEUR5PjQ/maxresdefault.jpg", 125.0, getProxId());
			lista.add(veiculo4);
		}
	}
	
	public boolean insereVeiculo(VeiculoBean veiculo) {
		return lista.add(veiculo);
	}
	
	public boolean removeVeiculo(VeiculoBean veiculo) {
		return lista.remove(veiculo);
	}
	
	public void atualizaVeiculo(VeiculoBean veiculo) {
		int id = veiculo.getId();
		lista.remove(id);
		lista.add(id, veiculo);
	}
	
	public ArrayList<VeiculoBean> lista() {
		return lista;
	}
	
	static public Integer getProxId() {
		return lista.size();
	}
}
