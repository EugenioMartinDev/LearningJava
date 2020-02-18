package curso.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.modelo.entidad.Usuario;

@Controller
public class ControladorUsuario {

	//Si se salva el objeto usuario en la bbdd habrá un problema
	//porque este objeto se crea como proxy en spring al estar dentro de un controlador singleton
	//y usuario es scope sesion y no existe cuando el controlador ya ha sido creado.
	
	@Autowired
	private Usuario usuario;
	
	@RequestMapping("doLogin")
	private ModelAndView login(
			@RequestParam() String usuario,
			@RequestParam() String pass,
			ModelAndView mav) {		
		if (usuario.equals("felix") && pass.contentEquals("1234")) {		
			this.usuario.setNombre(usuario);
			this.usuario.setRegistrado(true);
			mav.setViewName("redirect:inicio");
		} else {
			mav.setViewName("redirect:login");
		}		
		return mav;
	}
	
	@RequestMapping("login")
	private String login() {
		return "login";
	}

	@RequestMapping("inicio")
	private String inicio(Model model)	{
		if (usuario.isRegistrado()) {
			model.addAttribute("usuario", usuario);
			return "inicio";
		} else {
			System.out.println("Usuario no registrado");
			model.addAttribute("mensaje", "usuario no registrado");
			return "login";
		}
	}
	
}
