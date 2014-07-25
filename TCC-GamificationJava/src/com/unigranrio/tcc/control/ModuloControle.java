package com.unigranrio.tcc.control;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unigranrio.tcc.dao.ModuloDAO;
import com.unigranrio.tcc.model.AssuntoBean;
import com.unigranrio.tcc.model.ModuloBean;
import com.unigranrio.tcc.model.entity.Assunto;
import com.unigranrio.tcc.model.entity.Modulo;

@Transactional
@Controller
public class ModuloControle {

	private ModuloDAO moduloDAO;

	@Autowired
	public void setModuloDAO(ModuloDAO moduloDAO) {
		this.moduloDAO = moduloDAO;
	}

	@RequestMapping(value = "/modulos/get", method = RequestMethod.GET)
	public @ResponseBody
	List<ModuloBean> listarModulos() {
		List<ModuloBean> modulosBean = new LinkedList<ModuloBean>();

		for (Modulo modulo : moduloDAO.listarModulos()) {
			ModuloBean moduloBean = new ModuloBean();
			List<AssuntoBean> assuntosBean = new ArrayList<AssuntoBean>();

			moduloBean.setId(modulo.getId());
			moduloBean.setNome(modulo.getNome());
			for (Assunto assunto : modulo.getAssuntos()) {
				AssuntoBean assuntoBean = new AssuntoBean();
				assuntoBean.setId(assunto.getId());
				assuntoBean.setNome(assunto.getNome());
				assuntosBean.add(assuntoBean);
			}
			moduloBean.setAssuntos(assuntosBean);
			modulosBean.add(moduloBean);
		}
		return modulosBean;
	}

}
