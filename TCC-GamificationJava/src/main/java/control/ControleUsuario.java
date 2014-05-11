package control;

import model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.DaoUsuario;


@Controller
public class ControleUsuario {
	
	private DaoUsuario dao = new DaoUsuario();
		
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public @ResponseBody
	Usuario getUsuario() {
		//return new Usuario();
		return dao.buscarUsuarioByLogin();
	}

}
