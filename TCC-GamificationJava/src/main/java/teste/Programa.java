package teste;

import control.UsuarioControle;
import dao.UsuarioDAO;
import model.CodigoBean;
import model.Usuario;

public class Programa {

	private static UsuarioDAO dao = new UsuarioDAO();

	public static void main(String[] args) {
		//Usuario usuario = new Usuario();
		//usuario.setNome("Igor Marcelo");
		//usuario.setLogin("igormarcelo");
		//usuario.setSenha("123");
		//usuario.setNivel("Aprendiz");
		//usuario.setPontos(100);
		
		//dao.gravarUsuario(usuario);

		//Usuario usu = dao.buscarUsuarioByLogin();

		//System.out.println(usu.getLogin() + "-" + usu.getNome() + "|"
		//		+ usu.getNivel() + "|" + usu.getPontos());
		CodigoBean codigo = new CodigoBean();
		UsuarioControle usuarioControle = new UsuarioControle();
		//codigo = usuarioControle.receberCodigo();
		System.out.println(codigo.getCodigo());
		
	}

}
