package com.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.service.bean.ProdutoBean;

public class ProdutoDAO {
    private Connection conn;
    private PreparedStatement ps;

    public ProdutoDAO() {
        conn = new ConnectionFactory().getConnection();
    }
    
    public List<ProdutoBean> lista() {
		String sql = "SELECT * FROM produto";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<ProdutoBean> produtos = new ArrayList<>();
			while(rs.next()) {
				ProdutoBean veiculo = new ProdutoBean(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getDouble("preco"));
				produtos.add(veiculo);
			}
			rs.close();
			ps.close();
			return produtos;
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + e.getLocalizedMessage());
		}
	}
}