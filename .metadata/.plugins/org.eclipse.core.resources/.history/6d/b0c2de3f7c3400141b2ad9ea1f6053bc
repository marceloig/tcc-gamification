package com.unigranrio.tcc.control;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

	private ModuloDAO moduloDAO = new ModuloDAO();
	
	@Autowired
    public void setModuloDAO(ModuloDAO moduloDAO) {
      this.moduloDAO = moduloDAO;
    }

	@RequestMapping(value = "/modulos/get", method = RequestMethod.GET)
	public @ResponseBody
	List<ModuloBean> listarModulos() {
		
		List<ModuloBean> modulosBean = new LinkedList<ModuloBean>();
		for (Modulo modulo : moduloDAO.listarModulos()) {
			ModuloBean moduloBean = modulo.getModuloBean();
			moduloBean.setAssuntos(modulo.getAssuntosBean());
			moduloBean.setHistorico(modulo.getProgressosBean());
			
			modulosBean.add(moduloBean);
		}
		
		return modulosBean;
	}

}
