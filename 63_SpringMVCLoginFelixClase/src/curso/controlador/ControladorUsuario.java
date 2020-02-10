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
	
	@RequestMapping("inicio")
	public String mostrarLogin() {
		return "login";
	}
	
	@RequestMapping("mostrarAlta") 
	public String irAAlta() {
		return "alta";
	}
	
	@RequestMapping("doAlta") 
	public ModelAndView darAlta(
			ModelAndView mav,
			@RequestParam() String nombre,
			@RequestParam() String pass,
			@RequestParam() String email,
			@RequestParam() String direccion) {
				
			usuario.setNombre(nombre);
			usuario.setEmail(email);
			usuario.setPassword(pass);
			usuario.setDireccion(direccion);
			
			gu.alta(usuario);
			
			mav.setViewName("redirect:inicio");
			// Opcion 1
			mav.getModelMap().addAttribute("mensaje" , "El usuario se ha registrado");
			// Opcion 2 : mav.setViewName("redirect:inicio:inicio?mensaje=El usuario se ha registrado");
			return mav;					
	}
	
	
	@RequestMapping("doLogin") 
	public ModelAndView hacerLogin(
			ModelAndView mav,
			@RequestParam() String nombre,
			@RequestParam() String pass) {
				
			usuario.setNombre(nombre);
			usuario.setPassword(pass);
		
			boolean validado = gu.login(usuario);
			
			if (validado) {
				mav.setViewName("redirect:final");
			} else {
				mav.getModelMap().addAttribute("mensaje" , "El usuario no se ha registrado");
				mav.setViewName("redirect:inicio");
			}

			return mav;					
	}
	
	
	@RequestMapping("final") 
	public String irAFinal() {
		return "index";
	}
}
