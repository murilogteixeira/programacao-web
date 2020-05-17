package br.com.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			ps.execute();
			ps.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean atualizaVeiculo(VeiculoBean veiculo) {
		String sql = "UPDATE carro SET marca = ?, modelo = ?, foto = ?, preco = ?, alugado = ?, descricao = ? WHERE id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, veiculo.getMarca());
			ps.setString(2, veiculo.getModelo());
			ps.setString(3, veiculo.getFoto());
			ps.setDouble(4, veiculo.getPreco());
			ps.setBoolean(5, veiculo.getAlugado());
			ps.setString(6, veiculo.getDescricao());
			ps.setInt(7, veiculo.getId());
<<<<<<< HEAD
			ps.execute();
=======
			boolean ok = ps.execute();
>>>>>>> 8c45b2b8b3aedecb592ccc7f9f90279b50988861
			ps.close();
			return true;
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + e.getLocalizedMessage());
		}
	}
	
	public boolean deletarVeiculo(Integer id) {
		String sql = "DELETE FROM carro WHERE id = ?";
		try {
			if(buscarVeiculo(id).getAlugado()) {
				return false;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			boolean ok = ps.execute();
			ps.close();
			return ok;
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + e.getLocalizedMessage());
		}
	}
	
	public ArrayList<VeiculoBean> lista() {
		String sql = "SELECT * FROM carro";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<VeiculoBean> veiculos = new ArrayList<>();
			while(rs.next()) {
				VeiculoBean veiculo = new VeiculoBean(rs.getString("marca"), rs.getString("modelo"), rs.getString("foto"), rs.getDouble("preco"), rs.getString("descricao"), rs.getInt("id"), rs.getBoolean("alugado"));
<<<<<<< HEAD
=======
				veiculos.add(veiculo);
			}
			rs.close();
			ps.close();
			return veiculos;
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + e.getLocalizedMessage());
		}
	}
	
	public ArrayList<VeiculoBean> lista(String filter) {
		String sql = "SELECT * FROM carro WHERE modelo LIKE ? OR marca LIKE ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+filter+"%");
			ps.setString(2, "%"+filter+"%");
			ResultSet rs = ps.executeQuery();
			ArrayList<VeiculoBean> veiculos = new ArrayList<>();
			while(rs.next()) {
				VeiculoBean veiculo = new VeiculoBean(rs.getString("marca"), rs.getString("modelo"), rs.getString("foto"), rs.getDouble("preco"), rs.getString("descricao"), rs.getInt("id"), rs.getBoolean("alugado"));
>>>>>>> 8c45b2b8b3aedecb592ccc7f9f90279b50988861
				veiculos.add(veiculo);
			}
			rs.close();
			ps.close();
			return veiculos;
		} catch (Exception e) {
			throw new RuntimeException("VeiculoDAO Erro: " + e.getLocalizedMessage());
		}
	}

	public VeiculoBean buscarVeiculo(Integer id) {
		String sql = "SELECT * FROM carro WHERE id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			VeiculoBean veiculo = null;
			while(rs.next()) {
				veiculo = new VeiculoBean(rs.getString("marca"), rs.getString("modelo"), rs.getString("foto"), rs.getDouble("preco"), rs.getString("descricao"), rs.getInt("id"), rs.getBoolean("alugado"));
				return veiculo;
			}
			rs.close();
			ps.close();
			return veiculo;
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + e.getLocalizedMessage());
		}
	}
	
	public ArrayList<VeiculoBean> lista(String filter) {
		String sql = "SELECT * FROM carro WHERE modelo LIKE ? OR marca LIKE ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+filter+"%");
			ps.setString(2, "%"+filter+"%");
			ResultSet rs = ps.executeQuery();
			ArrayList<VeiculoBean> veiculos = new ArrayList<>();
			while(rs.next()) {
				VeiculoBean veiculo = new VeiculoBean(rs.getString("marca"), rs.getString("modelo"), rs.getString("foto"), rs.getDouble("preco"), rs.getString("descricao"), rs.getInt("id"), rs.getBoolean("alugado"));
				veiculos.add(veiculo);
			}
			rs.close();
			ps.close();
			return veiculos;
		} catch (Exception e) {
			throw new RuntimeException("VeiculoDAO Erro: " + e.getLocalizedMessage());
		}
	}

	public VeiculoBean buscarVeiculo(Integer id) {
		String sql = "SELECT * FROM carro WHERE id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			VeiculoBean veiculo = null;
			while(rs.next()) {
				veiculo = new VeiculoBean(rs.getString("marca"), rs.getString("modelo"), rs.getString("foto"), rs.getDouble("preco"), rs.getString("descricao"), rs.getInt("id"), rs.getBoolean("alugado"));
				return veiculo;
			}
			rs.close();
			ps.close();
			return veiculo;
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + e.getLocalizedMessage());
		}
	}
}
