package br.com.bo;

import br.com.bean.VeiculoBean;
import br.com.dao.VeiculoDAO;

public class VeiculoBO {
	VeiculoDAO veiculoDAO = new VeiculoDAO();
	
	public boolean insereVeiculo(String marca, String modelo, String foto, Double preco) {
		VeiculoBean veiculoBean = new VeiculoBean(marca, modelo, foto, preco, VeiculoDAO.getProxId());
		
		if(veiculoDAO.insereVeiculo(veiculoBean)) {
			return true;
		}
		
		return false;
	}
}
