package login.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import login.modelo.negocio.GestorLogin;

@Controller
public class ControladorLogin {

	@Autowired
	private GestorLogin gl;
	
	@RequestMapping("login")
	private String login() {
		return "formularioAcceso";
	}
	
	@RequestMapping("doLogin")
	private ModelAndView accesoLogin(ModelAndView mav,
			@RequestParam(name="usuario", required=false)String usuario,
			@RequestParam(name="password", required=false)String password) {
				
		gl.getLogin().setUsuario(usuario);
		gl.getLogin().setPassword(password);
		
		System.out.println();
		
		if (gl.accesoValidado(mav)) {
			if (gl.registrado(mav)) {
				mav.setViewName("redirect:darBienvenida");
			} else {
				mav.setViewName("redirect:login");
			}
		} else {
			mav.setViewName("redirect:login");
		}

		return mav;
	}
	
	
	@RequestMapping("darBienvenida")
	private String frontalBienvenida() {		
		return "bienvenida";
	}
}

