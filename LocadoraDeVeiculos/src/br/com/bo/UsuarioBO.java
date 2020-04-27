package br.com.bo;

import br.com.bean.UsuarioBean;
import br.com.dao.UsuarioDAO;

public class UsuarioBO {
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public UsuarioBean insereUsuario(String nome, String email, String senha) {
		if(!verificaEmailDisponivel(email)) {
			return null;
		}
		
		UsuarioBean usuario = new UsuarioBean(nome, email, senha, UsuarioDAO.getProxId());
		
		if(usuarioDAO.cadastrar(usuario)) {
			return usuario;
		}
		
		return null;
	}
	
	private boolean verificaEmailDisponivel(String email) {
		
		for(UsuarioBean usuario : usuarioDAO.lista()) {
			if(usuario.getEmail().equals(email)) {
				return false;
			}
		}
		
		return true;
	}
	
	public UsuarioBean autenticar(String email, String senha) {
		UsuarioBean usuarioEncontrado = encontrarUsuario(email);
		
		if(usuarioEncontrado != null) {
			boolean senhaValidada = validarSenha(usuarioEncontrado.getSenha(), senha);
			if(senhaValidada) {
				
				return usuarioEncontrado;
			}
		}
		
		return null;
	}
	
	private UsuarioBean encontrarUsuario(String email) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		for(UsuarioBean usuario : usuarioDAO.lista()) {
			if(usuario.getEmail().equals(email)) {
				return usuario;
			}
		}
		return null;
	}
	
	private boolean validarSenha(String senhaUsuario, String senhaDigitada) {
		if(senhaUsuario.equals(senhaDigitada)) {
			return true;
		}
		
		return false;
	}
}
