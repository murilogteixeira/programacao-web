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

<<<<<<< HEAD
	public boolean atualizarVeiculo(VeiculoBean veiculo) {
		VeiculoBean v = veiculoDAO.buscarVeiculo(veiculo.getId());
		veiculo.setAlugado(v.getAlugado());
		return veiculoDAO.atualizaVeiculo(veiculo);
	}

	public boolean deletarVeiculo(Integer id) {
		return veiculoDAO.deletarVeiculo(id);
	}

	public boolean alugarVeiculo(Integer id, boolean alugado) {
		VeiculoBean veiculo = veiculoDAO.buscarVeiculo(id);
		veiculo.setAlugado(alugado);
		return veiculoDAO.atualizaVeiculo(veiculo);
=======
	public void atualizarVeiculo(VeiculoBean veiculo) {
		veiculoDAO.atualizaVeiculo(veiculo);
	}

	public void alugarVeiculo(Integer id, boolean alugado) {
		VeiculoBean veiculo = veiculoDAO.buscarVeiculo(id);
		veiculo.setAlugado(alugado);
		veiculoDAO.atualizaVeiculo(veiculo);
>>>>>>> 8c45b2b8b3aedecb592ccc7f9f90279b50988861
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