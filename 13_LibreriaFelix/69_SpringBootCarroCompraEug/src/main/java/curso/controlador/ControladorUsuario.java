package curso.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.modelo.entidad.Usuario;
import curso.modelo.negocio.GestorUsuario;


@Controller
public class ControladorUsuario {

	@Autowired
	private Usuario usuario;
	
	@Autowired
	private GestorUsuario gu;
	
	@RequestMapping("login")
	public String mostrarLogin() {
		return "login";
	}
	
	@RequestMapping("mostrarAlta")
	public String mostrarAlta() {
		return "altaUsuario";
	}
	
	@RequestMapping("doAltaUsuario")
	public ModelAndView hacerAlta(@RequestParam() String nombre
			,@RequestParam() String pass
			,@RequestParam() String email
			,@RequestParam() String direccion
			,ModelAndView mav) {
		
		usuario.setNombre(nombre);
		usuario.setDireccion(direccion);
		usuario.setEmail(email);
		usuario.setPassword(pass);
		
		gu.alta();
		
		mav.setViewName("redirect:login");
		mav.getModelMap().addAttribute("mensaje","El usuario se ha registrado");
		return mav;
	}
	
	@RequestMapping("doLogin")
	public ModelAndView hacerLogin(
			@RequestParam() String nombre
			,@RequestParam() String pass
			,ModelAndView mav) {
		
		usuario.setNombre(nombre);
		usuario.setPassword(pass);
		
		boolean validado = gu.login();
		
		if(validado) {
			mav.setViewName("redirect:seleccionProductos");
			mav.getModelMap().addAttribute("nombre",nombre);
		}else {
			mav.setViewName("redirect:login");
			mav.getModelMap().addAttribute("error","Usuario y contraseniaa incorretas");
		}
		return mav;
	}
	
	@RequestMapping("inicio")
	public ModelAndView mostrarInicio(
			ModelAndView mav) {
		
		if (usuario.isRegistrado()) {
			mav.getModelMap().addAttribute("nombre", usuario.getNombre());
			mav.setViewName("index");
		} else {
			mav.getModelMap().addAttribute("error", "El usuario no esta registrado");
			mav.setViewName("redirect:login");
		}
		return mav;
	}
}
