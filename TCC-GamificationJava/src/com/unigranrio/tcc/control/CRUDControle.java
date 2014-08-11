package com.unigranrio.tcc.control;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.unigranrio.tcc.dao.AssuntoDAO;
import com.unigranrio.tcc.dao.ModuloDAO;
import com.unigranrio.tcc.dao.NivelDAO;
import com.unigranrio.tcc.dao.UsuarioDAO;
import com.unigranrio.tcc.model.entity.Assunto;
import com.unigranrio.tcc.model.entity.Modulo;

@Transactional
@Controller
public class CRUDControle {

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
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void receberRespostaExercicio() {
		buscarModulo();
	}
	
	public void buscarModulo(){
		Modulo modulo0 = moduloDAO.buscarModuloByNome("Conceitos de Orientação a Objeto com Java");
		for (Assunto assunto : modulo0.getAssuntos()) {
			System.out.println("ID: " + assunto.getId());
			System.out.println("Nome: " + assunto.getNome());
		}
	}
}
