package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.bean.UsuarioBean;

public class UsuarioDAO {

	Connection conn;
	PreparedStatement ps;
	
	public UsuarioDAO() {
		conn = new ConnectionFactory().getConnection();
	}
	
	public boolean cadastrar(UsuarioBean usuario) {
		String sql = "INSERT INTO usuario (nome, email, senha) values (?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());
			boolean ok = ps.execute();
			ps.close();
			return ok;
		} catch (Exception e) {
			return false;
		}
	}

	public UsuarioBean autenticar(String email, String senha) {
		String sql = "SELECT id, nome, email FROM usuario WHERE email = ? AND senha = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, senha);
			ResultSet rs = ps.executeQuery();
			UsuarioBean usuario;
			while(rs.next()) {
				usuario = new UsuarioBean(rs.getString("nome"), rs.getString("email"), null, rs.getInt("id"));
				ps.close();
				return usuario;
			}
			ps.close();
			return null;
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + e.getLocalizedMessage());
		}
	}

	public boolean emailDisponivel(String email) {
		String sql = "SELECT email FROM usuario WHERE email = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			Integer count = 0;
			while(rs.next()) {
				count++;
			}
			ps.close();
			if(count > 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + e.getLocalizedMessage());
		}
	}
	
	public boolean remover(UsuarioBean usuario) {
		String sql = "DELETE FROM usuario WHERE id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, usuario.getId());
			boolean ok = ps.execute();
			ps.close();
			return ok;
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + e.getLocalizedMessage());
		}
	}
	
	public void atualizar(UsuarioBean usuario) {
		// int id = usuario.getId();
		// lista.remove(id);
		// lista.add(id, usuario);
	}
}
