package control;

import model.CodigoBean;
import model.RespostaExercicioBean;
import model.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.UsuarioDAO;


@Controller
public class UsuarioControle {
	
	private UsuarioDAO dao = new UsuarioDAO();
		
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public @ResponseBody
	Usuario getUsuario() {
		//return new Usuario();
		return dao.buscarUsuarioByLogin();
	}
	
	@RequestMapping(value = "/codigo00", method = RequestMethod.POST)
	public @ResponseBody
	RespostaExercicioBean receberRespostaExercicio(@RequestBody CodigoBean codigo){
		System.out.println(codigo.getCodigo());
		RespostaExercicioBean resposta = new RespostaExercicioBean("Passou");
		return resposta;
	}

}
