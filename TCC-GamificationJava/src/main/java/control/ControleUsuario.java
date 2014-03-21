package control;

import model.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControleUsuario {

	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public @ResponseBody
	Usuario getUsuario() {
		return new Usuario();
	}

}
