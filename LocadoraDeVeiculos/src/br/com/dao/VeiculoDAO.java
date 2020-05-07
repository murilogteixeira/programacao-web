package br.com.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.bean.VeiculoBean;

public class VeiculoDAO {
	// private static ArrayList<VeiculoBean> lista = null;
	private Connection conn;
	private PreparedStatement ps;
	
	public VeiculoDAO() {
		conn = new ConnectionFactory().getConnection();
	}
	
	public boolean insereVeiculo(VeiculoBean veiculo) {
		String sql = "INSERT INTO carro (modelo, marca, foto, preco, alugado, descricao) values (?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, veiculo.getModelo());
			ps.setString(2, veiculo.getMarca());
			ps.setString(3, veiculo.getFoto());
			ps.setDouble(4, veiculo.getPreco());
			ps.setBoolean(5, veiculo.getAlugado());
			ps.setString(6, veiculo.getDescricao());
			boolean ok = ps.execute();
			ps.close();
			return ok;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean atualizaAlugado(Integer id, boolean alugado) {
		String sql = "UPDATE carro SET alugado = ? WHERE id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setBoolean(1, alugado);
			ps.setInt(2, id);
			boolean ok = ps.execute();
			ps.close();
			return ok;
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + e.getLocalizedMessage());
		}
	}
	
	public boolean removeVeiculo(VeiculoBean veiculo) {
		// return lista.remove(veiculo);
		return false;
	}
	
	public ArrayList<VeiculoBean> lista() {
		String sql = "SELECT * FROM carro";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<VeiculoBean> veiculos = new ArrayList<>();
			while(rs.next()) {
				VeiculoBean veiculo = new VeiculoBean(rs.getString("marca"), rs.getString("modelo"), rs.getString("foto"), rs.getDouble("preco"), rs.getString("descricao"), rs.getInt("id"));
				veiculos.add(veiculo);
			}
			rs.close();
			ps.close();
			return veiculos;
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + e.getLocalizedMessage());
		}
	}
}
