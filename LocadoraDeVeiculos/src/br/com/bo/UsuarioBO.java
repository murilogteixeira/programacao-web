package br.com.bo;

import br.com.bean.UsuarioBean;
import br.com.bean.VeiculoBean;
import br.com.dao.UsuarioDAO;

public class UsuarioBO {
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public UsuarioBean insereUsuario(String nome, String email, String senha) {
		UsuarioBean usuario = new UsuarioBean(nome, email, senha, UsuarioDAO.getProxId());
		
		if(usuarioDAO.cadastrar(usuario)) {
			return usuario;
		}
		
		return null;
	}
}
