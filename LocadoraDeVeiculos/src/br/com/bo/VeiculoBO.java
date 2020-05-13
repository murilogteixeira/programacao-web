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

	public void atualizarVeiculo(VeiculoBean veiculo) {
		veiculoDAO.atualizaVeiculo(veiculo);
	}

	public void alugarVeiculo(Integer id, boolean alugado) {
		VeiculoBean veiculo = veiculoDAO.buscarVeiculo(id);
		veiculo.setAlugado(alugado);
		veiculoDAO.atualizaVeiculo(veiculo);
	}

	public ArrayList<VeiculoBean> listarTodos() {
		return veiculoDAO.lista();
	}

	public ArrayList<VeiculoBean> listarModelos(String filter) {
		return veiculoDAO.lista(filter);
	}

	public VeiculoBean buscarId(Integer id) {
		return veiculoDAO.buscarVeiculo(id);
	}
}