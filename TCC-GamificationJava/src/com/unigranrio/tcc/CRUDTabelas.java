package com.unigranrio.tcc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.unigranrio.tcc.dao.AssuntoDAO;
import com.unigranrio.tcc.dao.ModuloDAO;
import com.unigranrio.tcc.dao.NivelDAO;
import com.unigranrio.tcc.dao.UsuarioDAO;
import com.unigranrio.tcc.model.entity.Assunto;
import com.unigranrio.tcc.model.entity.Modulo;
import com.unigranrio.tcc.model.entity.Nivel;
import com.unigranrio.tcc.model.entity.Usuario;

@Transactional
public class CRUDTabelas {

	private UsuarioDAO usuarioDAO;
	private NivelDAO nivelDAO;
	private AssuntoDAO assuntoDAO;
	private ModuloDAO moduloDAO;
	
	
	@Autowired
	public void setDAOs(UsuarioDAO usuarioDAO, NivelDAO nivelDAO, AssuntoDAO assuntoDAO, ModuloDAO moduloDAO) {
		this.usuarioDAO = usuarioDAO;
		this.nivelDAO = nivelDAO;
		this.assuntoDAO = assuntoDAO;
		this.moduloDAO = moduloDAO;
	}

	public void inserirNivel() {
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

	public void inserirUsuario() {
		NivelDAO nivelDAO = new NivelDAO();
		Nivel nivel = nivelDAO.buscarNivelByNome("Novato");

		Usuario usuario = new Usuario();
		usuario.setNome("Igor Marcelo");
		usuario.setLogin("igmarcelo");
		usuario.setSenha("123456");
		usuario.setPontos(0);
		usuario.setNivel(nivel);
		usuario.setBadges(null);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.gravarUsuario(usuario);
	}

	public void buscarNivel() {
		NivelDAO nivelDAO = new NivelDAO();
		Nivel nivel = nivelDAO.buscarNivelByNome("Novato");

		System.out.println("Nivel nome: " + nivel.getNome());
	}

	public void inserirModulo() {
		Modulo modulo0 = new Modulo();
		modulo0.setNome("Conhecendo Java");
		
		Modulo modulo1 = new Modulo();
		modulo1.setNome("Aprofundando em Java");
		
		Modulo modulo2 = new Modulo();
		modulo2.setNome("UML");
		
		Modulo modulo3 = new Modulo();
		modulo3.setNome("Conceitos de Orienta��o a Objeto com Java");

		ModuloDAO moduloDAO = new ModuloDAO();
		moduloDAO.gravarModulo(modulo0);
		moduloDAO.gravarModulo(modulo1);
		moduloDAO.gravarModulo(modulo2);
		moduloDAO.gravarModulo(modulo3);

	}

	public void buscarModulo() {
		ModuloDAO moduloDAO = new ModuloDAO();
		Modulo modulo0 = moduloDAO.buscarModuloByNome("Conceitos de Orienta��o a Objeto com Java");
		for (Assunto assunto : modulo0.getAssuntos()) {
			System.out.println("ID: " + assunto.getId());
			System.out.println("Nome: " + assunto.getNome());
		}
	}

	public void listarModulos(){
		ModuloDAO moduloDAO = new ModuloDAO();
		List<Modulo> modulo0 = moduloDAO.listarModulos();
		for (Modulo modulo : modulo0) {
			System.out.println("Modulo ID: " + modulo.getId());
			System.out.println("Modulo Nome: " + modulo.getNome());
			for(Assunto assunto : modulo.getAssuntos()){
				System.out.println("Assunto ID: " + assunto.getId());
				System.out.println("Assunto Nome: " + assunto.getNome());
			}
		}
	}
	
	public void alterarModulo() {
		ModuloDAO moduloDAO = new ModuloDAO();
		AssuntoDAO assuntoDAO = new AssuntoDAO();
		
		Modulo modulo0 = moduloDAO.buscarModuloByNome("Conceitos de Orienta��o a Objeto com Java");
		List<Assunto> assuntos = assuntoDAO.listarAssuntosByModulo(modulo0);
		
		modulo0.setAssuntos(assuntos);

		moduloDAO.alterarModulo(modulo0);
	}

	public void inserirAssunto() {
		ModuloDAO moduloDAO = new ModuloDAO();
		AssuntoDAO assuntoDAO = new AssuntoDAO();

		Modulo modulo0 = moduloDAO.buscarModuloByNome("Conceitos de Orienta��o a Objeto com Java");

		Assunto assunto0 = new Assunto();
		assunto0.setNome("Encapsulamento");
		assunto0.setModulo(modulo0);
		
		Assunto assunto1 = new Assunto();
		assunto1.setNome("Relacionamento: Associa��o/Composi��o/Agrega��o");
		assunto1.setModulo(modulo0);
		
		Assunto assunto2 = new Assunto();
		assunto2.setNome("Relacionamento: Heran�a");
		assunto2.setModulo(modulo0);
		
		Assunto assunto3 = new Assunto();
		assunto3.setNome("Polimorfismo");
		assunto3.setModulo(modulo0);
		
		

		assuntoDAO.gravarAssunto(assunto0);	
		assuntoDAO.gravarAssunto(assunto1);
		assuntoDAO.gravarAssunto(assunto2);
		assuntoDAO.gravarAssunto(assunto3);
		
	};

	public void listarAlunos(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> usuarios = usuarioDAO.listarUsuarios();
		for(Usuario usuario : usuarios){
			System.out.println("Login: " + usuario.getLogin());
			System.out.println("Nome: " + usuario.getNome());
		}
	}
}
