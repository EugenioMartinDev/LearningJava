package curso.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.modelo.entidad.Usuario;
import curso.modelo.negocio.GestorUsuario;

@Controller
public class ControladorUsuario {

	@Autowired
	private Usuario usuario;
	
	@Autowired
	private GestorUsuario gu;
	
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("doLogin")
	public String doLogin(
		@RequestParam() String nombre,
		@RequestParam() String password) {
		
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		
		if (gu.validarUsuario(usuario)) {
			usuario.setLogado(true);
			return ("redirect:inicio");
		} else {
			return ("redirect:login");
		}
	}
}
