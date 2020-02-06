package curso.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import curso.modelo.entidades.Pedido;
import curso.modelo.negocio.GestorPedido;

@Controller
public class ControladorPedido {
	
	@Autowired
	private Pedido pedido;
	
	@Autowired
	private GestorPedido gp;
	
	@RequestMapping(path = "mostrarFormulario")
	public String irAFormulario() {
		
		return "formulario";
	}
	
	@RequestMapping(path = "doFormulario")
	public ModelAndView procesarFormulario(
			@RequestParam("nombre")String nombre,
			@RequestParam("direccion")String direccion,
			@RequestParam("email")String email,
			@RequestParam(name = "ram", required = false)String ram,
			@RequestParam(name = "procesador", required = false)String procesador,
			@RequestParam("comentarios")String comentarios,
			@RequestParam(name = "opciones", required = false)List<String> opciones,
			ModelAndView mav,
			RedirectAttributes redirectAttributes) {
		
		pedido.setNombreCliente(nombre);
		pedido.setDireccion(direccion);
		pedido.setEmail(email);
		pedido.setComentario(comentarios);
		pedido.getOrdenador().setProcesador(procesador);
		pedido.getOrdenador().setRam(ram);
		pedido.getOrdenador().setListaPerifericos(opciones);
		
		if (gp.validar()) {
			mav.addObject("pedido", pedido);
			mav.setViewName("redirect:final");
		} else {
			mav.addObject("error", "Faltan datos");
			mav.setViewName("redirect:mostrarFormulario");
		}		
		
		redirectAttributes.addAttribute("pedido", pedido);
		return mav;
	}
	
	@RequestMapping(path = "final", method = RequestMethod.GET)
	public String irAFinal() {		
		return "final";
	}
	
}
