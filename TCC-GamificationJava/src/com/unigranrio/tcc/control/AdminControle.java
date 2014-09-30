package com.unigranrio.tcc.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.unigranrio.tcc.dao.AssuntoDAO;
import com.unigranrio.tcc.dao.ExercicioDAO;
import com.unigranrio.tcc.dao.ModuloDAO;
import com.unigranrio.tcc.dao.NivelDAO;
import com.unigranrio.tcc.dao.UsuarioDAO;
import com.unigranrio.tcc.model.entity.Assunto;
import com.unigranrio.tcc.model.entity.Modulo;

@Transactional
@Controller
public class AdminControle {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private NivelDAO nivelDAO = new NivelDAO();
	private AssuntoDAO assuntoDAO = new AssuntoDAO();
	private ModuloDAO moduloDAO = new ModuloDAO();
	private ExercicioDAO exercicioDAO = new ExercicioDAO();

	@Autowired
	public void setDAOs(UsuarioDAO usuarioDAO, NivelDAO nivelDAO,
			AssuntoDAO assuntoDAO, ModuloDAO moduloDAO,
			ExercicioDAO exercicioDAO) {
		this.usuarioDAO = usuarioDAO;
		this.nivelDAO = nivelDAO;
		this.assuntoDAO = assuntoDAO;
		this.moduloDAO = moduloDAO;
		this.exercicioDAO = exercicioDAO;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "modulos", method = RequestMethod.GET)
	public String homeModulo() {
		return "modulo/home";
	}
	
	@RequestMapping("assuntos")
	public String homeAssunto(Model model) {
		List<Modulo> modulos = moduloDAO.listarModulos();
		model.addAttribute("modulos", modulos);
		
		return "assunto/home";
	}
	
	@RequestMapping(value = "exercicios", method = RequestMethod.GET)
	public String homeExercicio() {
		return "exercicio/home";
	}
	
	@RequestMapping(value = "salvarModulo", method = RequestMethod.POST)
	public String salvarModulo(Modulo modulo) {
		moduloDAO.gravarModulo(modulo);
		
		return "modulo/home";
	}
	
	@RequestMapping(value = "salvarAssunto", method = RequestMethod.POST)
	public String salvarAssunto(Assunto assunto) {
		
		Modulo modulo = moduloDAO.buscarModuloById(assunto.getModulo().getId());
		assunto.setModulo(modulo);
		assuntoDAO.gravarAssunto(assunto);
		
		modulo.setAssuntos(assuntoDAO.listarAssuntosByModulo(modulo));
		moduloDAO.alterarModulo(modulo);
		
		return "forward:assunto";
	}

}
