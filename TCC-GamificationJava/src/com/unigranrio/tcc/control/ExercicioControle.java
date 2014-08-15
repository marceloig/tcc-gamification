package com.unigranrio.tcc.control;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unigranrio.tcc.dao.ExercicioDAO;
import com.unigranrio.tcc.exercicio.Programa;
import com.unigranrio.tcc.model.Alternativa;
import com.unigranrio.tcc.model.ExercicioUmlBean;
import com.unigranrio.tcc.model.ImagemExercicioBean;
import com.unigranrio.tcc.model.RespostaBean;
import com.unigranrio.tcc.model.RespostaExercicioBean;
import com.unigranrio.tcc.model.entity.ExercicioUml;
import com.unigranrio.tcc.model.entity.ImagemExercicio;

@Controller
public class ExercicioControle {

	private Programa programa = new Programa();
	private ExercicioDAO exercicioDAO = new ExercicioDAO();

	@RequestMapping(value = "/java/exercicio/post", method = RequestMethod.POST)
	public @ResponseBody RespostaExercicioBean receberRespostaExercicioJava(
			@RequestBody RespostaBean codigo) {
		System.out.println("Codigo Recebido: " + codigo.getCodigo());

		String respostaConsole = programa.executar(codigo.getCodigo());
		System.out.println("Resposta da Compilação: " + respostaConsole);
		RespostaExercicioBean retorno = new RespostaExercicioBean(
				respostaConsole);
		return retorno;
	}

	@RequestMapping(value = "/uml/exercicio/post", method = RequestMethod.POST)
	public @ResponseBody boolean receberRespostaExercicioUml(
			@RequestBody RespostaBean resposta) {
		
		System.out.println("Chegou!!!");
		ExercicioUml exUml = exercicioDAO.buscarExercicioUmlById(69);
		boolean retorno = resposta.getResposta().equals(exUml.getRespostaUml().getAlternativa());
		System.out.println(retorno);
		return retorno;
	}

	@RequestMapping(value = "/java/exercicio/get", method = RequestMethod.GET)
	public @ResponseBody ExercicioUmlBean getExercicio() {

		ExercicioUmlBean exUmlBean = new ExercicioUmlBean();
		Map<Alternativa, ImagemExercicioBean> alternativas = new HashMap<Alternativa, ImagemExercicioBean>();

		ExercicioUml exUml = exercicioDAO.buscarExercicioUmlById(69);
		exUmlBean.setId(exUml.getId());
		exUmlBean.setNome(exUml.getNome());
		exUmlBean.setDescricao(exUml.getDescricao());
		for (Map.Entry<Alternativa, ImagemExercicio> alternativa : exUml
				.getAlternativas().entrySet()) {
			ImagemExercicioBean imgExercicioBean = new ImagemExercicioBean();
			ImagemExercicio imgExercicio = alternativa.getValue();
			
			imgExercicioBean.setNomeImagem(imgExercicio.getNomeImagem());
			imgExercicioBean.setCaminhoImagem(imgExercicio.getCaminhoImagem());

			alternativas.put(alternativa.getKey(), imgExercicioBean);
		}
		exUmlBean.setAlternativas(alternativas);
		exUmlBean.setRespostaUml(exUml.getRespostaUml());

		return exUmlBean;
	}
}
