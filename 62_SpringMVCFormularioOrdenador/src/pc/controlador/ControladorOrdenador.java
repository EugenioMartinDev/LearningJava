package pc.controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pc.modelo.entidad.Pedido;
import pc.modelo.negocio.GestorPedido;


@Controller
public class ControladorOrdenador {
	
	@Autowired
	private GestorPedido gp;
	
	@Autowired
	private Pedido p;
		
	//Creamos el servlet de entrada al get del usuario.
	@RequestMapping("formularioPC")
	public ModelAndView getFormularioPC(
			ModelAndView mav) {		
		mav.setViewName("formulario");
		return mav;
	}
	
	//Creamos el servlet para la redirección del formulario cuando se ejecute el submit.
	@RequestMapping("ServletFormulario")
	public ModelAndView recogerFormularioPC(
			ModelAndView mav, 
			 HttpServletRequest request) {

		List<String> listaPerifericos = new ArrayList<String>();

		
		p.setNombreCliente(request.getParameter("nombre"));
		p.setDireccion(request.getParameter("direccion"));
		p.setEmail(request.getParameter("email"));
		p.setComentario(request.getParameter("comentarios"));
		p.getOrdenador().setProcesador(request.getParameter("procesador"));
		p.getOrdenador().setRam(request.getParameter("ram"));

		if (request.getParameterValues("opciones") != null) {
			listaPerifericos = Arrays.asList(request.getParameterValues("opciones"));
		}
		p.getOrdenador().setListaPerifericos(listaPerifericos);
		
		if (gp.validar(p)) {
			System.out.println(p);
			mav.setViewName("exito");
		} else
		{
			mav.addObject("error", "ERROR!! No ha rellenado adecuadamente el formulario");
			mav.setViewName("formulario");
		}
		return mav;
	}
}
