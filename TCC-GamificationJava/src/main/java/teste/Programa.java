package teste;

import dao.DaoUsuario;
import model.Usuario;

public class Programa {

	private static DaoUsuario dao = new DaoUsuario();

	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.setNome("Igor Marcelo");
		usuario.setLogin("igormarcelo");
		usuario.setSenha("123");
		usuario.setNivel("Aprendiz");
		usuario.setPontos(100);
		
		//dao.gravarUsuario(usuario);

		Usuario usu = dao.buscarUsuarioByLogin();

		System.out.println(usu.getLogin() + "-" + usu.getNome() + "|"
				+ usu.getNivel() + "|" + usu.getPontos());
	}

}
