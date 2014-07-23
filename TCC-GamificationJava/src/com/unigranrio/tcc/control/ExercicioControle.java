package com.unigranrio.tcc.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unigranrio.tcc.exercicio.Programa;
import com.unigranrio.tcc.model.CodigoBean;
import com.unigranrio.tcc.model.RespostaExercicioBean;

@Controller
public class ExercicioControle {
	
	private Programa programa = new Programa();
	
	@RequestMapping(value = "/exercicio/java/exercicio0", method = RequestMethod.POST)
	public @ResponseBody
	RespostaExercicioBean receberRespostaExercicio(
			@RequestBody CodigoBean codigo) {
		System.out.println("Codigo Recebido: " + codigo.getCodigo());

		String respostaConsole = programa.executar(codigo.getCodigo());
		System.out.println("Resposta da Compilação: " + respostaConsole);
		RespostaExercicioBean retorno = new RespostaExercicioBean(
				respostaConsole);
		return retorno;
	}
}
