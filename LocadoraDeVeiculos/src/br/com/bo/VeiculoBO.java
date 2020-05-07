package br.com.bo;

import java.util.ArrayList;

import br.com.bean.VeiculoBean;
import br.com.dao.VeiculoDAO;

public class VeiculoBO {
	VeiculoDAO veiculoDAO = new VeiculoDAO();
	
	public boolean insereVeiculo(String marca, String modelo, String foto, Double preco, String descricao) {
		VeiculoBean veiculoBean = new VeiculoBean(marca, modelo, foto, preco, descricao);
		
		if(veiculoDAO.insereVeiculo(veiculoBean)) {
			return true;
		}
		
		return false;
	}

	public void alugar(Integer id, boolean alugar) {
		veiculoDAO.atualizaAlugado(id, alugar);
	}

	public ArrayList<VeiculoBean> lista() {
		return veiculoDAO.lista();
	}
}