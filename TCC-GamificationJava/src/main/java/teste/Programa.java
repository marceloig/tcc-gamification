package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Programa {
	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.setNome("Igor Marcelo");
		usuario.setLogin("igormarcelo");
		usuario.setSenha("123");
		usuario.setNivel("Aprendiz");
		usuario.setPontos(100);
		
		//gravarUsuarioBanco(usuario);
		
		buscarUsuarioBanco();
		
	}
	
	public static void gravarUsuarioBanco(Usuario usuario){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("usuarios");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();    
		manager.persist(usuario);
		manager.getTransaction().commit();  

		manager.close();
	}
	
	public static void buscarUsuarioBanco(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("usuarios");
		EntityManager manager = factory.createEntityManager();

		Usuario usuarioEncontrado = manager.find(Usuario.class, "igormarcelo");

		System.out.println(usuarioEncontrado.getPontos());
	}

}
