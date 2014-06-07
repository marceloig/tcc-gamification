package com.unigranrio.tcc.control;

import javassist.CannotCompileException;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unigranrio.tcc.dao.UsuarioDAO;
import com.unigranrio.tcc.model.CodigoBean;
import com.unigranrio.tcc.model.RespostaExercicioBean;
import com.unigranrio.tcc.model.Usuario;
import com.unigranrio.tcc.teste.Programa;


@Controller
public class UsuarioControle {
	
	private UsuarioDAO dao = new UsuarioDAO();
	private Programa programa = new Programa();
		
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public @ResponseBody
	Usuario getUsuario() {
		//return new Usuario();
		return dao.buscarUsuarioByLogin();
	}
	
	@RequestMapping(value = "/codigo00", method = RequestMethod.POST)
	public @ResponseBody
	RespostaExercicioBean receberRespostaExercicio(@RequestBody CodigoBean codigo){
		System.out.println("Codigo Recebido: " + codigo.getCodigo());
		
		String respostaConsole = programa.executar(codigo.getCodigo());
		System.out.println("Resposta: " + respostaConsole);
		RespostaExercicioBean resposta = new RespostaExercicioBean(respostaConsole);
		return resposta;
	}

}
