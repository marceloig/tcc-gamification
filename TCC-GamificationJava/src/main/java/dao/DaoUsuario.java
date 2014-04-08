package dao;

import java.util.HashMap;

import model.Usuario;

public class DaoUsuario {

	private HashMap<String, Usuario> dao = new HashMap<String, Usuario>();

	public void adicionarUsuario(Usuario usuario) {
		dao.put(usuario.getLogin(), usuario);
	}

	public Usuario buscarUsuario(String key) {
		Usuario usuario = dao.get(key);
		return usuario;
	}
}
