package login.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import login.modelo.entidad.Login;

public class ControladorLogin {

	@Autowired
	private Login login;
	
	@RequestMapping("login")
	private String login() {
		return "formulario";
	}
	
	@RequestMapping("doLogin")
	private ModelAndView altaLogin(ModelAndView mav,
			@RequestParam(name="usuario", required=false)String usuario,
			@RequestParam(name="password", required=false)String password) {
		
		
		login.setUsuario(usuario);
		login.setPassword(password);
		
		System.out.println(login);
		
		mav.addObject("usuario", usuario);
		mav.setViewName("bienvenida");
		
		return mav;
	}
	
	
	@RequestMapping("registrarse")
	private String pedirRegistro() {
		
		
		return "registrarse";
	}
	
}
