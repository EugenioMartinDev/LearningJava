package login.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import login.modelo.negocio.GestorLogin;

@Controller
public class ControladorRegistro {


	@Autowired
	private GestorLogin gl;
	
	
	@RequestMapping("registrarse")
	private String pedirRegistro() {		
		return "formularioRegistro";
	}
	
	@RequestMapping("doRegistro")
	private ModelAndView registroLogin(ModelAndView mav,
			@RequestParam(name="usuario", required=false)String usuario,
			@RequestParam(name="password", required=false)String password,
			@RequestParam(name="nombre", required=false)String nombre,
			@RequestParam(name="direccion", required=false)String direccion,
			@RequestParam(name="email", required=false)String email,
			@RequestParam(name="telefono", required=false)String telefono
			) {
				
		gl.getLogin().setId(0);
		gl.getLogin().setUsuario(usuario);
		gl.getLogin().setPassword(password);
		gl.getLogin().setNombre(nombre);
		gl.getLogin().setDireccion(direccion);
		gl.getLogin().setEmail(email);
		gl.getLogin().setTelefono(telefono);
		
		System.out.println();

		
		if (gl.registroValidado(mav)) {
			if (gl.usuarioDuplicado(mav)) {
				mav.setViewName("redirect:registrarse");
			} else {
				if (gl.registrar(mav)) {
					mav.setViewName("redirect:notificarRegistro");
				} else {
					mav.setViewName("redirect:registrarse");
				}			
			} 
		} else {
			mav.setViewName("redirect:registrarse");
		}

		return mav;
	}
	
	@RequestMapping("notificarRegistro")
	private String frontalRegistro() {		
		return "exitoRegistro";
	}
	
	
}

