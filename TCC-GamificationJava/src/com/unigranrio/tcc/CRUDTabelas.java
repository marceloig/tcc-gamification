package com.unigranrio.tcc;

import com.unigranrio.tcc.dao.NivelDAO;
import com.unigranrio.tcc.dao.UsuarioDAO;
import com.unigranrio.tcc.model.entity.Nivel;
import com.unigranrio.tcc.model.entity.Usuario;

public class CRUDTabelas {
	
	public static void main(String[] args) {
		//inserirNivel();
		inserirUsuario();
		//buscarNivel();
	}

	public static void inserirNivel(){
		Nivel nivel0 = new Nivel();
		nivel0.setNome("Novato");
		nivel0.setPontos(0);
		nivel0.setNomeImagem("novato.png");
		
		Nivel nivel1 = new Nivel();
		nivel1.setNome("Programador");
		nivel1.setPontos(500);
		nivel1.setNomeImagem("programador.png");
		
		Nivel nivel2 = new Nivel();
		nivel2.setNome("Ninja");
		nivel2.setPontos(1000);
		nivel2.setNomeImagem("ninja.png");
		
		Nivel nivel3 = new Nivel();
		nivel3.setNome("Experiente");
		nivel3.setPontos(2000);
		nivel3.setNomeImagem("experiente.png");
		
		Nivel nivel4 = new Nivel();
		nivel4.setNome("Javaman");
		nivel4.setPontos(2500);
		nivel4.setNomeImagem("javaman.png");
		
		NivelDAO nivelDAO = new NivelDAO();
		nivelDAO.gravarNivel(nivel0);
		nivelDAO.gravarNivel(nivel1);
		nivelDAO.gravarNivel(nivel2);
		nivelDAO.gravarNivel(nivel3);
		nivelDAO.gravarNivel(nivel4);
	}
	
	public static void inserirUsuario(){
		NivelDAO nivelDAO = new NivelDAO();
		Nivel nivel = nivelDAO.buscarNivelByNome("Novato");
		
		Usuario usuario = new Usuario();
		usuario.setNome("Igor Marcelo");
		usuario.setLogin("igmarcelo");
		usuario.setSenha("123456");
		usuario.setPontos(0);
		usuario.setNivel(nivel);
		usuario.setAssuntos(null);
		usuario.setBadges(null);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.gravarUsuario(usuario);
	}
	
	public static void buscarNivel(){
		NivelDAO nivelDAO = new NivelDAO();
		Nivel nivel = nivelDAO.buscarNivelByNome("Novato");
		
		System.out.println("Nivel nome: " + nivel.getNome());
	}
}
