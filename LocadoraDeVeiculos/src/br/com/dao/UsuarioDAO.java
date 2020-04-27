package br.com.dao;

import java.util.ArrayList;

import br.com.bean.UsuarioBean;

public class UsuarioDAO {
	private static ArrayList<UsuarioBean> lista = null;
	
	public UsuarioDAO() {
		if(lista == null) {
			lista = new ArrayList<UsuarioBean>();
			UsuarioBean user = new UsuarioBean("admin", "admin@admin.com", "admin", getProxId());
			lista.add(user);
		}
	}
	
	public boolean cadastrar(UsuarioBean usuario) {
		return lista.add(usuario);
	}
	
	public boolean remover(UsuarioBean usuario) {
		return lista.remove(usuario);
	}
	
	public void atualizar(UsuarioBean usuario) {
		int id = usuario.getId();
		lista.remove(id);
		lista.add(id, usuario);
	}
	
	public ArrayList<UsuarioBean> lista() {
		return lista;
	}
	
	static public Integer getProxId() {
		return lista.size();
	}
}
