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
	
	@RequestMapping("pepe")
	public String mostrarLogin() {
		return "login";
	}
	
	@RequestMapping("mostrarAlta")
	public String mostrarAlta() {
		return "alta";
	}
	
	@RequestMapping("doAlta")
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
		
		mav.setViewName("redirect:pepe");
		//Al hacer un sendRedirect pedemos el objeto
		//request donde metemos los atributos
		//por lo tanto no podemos utilizar addObject
		//tenemos que pasar por parametro
		//y lo podemos hacer de esta manera
		mav.getModelMap().addAttribute("mensaje","El usuario se ha registrado");
		//opcion 2
		//mav.setViewName("redirect:pepe?mensaje=El usuario se ha registrado");
		return mav;
	}
	
	@RequestMapping("doLogin")
	public ModelAndView hacerLogin(@RequestParam() String nombre
			,@RequestParam() String pass
			,ModelAndView mav) {
		
		usuario.setNombre(nombre);
		usuario.setPassword(pass);
		
		boolean validado = gu.login();
		
		if(validado) {
			mav.setViewName("redirect:inicio");
			mav.getModelMap().addAttribute("nombre",nombre);
		}else {
			mav.setViewName("redirect:pepe");
			mav.getModelMap().addAttribute("error","Usuario y contraseña incorretas");
		}
		return mav;
	}
	
	@RequestMapping("inicio")
	public String mostrarInicio() {
		return "index";
	}
}
