package login.controladores;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import login.modelo.entidad.Detalle;
import login.modelo.entidad.Login;
import login.modelo.negocio.GestorLogin;

@Controller
public class ControladorLogin {

	@Autowired
	private Login login;
	
	@Autowired
	private GestorLogin gl;
	
	private static Map<String, Detalle> datosDetalle;
	
	@RequestMapping("inicioLogin")
	public ModelAndView inicioLogin(ModelAndView mav) {
		mav.setViewName("formulario");		
		return mav;
	}

	@RequestMapping("ServletFormulario")
	public ModelAndView recogerFormulario(
			ModelAndView mav, 
			 HttpServletRequest request) {

		String usuario = request.getParameter("usuario");
		String contraseña = request.getParameter("contraseña");
		
		login.setUsuario(usuario);
		login.setContraseña(contraseña);

		boolean validado = gl.validar(login);
		
		if(validado) {
			System.out.println("Login validado: " + login);
			mav.addObject("usuario", login.getUsuario());
			mav.setViewName("bienvenida");
		}else {
			System.out.println("Pedido NO validado: " + login);
			mav.addObject("error", "ERROR!!! No ha rellenado adecuadamente el formulario");
			mav.setViewName("formulario");
		}
		
		return mav;
	}
	
	@RequestMapping("bienvenida")
	public ModelAndView bienvenida(ModelAndView mav,
			@RequestParam("usuario")String usuario) {
		mav.addObject("usuario", usuario);
		mav.setViewName("bienvenida");		
		return mav;
	}
	
	@RequestMapping("ServletDetalle")
	public ModelAndView mostrarDetalle(
			ModelAndView mav, 
			@RequestParam("usuario")String usuario) {

		initDatosDetalle();

		if(datosDetalle.get(usuario) != null) {
			Detalle detalle = datosDetalle.get(usuario);
			System.out.println("detalle encontrado: " + detalle);
			mav.addObject("usuario", usuario);
			mav.addObject("detalle", detalle);
			mav.setViewName("detalle");
		}else {
			System.out.println("No existe detalle del usuario : " + usuario);
			mav.addObject("error", "ERROR!!! No existe detalle del usuario");
			mav.setViewName("bienvenida");

		}
		
		return mav;
	}
	

	public static void initDatosDetalle() {
		
		datosDetalle = new HashMap<String, Detalle>();
		
		Detalle detalle = new Detalle();
		detalle.setNombre("Jose");
		detalle.setDireccion("Madrid");
		detalle.setEdad(38);
		detalle.setPeso(85);
		datosDetalle.put(detalle.getNombre(), detalle);
		
		Detalle detalle1 = new Detalle();
		detalle1.setNombre("Juan");
		detalle1.setDireccion("Cáceres");
		detalle1.setEdad(47);
		detalle1.setPeso(98);
		datosDetalle.put(detalle1.getNombre(), detalle1);
		
		Detalle detalle2 = new Detalle();
		detalle2.setNombre("Pablo");
		detalle2.setDireccion("Bilbao");
		detalle2.setEdad(23);
		detalle2.setPeso(72);
		datosDetalle.put(detalle2.getNombre(), detalle2);
		
	}
	
}
