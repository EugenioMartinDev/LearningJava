package curso.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.modelo.entidad.Ordenador;
import curso.modelo.entidad.Pedido;
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
	
	//con required le decimos que no es obligatorio
	//este parametro para que funcione
	@RequestMapping(path = "doFormulario")
	public ModelAndView procesarFormulario(
			@RequestParam("nombre") String n,
			@RequestParam("direccion") String d,
			@RequestParam("email") String e,
			@RequestParam(name = "ram", required = false) String r,
			@RequestParam(name = "procesador", required = false) String p,
			@RequestParam(name = "opciones", required = false) List<String> o,
			@RequestParam("comentarios") String c,
			ModelAndView mav) {
		
		//Classic way
		//Ordenador or = new Ordenador();
		//Pedido pe = new Pedido();
		//pe.setOrdenador(or);
		pedido.setNombreCliente(n);
		pedido.setDireccion(d);
		pedido.setEmail(e);
		pedido.setComentario(c);
		pedido.getOrdenador().setRam(r);
		pedido.getOrdenador().setProcesador(p);
		pedido.getOrdenador().setListaPerifericos(o);
		
		//Classic way
		//boolean validado = gp.validar(pedido);
		
		//Spring way
		boolean validado = gp.validar();
		
		if(validado) {
			//para pasar datos por parametro hay que hacerlo de 
			//esta manera
			mav.getModelMap().addAttribute("nombre", pedido.getNombreCliente());
			mav.getModelMap().addAttribute("direccion", pedido.getDireccion());
			mav.getModelMap().addAttribute("email", pedido.getEmail());
			mav.getModelMap().addAttribute("ram", pedido.getOrdenador().getRam());
			mav.getModelMap().addAttribute("procesador", pedido.getOrdenador().getProcesador());
			mav.getModelMap().addAttribute("comentario", pedido.getComentario());
			mav.getModelMap().addAttribute("listaPerifericos", pedido.getOrdenador().getListaPerifericos());
			mav.setViewName("redirect:final");
		}else {
			mav.addObject("error", "Faltan datos");
			mav.setViewName("redirect:mostrarFormulario");
		}
		return mav;
	}

	@RequestMapping("final")
	public String mostrarFinal() {
		return "final";
	}
}
