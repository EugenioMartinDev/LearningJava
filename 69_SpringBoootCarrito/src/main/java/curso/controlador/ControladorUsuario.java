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
	
	//este metodo muestra la pagina de login
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	//este metodo hace la accion de logarse, cuando el usuario
	//pulse el boton del formulario
	@RequestMapping("doLogin")
	public String doLogin(@RequestParam String nombre,
			@RequestParam String password) {
		
		this.usuario.setNombre(nombre);
		this.usuario.setPassword(password);
		
		if(gu.validar(usuario)) {
			usuario.setLogado(true);
			return "redirect:inicio";
		}else {
			return "redirect:login";
		}
		
	}
}
