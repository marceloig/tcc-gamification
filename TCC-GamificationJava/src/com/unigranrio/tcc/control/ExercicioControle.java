package com.unigranrio.tcc.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unigranrio.tcc.dao.ExercicioDAO;
import com.unigranrio.tcc.dao.UsuarioDAO;
import com.unigranrio.tcc.exercicio.Programa;
import com.unigranrio.tcc.model.ExercicioJavaBean;
import com.unigranrio.tcc.model.ExercicioUmlBean;
import com.unigranrio.tcc.model.RespostaBean;
import com.unigranrio.tcc.model.UsuarioBean;
import com.unigranrio.tcc.model.entity.ExercicioJava;
import com.unigranrio.tcc.model.entity.ExercicioUml;
import com.unigranrio.tcc.model.entity.Usuario;

@Transactional
@Controller
public class ExercicioControle {

	private Programa programa = new Programa();
	private ExercicioDAO exercicioDAO = new ExercicioDAO();
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private RespostaBean retornoJava = new RespostaBean();
	
	@Autowired
    public void seExercicioDAOeUsuarioDAO(ExercicioDAO exercicioDAO, UsuarioDAO usuarioDAO) {
      this.exercicioDAO = exercicioDAO;
      this.usuarioDAO = usuarioDAO;
    }
	
	@RequestMapping(value = "/java/exercicio/get", method = RequestMethod.GET)
	public @ResponseBody
	ExercicioJavaBean getExercicioJava() {
		ExercicioJava exJava = exercicioDAO.buscarExercicioJavaById(58);
		ExercicioJavaBean exJavaBean = exJava.getExercicioJavaBean();
		
		return exJavaBean;
	}
	
	@RequestMapping(value = "/java/exercicio/post", method = RequestMethod.POST)
	public @ResponseBody
	RespostaBean receberRespostaExercicioJava(
			@RequestBody RespostaBean codigo) {
		System.out.println("Codigo Recebido: " + codigo.getCodigo());

		String respostaConsole = programa.executar(codigo.getCodigo());
		System.out.println("Resposta da Compilação: " + respostaConsole);

		retornoJava.setResposta(respostaConsole);
		return retornoJava;
	}

	@RequestMapping(value = "/uml/exercicio/get", method = RequestMethod.GET)
	public @ResponseBody
	ExercicioUmlBean getExercicioUml() {

		ExercicioUml exUml = exercicioDAO.buscarExercicioUmlById(57);
		ExercicioUmlBean exUmlBean = exUml.getExercicioUmlBean();
		exUmlBean.setAlternativas(exUml.getAlternativasBean());
		
		return exUmlBean;
	}
	
	@RequestMapping(value = "/usuario/pontos/put", method = RequestMethod.POST)
	public @ResponseBody
	RespostaBean receberPontuacaoUsuario(@RequestBody UsuarioBean pontuacao) {
		
		Usuario usuario = usuarioDAO.buscarUsuarioByLogin(pontuacao.getLogin());
		usuario.setPontos(usuario.getPontos() + pontuacao.getPontos());
		//usuario.setLogin(pontuacao.getLogin());
		usuarioDAO.atualizarUsuario(usuario);
		
		return null;
	}
}
