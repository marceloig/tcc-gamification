package com.unigranrio.tcc.control;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.unigranrio.tcc.dao.AssuntoDAO;
import com.unigranrio.tcc.dao.ExercicioDAO;
import com.unigranrio.tcc.dao.ModuloDAO;
import com.unigranrio.tcc.dao.NivelDAO;
import com.unigranrio.tcc.dao.UsuarioDAO;
import com.unigranrio.tcc.model.Alternativa;
import com.unigranrio.tcc.model.entity.Assunto;
import com.unigranrio.tcc.model.entity.ExercicioUml;
import com.unigranrio.tcc.model.entity.ImagemExercicio;
import com.unigranrio.tcc.model.entity.Modulo;

@Transactional
@Controller
public class CRUDControle {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private NivelDAO nivelDAO = new NivelDAO();
	private AssuntoDAO assuntoDAO = new AssuntoDAO();
	private ModuloDAO moduloDAO = new ModuloDAO();
	private ExercicioDAO exercicioDAO = new ExercicioDAO();
	
	@Autowired
    public void setDAOs(UsuarioDAO usuarioDAO, NivelDAO nivelDAO, AssuntoDAO assuntoDAO, ModuloDAO moduloDAO, ExercicioDAO exercicioDAO) {
      this.usuarioDAO = usuarioDAO;
      this.nivelDAO = nivelDAO;
      this.assuntoDAO = assuntoDAO;
      this.moduloDAO = moduloDAO;
      this.exercicioDAO = exercicioDAO;
    }

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void receberRespostaExercicio() {
		//buscarModulo();
		//cadastrarExercicio();
	}

	public void buscarModulo() {
		Modulo modulo0 = moduloDAO
				.buscarModuloByNome("Conceitos de Orientação a Objeto com Java");
		for (Assunto assunto : modulo0.getAssuntos()) {
			System.out.println("ID: " + assunto.getId());
			System.out.println("Nome: " + assunto.getNome());
		}
	}

	public void cadastrarExercicio(){
		ImagemExercicio imExA = new ImagemExercicio();
		imExA.setId((long) 1);
		imExA.setNomeImagem("alternativaA");
		imExA.setCaminhoImagem("imagens/exercicios/uml/diagrama_de_caso_de_uso/exercicio1");
		
		ImagemExercicio imExB = new ImagemExercicio();
		imExB.setId((long) 2);
		imExB.setNomeImagem("alternativaB");
		imExB.setCaminhoImagem("imagens/exercicios/uml/diagrama_de_caso_de_uso/exercicio1");
		
		ImagemExercicio imExC = new ImagemExercicio();
		imExC.setId((long) 3);
		imExC.setNomeImagem("alternativaC");
		imExC.setCaminhoImagem("imagens/exercicios/uml/diagrama_de_caso_de_uso/exercicio1");
		
		ImagemExercicio imExD = new ImagemExercicio();
		imExD.setId((long) 4);
		imExD.setNomeImagem("alternativaD");
		imExD.setCaminhoImagem("imagens/exercicios/uml/diagrama_de_caso_de_uso/exercicio1");
		
		exercicioDAO.gravarImagemExercicio(imExA);
		exercicioDAO.gravarImagemExercicio(imExB);
		exercicioDAO.gravarImagemExercicio(imExC);
		exercicioDAO.gravarImagemExercicio(imExD);
		
		HashMap<Alternativa,ImagemExercicio> alternativas = new HashMap<Alternativa,ImagemExercicio>();
		alternativas.put(Alternativa.A, imExA);
		alternativas.put(Alternativa.B, imExB);
		alternativas.put(Alternativa.C, imExC);
		alternativas.put(Alternativa.D, imExD);
		
		ExercicioUml exUml = new ExercicioUml();
		exUml.setNome("Exercicio 1");
		exUml.setDescricao("Qual desses desenhos representa corretamente um ator do sistema.");
		exUml.setAssunto(assuntoDAO.buscarAssuntoByNome("Diagrama de Casos de Uso"));
		exUml.setAlternativas(alternativas);
		exUml.setRespostaUml(Alternativa.B);
		
		exercicioDAO.gravarExercicioUml(exUml);
	
		
	}
}
