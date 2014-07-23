package com.unigranrio.tcc.control;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unigranrio.tcc.dao.NivelDAO;
import com.unigranrio.tcc.dao.UsuarioDAO;
import com.unigranrio.tcc.model.NivelBean;
import com.unigranrio.tcc.model.UsuarioBean;
import com.unigranrio.tcc.model.entity.Nivel;
import com.unigranrio.tcc.model.entity.Usuario;

@Transactional
@Controller
public class UsuarioControle {

	private UsuarioDAO usuarioDAO;
	private NivelDAO nivelDAO;
	
	private UsuarioBean usuarioBean = new UsuarioBean();
	private NivelBean nivelBean = new NivelBean();
	
	private Usuario usuario = new Usuario();

	@Autowired
	public void setUsuarioDAOENivelDAO(UsuarioDAO usuarioDAO, NivelDAO nivelDAO) {
		this.usuarioDAO = usuarioDAO;
		this.nivelDAO = nivelDAO;
	}
	
	@RequestMapping(value = "/usuario/login", method = RequestMethod.POST)
	public @ResponseBody
	String logarUsuario(HttpSession session,
			@RequestBody UsuarioBean usuarioBean) {
		System.out.println("Chegou!!!");
		String mensagem = "";
		usuario = usuarioDAO.buscarUsuarioByLogin(usuarioBean.getLogin());

		if (usuario != null) {

			if (usuario.getSenha().equals(usuarioBean.getSenha())) {
				mensagem = "Usuario logado";
				return "ok";
			} else {
				mensagem = "Senha incorreta";
			}

		} else {
			mensagem = "Usuario não existe";
		}

		return mensagem;
	}

	@RequestMapping(value = "/usuario/get", method = RequestMethod.GET)
	public @ResponseBody
	UsuarioBean getUsuario() {
		
		Usuario usuario = usuarioDAO.buscarUsuarioByLogin("igmarcelo");
			
		nivelBean.setNome(usuario.getNivel().getNome());
		nivelBean.setPontos(usuario.getNivel().getPontos());
		
		usuarioBean.setLogin(usuario.getLogin());
		usuarioBean.setNome(usuario.getNome());	
		usuarioBean.setNivel(nivelBean);
		
		System.out.println("Nome: " + usuario.getNome());
		return usuarioBean;
	}

	@RequestMapping(value = "/usuario/post", method = RequestMethod.POST)
	public @ResponseBody
	boolean CadastrarUsuario(@RequestBody UsuarioBean usuarioBean) {
		System.out.println("Chegou!!!");
		boolean mensagem;

		if (usuarioDAO.buscarUsuarioByLogin(usuarioBean.getLogin()) == null) {
			Nivel nivel = nivelDAO.buscarNivelByNome("Novato");
			usuario.setNome(usuarioBean.getNome());
			usuario.setLogin(usuarioBean.getLogin());
			usuario.setSenha(usuarioBean.getSenha());
			usuario.setNivel(nivel);
			usuarioDAO.gravarUsuario(usuario);
			mensagem = true;
		} else {
			mensagem = false;
		}

		return mensagem;
	}

}
