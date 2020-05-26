package br.com.bo;

import br.com.bean.UsuarioBean;
import br.com.dao.UsuarioDAO;

public class UsuarioBO {
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public UsuarioBean insereUsuario(String nome, String email, String senha) {
		if(!usuarioDAO.emailDisponivel(email)) {
			return null;
		}
		
		UsuarioBean usuario = new UsuarioBean(nome, email, senha);
		
		if(usuarioDAO.cadastrar(usuario)) {
			return usuario;
		}
		return null;
	}
	
	public UsuarioBean autenticar(String email, String senha) {
		UsuarioBean usuarioEncontrado = usuarioDAO.autenticar(email, senha);

		if(usuarioEncontrado != null) {
			return usuarioEncontrado;
		}
		
		return null;
	}
	
}
